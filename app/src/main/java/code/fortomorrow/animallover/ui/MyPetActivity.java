package code.fortomorrow.animallover.ui;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.Toast;

import code.fortomorrow.animallover.R;
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
    private EditText yourplaceET;
    private String animal = "", petBirthday = "", petColor = "";
    String petnamelist[] = {"Rabbit", "Cat", "Dog", "Bird", "Fish"};
    String gen[] = {"Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        SharedPref.init(this);
        init();
        loadSavedData();
        setupListeners();
        setupSpinners();
    }

    private void loadSavedData() {
        String savedAnimal = SharedPref.read("Animal", "");
        if (!savedAnimal.isEmpty()) {
            if (savedAnimal.contains("dog")) {
                animal = "dog";
                imageView.setImageResource(R.drawable.dog);
                petnameSetET.setText("dog");
            } else if (savedAnimal.contains("cat")) {
                animal = "cat";
                imageView.setImageResource(R.drawable.cat);
                petnameSetET.setText("cat");
            } else if (savedAnimal.contains("rabbit")) {
                animal = "rabbit";
                imageView.setImageResource(R.drawable.rabbit);
                petnameSetET.setText("rabbit");
            } else if (savedAnimal.contains("fish")) {
                animal = "fish";
                imageView.setImageResource(R.drawable.fish);
                petnameSetET.setText("fish");
            } else if (savedAnimal.contains("bird")) {
                animal = "bird";
                imageView.setImageResource(R.drawable.bird);
                petnameSetET.setText("bird");
            }
        }

        // Load other saved data
        petBirthDay.setText(SharedPref.read("PetBirthDay", ""));
        petColorET.setText(SharedPref.read("petColor", ""));
        notesPet.setText(SharedPref.read("petNotes", ""));
        yourplaceET.setText(SharedPref.read("petLocation", ""));

        String savedGender = SharedPref.read("petGender", "");
        if (!savedGender.isEmpty()) {
            for (int i = 0; i < gen.length; i++) {
                if (gen[i].equals(savedGender)) {
                    spinnerGenderid.setSelection(i);
                    break;
                }
            }
        }
    }

    private void setupListeners() {
        savePetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        petBirthDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                petBirthday = s.toString();
                SharedPref.write("PetBirthDay", petBirthday);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        petColorET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                petColor = s.toString();
                SharedPref.write("petColor", petColor); // Fixed: was saving petBirthday instead of petColor
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setupSpinners() {
        // Gender Spinner
        spinnerGenderid.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gen));
        spinnerGenderid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGender = gen[position];
                SharedPref.write("petGender", selectedGender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Pet Type Spinner
        mypetSpinnerSet.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, petnamelist));
        mypetSpinnerSet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedPetType = petnamelist[position].toLowerCase();

                // Update the animal type and image based on selection
                animal = selectedPetType;
                updateAnimalDisplay(selectedPetType);
                SharedPref.write("Animal", selectedPetType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void updateAnimalDisplay(String animalType) {
        switch (animalType.toLowerCase()) {
            case "cat":
                imageView.setImageResource(R.drawable.cat);
                break;
            case "dog":
                imageView.setImageResource(R.drawable.dog);
                break;
            case "rabbit":
                imageView.setImageResource(R.drawable.rabbit);
                break;
            case "bird":
                imageView.setImageResource(R.drawable.bird);
                break;
            case "fish":
                imageView.setImageResource(R.drawable.fish);
                break;
        }
    }

    private void save() {
        // Get current values from UI components
        String petName = petnameSetET.getText().toString().trim();
        String petBirth = petBirthDay.getText().toString().trim();
        String petColorText = petColorET.getText().toString().trim();
        String notes = notesPet.getText().toString().trim();
        String location = yourplaceET.getText().toString().trim();

        // Get selected values from spinners
        String selectedAnimal = "";
        if (mypetSpinnerSet.getSelectedItem() != null) {
            selectedAnimal = mypetSpinnerSet.getSelectedItem().toString().toLowerCase();
        }

        String selectedGender = "";
        if (spinnerGenderid.getSelectedItem() != null) {
            selectedGender = spinnerGenderid.getSelectedItem().toString();
        }

        // Validate required fields
        if (petName.isEmpty()) {
            Toast.makeText(this, "Please enter pet name", Toast.LENGTH_SHORT).show();
            petnameSetET.requestFocus();
            return;
        }

        if (selectedAnimal.isEmpty()) {
            Toast.makeText(this, "Please select pet type", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save all data to SharedPreferences
        SharedPref.write("petName", petName);
        SharedPref.write("Animal", selectedAnimal);
        SharedPref.write("petGender", selectedGender);
        SharedPref.write("PetBirthDay", petBirth);
        SharedPref.write("petColor", petColorText);
        SharedPref.write("petNotes", notes);
        SharedPref.write("petLocation", location);

        // Update local variables
        animal = selectedAnimal;
        petBirthday = petBirth;
        petColor = petColorText;

        // Show success message
        Toast.makeText(this, "Pet details saved successfully!", Toast.LENGTH_SHORT).show();

        // Optional: Navigate back or to another activity
         finish(); // Uncomment if you want to close this activity after saving
        // startActivity(new Intent(this, MainActivity.class)); // Navigate to main activity
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