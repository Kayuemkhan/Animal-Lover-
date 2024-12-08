    package code.fortomorrow.animallover.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import code.fortomorrow.animallover.R;

    public class DiseaseActivity extends AppCompatActivity {
    private ImageView backfromdisease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        backfromdisease = findViewById(R.id.backfromdisease);
        backfromdisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DiseaseActivity.this,HealthActivity.class));
                finish();
            }
        });
    }
}