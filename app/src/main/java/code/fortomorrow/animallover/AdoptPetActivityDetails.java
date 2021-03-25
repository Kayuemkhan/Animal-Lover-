package code.fortomorrow.animallover;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.AllAdoptPetsModel;
import code.fortomorrow.animallover.adapters.PetAdoptAdapters;
import code.fortomorrow.animallover.utils.SharedPref;

public class AdoptPetActivityDetails extends AppCompatActivity {
    private ImageView adoptPetDetailsIV;
    private TextView adoptPetDetailsNameTV,genderAdoptPet,adoptPetDetailsbreedIV,adoptPetDetailsPetsColorTV,
            adoptPetDetailsHabitsTV,adoptPetDetailsWeightTV,adoptPetDetailsAGeTV,adoptPetDetailsWeightadoptmeTV;
    private String pid;
    private String phone_number;
    private DatabaseReference databaseReference,databaseReference2;
    private List<AllAdoptPetsModel> allAdoptPetsModels;
    private boolean haveToInsert = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet_details);
        init();
        SharedPref.init(AdoptPetActivityDetails.this);
        pid =  SharedPref.read("pid","");
        phone_number =SharedPref.read("Phone","");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");
        allAdoptPetsModels = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");
        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Ordered Pets");
        getProductDetais(pid);
        adoptPetDetailsWeightadoptmeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> productMap = new HashMap<>();
                for (int i =0;i<allAdoptPetsModels.size();i++){
                   if(allAdoptPetsModels.get(i).getPhone_number().contains(phone_number)){
                       haveToInsert = false;
                       Toast.makeText(AdoptPetActivityDetails.this,"You can't send req for your own pets",Toast.LENGTH_SHORT).show();
                       Log.d("state","here");
                       return;
                   }
                   else {
                       haveToInsert = true;
                       productMap.put("pid", allAdoptPetsModels.get(i).getPid());
                       productMap.put("date", allAdoptPetsModels.get(i).getDate());
                       productMap.put("time", allAdoptPetsModels.get(i).getTime());
                       productMap.put("petsName", allAdoptPetsModels.get(i).getPetsName());
                       productMap.put("petsAge", allAdoptPetsModels.get(i).getPetsAge());
                       productMap.put("petsSex", allAdoptPetsModels.get(i).getPetsSex());
                       productMap.put("petsHabbit", allAdoptPetsModels.get(i).getPetsHabbit());
                       productMap.put("petsPlace", allAdoptPetsModels.get(i).getPetsPlace());
                       productMap.put("petsColor", allAdoptPetsModels.get(i).getPetsColor());
                       productMap.put("image", allAdoptPetsModels.get(i).getImage());
                       productMap.put("petsWeight", allAdoptPetsModels.get(i).getPetsWeight());
                       productMap.put("petsBreed", allAdoptPetsModels.get(i).getPetsBreed());
                       productMap.put("phone_number",phone_number);
                   }
                }
                if(haveToInsert == true){
                    databaseReference2.child(phone_number).setValue(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(AdoptPetActivityDetails.this,"Pet adopt req sent",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AdoptPetActivityDetails.this,HomeActivity.class));
                            finish();
                        }
                    });
                }


            }
        });
    }

    private void getProductDetais(String pid) {
        databaseReference.child(pid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AllAdoptPetsModel allAdoptPetsModel = snapshot.getValue(AllAdoptPetsModel.class);
                allAdoptPetsModels.add(allAdoptPetsModel);
                Log.d("seeall",""+new Gson().toJson(allAdoptPetsModels));
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


}