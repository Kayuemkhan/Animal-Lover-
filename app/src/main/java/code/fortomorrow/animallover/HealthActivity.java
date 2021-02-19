package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthActivity extends AppCompatActivity {
    private CardView medicinecard,diseasecard,healthcard;
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
    }

    private void init() {
        medicinecard = findViewById(R.id.medicinecard);
        diseasecard = findViewById(R.id.diseasecard);
        healthcard = findViewById(R.id.healthcard);
    }
}