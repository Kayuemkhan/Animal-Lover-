package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.PetAdoptAdapters;

public class AdoptPetActivity extends AppCompatActivity {
    private RecyclerView petrecylerview;
    private List<ProfessionalData>  professionalData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet);
        petrecylerview = findViewById(R.id.petrecylerview);
        FloatingActionButton fab= findViewById(R.id.animaladd);

        petrecylerview.setLayoutManager(new LinearLayoutManager(AdoptPetActivity.this));
        professionalData= new ArrayList<>();
        professionalData.add(new ProfessionalData (R.drawable.peta, "Mew", "Dhaka","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petb, "Rao", "CTG","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petc, "Piano", "Rajshai","","","",""));
        professionalData.add(new ProfessionalData (R.drawable.petd, "Arr", "ara","","","",""));
        petrecylerview.setAdapter(new PetAdoptAdapters(AdoptPetActivity.this,professionalData));
        fab.setOnClickListener(v ->
                startActivity(new Intent(AdoptPetActivity.this,AddPetActivity.class)));
    }
}