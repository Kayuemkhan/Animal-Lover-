package code.fortomorrow.animallover.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import code.fortomorrow.animallover.R;

public class FirstAidActivity extends AppCompatActivity {
    private ImageView backfromfirstaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
        backfromfirstaid = findViewById(R.id.backfromfirstaid);
        backfromfirstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAidActivity.this,HealthActivity.class));
                finish();
            }
        });
    }
}