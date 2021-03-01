package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private String animal,petBirthday,petColor;
    private EditText yourplaceET;
    String petnamelist[] = {"Rabbit", "Cat", "Dog", "Bird", "Fish"};
    String gen[] = {"Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        SharedPref.init(this);
        init();
        if (SharedPref.read("Animal", "").contains("dog") && !String.valueOf(SharedPref.read("Animal", "")).isEmpty()) {
            animal = "dog";
            imageView.setImageResource(R.drawable.dog);
            petnameSetET.setText("dog");
        }
        if (SharedPref.read("Animal", "").contains("cat") && !String.valueOf(SharedPref.read("Animal", "")).isEmpty()) {
            animal = "cat";
            imageView.setImageResource(R.drawable.cat);
            petnameSetET.setText("cat");
        }
        if (SharedPref.read("Animal", "").contains("rabbit") && !String.valueOf(SharedPref.read("Animal", "")).isEmpty()) {
            animal = "rabbit";
            imageView.setImageResource(R.drawable.rabbit);
            petnameSetET.setText("rabbit");
        }
        if (SharedPref.read("Animal", "").contains("fish") && !String.valueOf(SharedPref.read("Animal", "")).isEmpty()) {
            animal = "fish";
            imageView.setImageResource(R.drawable.fish);
            petnameSetET.setText("fish");
        }
        if (SharedPref.read("Animal", "").contains("bird") && !String.valueOf(SharedPref.read("Animal", "")).isEmpty()) {
            animal = "bird";
            imageView.setImageResource(R.drawable.bird);
            petnameSetET.setText("bird");
        }
        savePetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyPetActivity.this,HomeActivity.class));
                finish();
            }
        });
        petBirthDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                petBirthday= s.toString();
                SharedPref.write("PetBirthDay",petBirthday);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        petColorET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                petColor= s.toString();
                SharedPref.write("petColor",petBirthday);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        spinnerGenderid.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, gen));
        spinnerGenderid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (animal.equals("Male")) {
                    mypetSpinnerSet.setSelection(0);
                }
                if (animal.equals("Female")) {
                    mypetSpinnerSet.setSelection(1);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mypetSpinnerSet.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, petnamelist));
        mypetSpinnerSet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (animal.equals("cat")) {
                    mypetSpinnerSet.setSelection(1);
                }
                if (animal.equals("dog")) {
                    mypetSpinnerSet.setSelection(1);
                }
                if (animal.equals("rabbit")) {
                    mypetSpinnerSet.setSelection(0);
                }
                if (animal.equals("bird")) {
                    mypetSpinnerSet.setSelection(3);
                }
                if (animal.equals("fish")) {
                    mypetSpinnerSet.setSelection(4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        yourplaceET = findViewById(R.id.yourplaceET);
    }
}