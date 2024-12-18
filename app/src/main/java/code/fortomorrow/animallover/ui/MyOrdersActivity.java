package code.fortomorrow.animallover.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import code.fortomorrow.animallover.adapters.MyOrdersAdapters;
import code.fortomorrow.animallover.utils.SharedPref;

public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView myOrders;
    private DatabaseReference databaseReference;
    private List<AllAdoptPetsModel> myOrdersListData;
    private List<AllAdoptPetsModel> myOrdersListData2;
    private String phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        SharedPref.init(this);
        phone_number = SharedPref.read("Phone", "");
        myOrders = findViewById(R.id.myOrders);
        myOrders.setLayoutManager(new LinearLayoutManager(MyOrdersActivity.this));
        myOrdersListData = new ArrayList<>();
        myOrdersListData2 = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Ordered Pets");
        Log.d("State","I'm here");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                AllAdoptPetsModel orders = snapshot.getValue(AllAdoptPetsModel.class);
                myOrdersListData.add(orders);
                for(int i =0;i<myOrdersListData.size();i++){
                    if(myOrdersListData.get(i).getPhone_number() == phone_number ){
                        myOrdersListData2.add(myOrdersListData.get(i));
                    }
                }
                Log.d("checkorderlist", "here"+new Gson().toJson(myOrdersListData));

                myOrders.setAdapter(new MyOrdersAdapters(MyOrdersActivity.this,myOrdersListData2,phone_number));
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
}