package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyPetActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText petnameSetET;
    private Spinner mypetSpinnerSet;
    private Spinner spinnerGenderid;
    private EditText petBirthDay;
    private EditText petColorET;
    private EditText notesPet;
    private TextView savePetDetails;
    private String animal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        SharedPref.init(this);
        init();
        if(SharedPref.read("Animal","").contains("dog")){
            animal = "dog";
            imageView.setImageResource(R.drawable.dog);
        }
        if(SharedPref.read("Animal","").contains("cat")){
            imageView.setImageResource(R.drawable.cat);
        }
        if(SharedPref.read("Animal","").contains("rabbit")){
            imageView.setImageResource(R.drawable.rabbit);
        }
        if(SharedPref.read("Animal","").contains("fish")){
            imageView.setImageResource(R.drawable.fish);
        }
        if(SharedPref.read("Animal","").contains("bird")){
            imageView.setImageResource(R.drawable.bird);
        }

    }

    private void init() {
        imageView = findViewById(R.id.imageView);
        petnameSetET = findViewById(R.id.petnameSetET);
        mypetSpinnerSet = findViewById(R.id.mypetSpinnerSet);
        spinnerGenderid = findViewById(R.id.spinnerGenderid);
        petBirthDay = findViewById(R.id.petBirthDay);
        petColorET = findViewById(R.id.petColorET);
        notesPet = findViewById(R.id.notesPet);
        savePetDetails = findViewById(R.id.savePetDetails);
    }
}