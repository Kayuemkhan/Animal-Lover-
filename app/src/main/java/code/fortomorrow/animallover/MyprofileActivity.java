package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyprofileActivity extends AppCompatActivity {
    private ImageView backfrommyprofile;
    private TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        SharedPref.init(MyprofileActivity.this);
        username = findViewById(R.id.username);
        username.setText(String.valueOf(SharedPref.read("Phone","")));
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