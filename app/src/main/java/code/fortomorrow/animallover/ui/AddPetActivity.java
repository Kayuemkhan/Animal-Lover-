package code.fortomorrow.animallover.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import code.fortomorrow.animallover.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import code.fortomorrow.animallover.utils.SharedPref;

public class AddPetActivity extends AppCompatActivity {
    private ImageView select_product_image;
    private EditText pets_name, pets_age, pets_habit, pets_place, petColor, petweight, petbredd;
    private Spinner petSex;
    private String petSelectedSex;
    private TextView addNewPet;
    private StorageReference ProductImagesRef;
    private DatabaseReference ProductsRef;
    private static final int GalleryPick = 1;
    private Uri ImageUri;
    private ProgressDialog loadingBar;
    private String downloadImageUrl;
    String saveCurrentDate;
    String productRandomKey;
    String saveCurrentTime;
    private String phone_number;
    private String petsName, petsAge, petsHabbit, petsPlace, petsColor, petsWeight, petsBreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        init();
        SharedPref.init(this);
        phone_number = String.valueOf(SharedPref.read("Phone", ""));

        loadingBar = new ProgressDialog(this);
        ProductImagesRef = FirebaseStorage.getInstance().getReference().child("Product Images");
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");
        select_product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });
        petSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                petSelectedSex = petSex.getSelectedItem().toString();
                Log.d("petsee", "onItemSelected: " + petSelectedSex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addNewPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateRequest();
            }
        });
    }

    private void validateRequest() {
        petsName = pets_name.getText().toString();
        petsAge = pets_age.getText().toString();
        petsHabbit = pets_habit.getText().toString();
        petsPlace = pets_place.getText().toString();
        petsColor = petColor.getText().toString();
        petsWeight = petweight.getText().toString();
        petsBreed = petbredd.getText().toString();
        if (petsName.isEmpty()) {
            pets_name.setError("Please give a pet name");
        } else if (petsAge.isEmpty()) {
            pets_age.setError("Please give a pet age");
        } else if (petsHabbit.isEmpty()) {
            pets_habit.setError("Please give a pet Habbit");
        } else if (petsPlace.isEmpty()) {
            pets_place.setError("Please give a pet's living Place");
        } else if (petsColor.isEmpty()) {
            petColor.setError("Please give a pet's Color");
        } else if (petsWeight.isEmpty()) {
            petweight.setError("Please give a pet weight");
        } else if (petsBreed.isEmpty()) {
            petbredd.setError("Please give a pet breed");
        } else {
            addingNewPet();
        }

    }

    private void addingNewPet() {
        loadingBar.setTitle("Add New Pet");
        loadingBar.setMessage("Dear Pet's Owner, please wait while we are adding the new product.");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime +phone_number;


        final StorageReference filePath = ProductImagesRef.child(ImageUri.getLastPathSegment() + productRandomKey + ".jpg");

        final UploadTask uploadTask = filePath.putFile(ImageUri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message = e.toString();
                loadingBar.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            downloadImageUrl = task.getResult().toString();

                            SaveProductInfoToDatabase();
                        }
                    }
                });
            }
        });
    }

    private void SaveProductInfoToDatabase() {
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("pid", productRandomKey);
        productMap.put("date", saveCurrentDate);
        productMap.put("time", saveCurrentTime);
        productMap.put("petsName", petsName);
        productMap.put("petsAge", petsAge);
        productMap.put("petsSex", petSelectedSex);
        productMap.put("petsHabbit", petsHabbit);
        productMap.put("petsPlace", petsPlace);
        productMap.put("petsColor", petsColor);
        productMap.put("image", downloadImageUrl);
        productMap.put("petsWeight", petsWeight);
        productMap.put("petsBreed", petsBreed);
        productMap.put("phone_number", phone_number);

        ProductsRef.child(productRandomKey).updateChildren(productMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(AddPetActivity.this, HomeActivity.class);
                            startActivity(intent);
                            loadingBar.dismiss();
                            Toast.makeText(AddPetActivity.this, "Product is added successfully..", Toast.LENGTH_SHORT).show();
                        } else {
                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(AddPetActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void OpenGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GalleryPick && resultCode == RESULT_OK && data != null) {
            ImageUri = data.getData();
            select_product_image.setImageURI(ImageUri);
        }
    }

    private void init() {
        select_product_image = findViewById(R.id.select_product_image);
        pets_name = findViewById(R.id.pets_name);
        pets_age = findViewById(R.id.pets_age);
        pets_habit = findViewById(R.id.pets_habit);
        pets_place = findViewById(R.id.pets_place);
        petColor = findViewById(R.id.pet_Color);
        petweight = findViewById(R.id.petweight);
        petbredd = findViewById(R.id.petbredd);
        petSex = findViewById(R.id.petSex);
        addNewPet = findViewById(R.id.add_new_product);

    }
}