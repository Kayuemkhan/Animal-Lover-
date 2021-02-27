package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HealthActivity extends AppCompatActivity {
    private LinearLayout medicinecard,diseasecard,firstAidCard;
    private ImageView backfrommyhealth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        init();
        medicinecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this, MedicinePetActivity.class));
            }
        });
        firstAidCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this,FirstAidActivity.class));
            }
        });
        diseasecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this,DiseaseActivity.class));
            }
        });
        backfrommyhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this,HomeActivity.class));
            }
        });
    }

    private void init() {
        medicinecard = findViewById(R.id.medicinecard);
        backfrommyhealth = findViewById(R.id.backfrommyhealth);
        diseasecard = findViewById(R.id.diseasecard);
        firstAidCard = findViewById(R.id.firstAidCard);
    }
}