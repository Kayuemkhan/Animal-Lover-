package code.fortomorrow.animallover;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.AllAdoptPetsModel;
import code.fortomorrow.animallover.adapters.PetAdoptAdapters;
import code.fortomorrow.animallover.utils.SharedPref;

public class AdoptPetActivityDetails extends AppCompatActivity {
    private ImageView adoptPetDetailsIV;
    private TextView adoptPetDetailsNameTV,genderAdoptPet,adoptPetDetailsbreedIV,adoptPetDetailsPetsColorTV,
            adoptPetDetailsHabitsTV,adoptPetDetailsWeightTV,adoptPetDetailsAGeTV,adoptPetDetailsWeightadoptmeTV;
    private String pid;
    private DatabaseReference databaseReference;
    private List<AllAdoptPetsModel> allAdoptPetsModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet_details);
        init();
        SharedPref.init(AdoptPetActivityDetails.this);
        pid =  SharedPref.read("pid","");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");
        allAdoptPetsModels = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");
       getProductDetais(pid);
    }

    private void getProductDetais(String pid) {
        databaseReference.child(pid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AllAdoptPetsModel allAdoptPetsModel = snapshot.getValue(AllAdoptPetsModel.class);
                adoptPetDetailsNameTV.setText(allAdoptPetsModel.getPetsName());
                genderAdoptPet.setText(allAdoptPetsModel.getPetsSex());
                adoptPetDetailsbreedIV.setText(allAdoptPetsModel.getPetsBreed());
                adoptPetDetailsPetsColorTV.setText(allAdoptPetsModel.getPetsColor());
                adoptPetDetailsHabitsTV.setText(allAdoptPetsModel.getPetsHabbit());
                adoptPetDetailsWeightTV.setText(allAdoptPetsModel.getPetsWeight()+" KG");
                adoptPetDetailsAGeTV.setText(allAdoptPetsModel.getPetsAge()+" Years ");
                Glide.with(AdoptPetActivityDetails.this).load(allAdoptPetsModel.getImage()).into(adoptPetDetailsIV);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        adoptPetDetailsIV = findViewById(R.id.adoptPetDetailsIV);
        adoptPetDetailsNameTV = findViewById(R.id.adoptPetDetailsNameTV);
        genderAdoptPet = findViewById(R.id.genderAdoptPet);
        adoptPetDetailsbreedIV = findViewById(R.id.adoptPetDetailsbreedIV);
        adoptPetDetailsPetsColorTV = findViewById(R.id.adoptPetDetailsPetsColorTV);
        adoptPetDetailsHabitsTV = findViewById(R.id.adoptPetDetailsHabitsTV);
        adoptPetDetailsWeightTV = findViewById(R.id.adoptPetDetailsWeightTV);
        adoptPetDetailsAGeTV = findViewById(R.id.adoptPetDetailsAGeTV);
        adoptPetDetailsWeightadoptmeTV = findViewById(R.id.adoptPetDetailsWeightadoptmeTV);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

//    private void filtering(List<AllAdoptPetsModel> allAdoptPetsModels) {
//        for (int i =0;i<allAdoptPetsModels.size();i++){
//            if(allAdoptPetsModels.get(i).getPid() == pid){
//                Glide.with(AdoptPetActivityDetails.this).load(allAdoptPetsModels.get(i).getImage()).into(adoptPetDetailsIV);
//                adoptPetDetailsNameTV.setText(allAdoptPetsModels.get(i).getPetsName());
//                adoptPetDetailsNameTV.setText(allAdoptPetsModels.get(i).getPetsName());
//                genderAdoptPet.setText(allAdoptPetsModels.get(i).getPetsSex());
//                adoptPetDetailsbreedIV.setText(allAdoptPetsModels.get(i).getPetsBreed());
//                adoptPetDetailsPetsColorTV.setText(allAdoptPetsModels.get(i).getPetsColor());
//                adoptPetDetailsHabitsTV.setText(allAdoptPetsModels.get(i).getPetsHabbit());
//                adoptPetDetailsWeightTV.setText(allAdoptPetsModels.get(i).getPetsWeight());
//                adoptPetDetailsAGeTV.setText(allAdoptPetsModels.get(i).getPetsAge());
//            }
//        }
//    }
}