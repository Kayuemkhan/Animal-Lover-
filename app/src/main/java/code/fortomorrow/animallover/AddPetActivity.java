package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddPetActivity extends AppCompatActivity {
    private LinearLayout select_product_image;
    private EditText pets_name,pets_age,pets_habit,pets_place,petColor,petweight,petbredd;
    private Spinner petSex;
    private TextView add_new_product;
    private StorageReference ProductImagesRef;
    private DatabaseReference ProductsRef;
    private static final int GalleryPick = 1;
    private Uri ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        init();
        ProductImagesRef = FirebaseStorage.getInstance().getReference().child("Product Images");
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");
        select_product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
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
//            select_product_image.setImageURI(ImageUri);
        }
    }

    private void init() {
        select_product_image = findViewById(R.id.select_product_image);
        pets_name = findViewById(R.id.pets_name);
        pets_age = findViewById(R.id.pets_age);
        pets_habit = findViewById(R.id.pets_habit);
        pets_place = findViewById(R.id.pets_place);
        petColor = findViewById(R.id.petColor);
        petweight = findViewById(R.id.petweight);
        petbredd = findViewById(R.id.petbredd);
        petSex = findViewById(R.id.petSex);
        add_new_product = findViewById(R.id.add_new_product);


    }
}