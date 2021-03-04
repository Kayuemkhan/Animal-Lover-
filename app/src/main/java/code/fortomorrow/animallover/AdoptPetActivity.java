package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.PetAdoptAdapters;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;

public class AdoptPetActivity extends AppCompatActivity {
    private RecyclerView petrecylerview;
    private List<ProfessionalData>  professionalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet);
        petrecylerview = findViewById(R.id.petrecylerview);
        petrecylerview.setLayoutManager(new GridLayoutManager(AdoptPetActivity.this, 2));
        professionalData= new ArrayList<>();
        professionalData.add(new ProfessionalData (R.drawable.peta, "Mew", "Dhaka","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petb, "Rao", "CTG","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petc, "Piano", "Rajshai","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petd, "Arr", "ara","","","",""));
        petrecylerview.setAdapter(new PetAdoptAdapters(AdoptPetActivity.this,professionalData));

    }
}