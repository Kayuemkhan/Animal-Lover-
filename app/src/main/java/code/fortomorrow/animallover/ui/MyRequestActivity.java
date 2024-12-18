package code.fortomorrow.animallover.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import code.fortomorrow.animallover.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.model.AllAdoptPetsModel;
import code.fortomorrow.animallover.adapters.MyRequestAdapters;
import code.fortomorrow.animallover.utils.SharedPref;

public class MyRequestActivity extends AppCompatActivity {
    private RecyclerView myOrders;
    private DatabaseReference databaseReference;
    private List<AllAdoptPetsModel> myOrdersListData;
    private List<AllAdoptPetsModel> myOrdersListData2;
    private String phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_request);
        SharedPref.init(this);
        phone_number = SharedPref.read("Phone", "");
        myOrders = findViewById(R.id.myOrders);
        myOrders.setLayoutManager(new LinearLayoutManager(MyRequestActivity.this));
        myOrdersListData = new ArrayList<>();
        myOrdersListData2 = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Ordered Pets");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                AllAdoptPetsModel orders = snapshot.getValue(AllAdoptPetsModel.class);
                myOrdersListData.add(orders);
                Log.d("aaaa111", "here"+new Gson().toJson(myOrdersListData));
                for(int i =0;i<myOrdersListData.size();i++){
                    if(String.valueOf(myOrdersListData.get(i).getPid()).contains(phone_number)){
                        myOrdersListData2.add(myOrdersListData.get(i));
                    }
                }
                myOrders.setAdapter(new MyRequestAdapters(MyRequestActivity.this,myOrdersListData2,phone_number));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void accpetOrder(String phone_number) {
        CharSequence options[] = new CharSequence[]{
                "Yes",
                "No"
        };
        AlertDialog.Builder builder = new  AlertDialog.Builder(MyRequestActivity.this);
        builder.setTitle("Would you like to accept this order?");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i== 0){
                    String uID = phone_number;
                    RemoveOrder(uID);
                }
                else {
                    finish();
                }
            }

            private void RemoveOrder(String uID) {
                databaseReference.child(uID).removeValue();
                startActivity(new Intent(MyRequestActivity.this,HomeActivity.class));
            }
        });

        builder.show();

    }

    public void callme(String phone_number) {
        String mobileNumber = phone_number;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL); // Action for what intent called for
        intent.setData(Uri.parse("tel: " + mobileNumber)); // Data with intent respective action on intent
        startActivity(intent);
    }
}