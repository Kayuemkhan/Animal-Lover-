package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MedicinePetActivity extends AppCompatActivity {
    private CardView carmedicinecard,birdmedicinecard,dogmedicinecard,fishmedicinecard,rabbitMedicinefood;
    private ImageView backfromedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinepet_details);
        init();
        carmedicinecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicinePetActivity.this,SingleMedicineActivity.class);
                intent.putExtra("animalm","cat");
                startActivity(intent);
            }
        });
        rabbitMedicinefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicinePetActivity.this,SingleMedicineActivity.class);
                intent.putExtra("animalm","rabbit");
                startActivity(intent);
            }
        });
        fishmedicinecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicinePetActivity.this,SingleMedicineActivity.class);
                intent.putExtra("animalm","fish");
                startActivity(intent);
            }
        });
        birdmedicinecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicinePetActivity.this,SingleMedicineActivity.class);
                intent.putExtra("animalm","bird");
                startActivity(intent);
            }
        });
//        dogmedicinecard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MedicinePetActivity.this,SingleMedicineActivity.class);
//                intent.putExtra("animalm","bird");
//                startActivity(intent);
//            }
//        });
        backfromedicine.setOnClickListener(v -> {
            startActivity(new Intent(MedicinePetActivity.this,HealthActivity.class));
            finish();
        });
    }

    private void init() {
        carmedicinecard= findViewById(R.id.carmedicinecard);
        birdmedicinecard= findViewById(R.id.birdmedicinecard);
        dogmedicinecard= findViewById(R.id.dogmedicinecard);
        fishmedicinecard= findViewById(R.id.fishmedicinecard);
        rabbitMedicinefood= findViewById(R.id.rabbitMedicinefood);
        backfromedicine= findViewById(R.id.backfromedicine);

    }
}