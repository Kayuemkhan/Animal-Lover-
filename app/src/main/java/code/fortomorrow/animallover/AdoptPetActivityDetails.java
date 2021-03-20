package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.utils.SharedPref;

public class AdoptPetActivityDetails extends AppCompatActivity {
    private ImageView adoptPetDetailsIV;
    private TextView adoptPetDetailsNameTV,genderAdoptPet,adoptPetDetailsbreedIV,adoptPetDetailsPetsColorTV,
            adoptPetDetailsHabitsTV,adoptPetDetailsWeightTV,adoptPetDetailsAGeTV,adoptPetDetailsWeightadoptmeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet_details);
        init();
        SharedPref.init(AdoptPetActivityDetails.this);
        SharedPref.read("pid","");
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