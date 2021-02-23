package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyprofileActivity extends AppCompatActivity {
    private ImageView backfrommyprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        backfrommyprofile = findViewById(R.id.backfrommyprofile);
        backfrommyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyprofileActivity.this,HomeActivity.class));
                finish();
            }
        });
    }
}