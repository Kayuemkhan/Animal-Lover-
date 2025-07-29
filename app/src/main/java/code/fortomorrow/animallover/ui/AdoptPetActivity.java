package code.fortomorrow.animallover.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import code.fortomorrow.animallover.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.model.AllAdoptPetsModel;
import code.fortomorrow.animallover.adapters.PetAdoptAdapters;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class AdoptPetActivity extends AppCompatActivity {
    private RecyclerView petrecylerview;
    private DatabaseReference databaseReference;
    private List<AllAdoptPetsModel> allAdoptPetsModels;
    private ShimmerLayout mShimmerViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        mShimmerViewContainer.startShimmerAnimation();

        petrecylerview = findViewById(R.id.petrecylerview);
        FloatingActionButton fab= findViewById(R.id.animaladd);
        allAdoptPetsModels = new ArrayList<>();
        petrecylerview.setLayoutManager(new LinearLayoutManager(AdoptPetActivity.this));
        allAdoptPetsModels = new ArrayList<>();

        fab.setOnClickListener(v ->
                startActivity(new Intent(AdoptPetActivity.this,AddPetActivity.class)));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                AllAdoptPetsModel orders = snapshot.getValue(AllAdoptPetsModel.class);
                allAdoptPetsModels.add(orders);
                Log.d("aaaa111", "here"+new Gson().toJson(allAdoptPetsModels));
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
                petrecylerview.setAdapter(new PetAdoptAdapters(AdoptPetActivity.this,allAdoptPetsModels));
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

    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
}