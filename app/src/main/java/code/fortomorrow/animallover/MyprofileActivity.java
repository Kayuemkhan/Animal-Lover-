package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyprofileActivity extends AppCompatActivity {
    private ImageView backfrommyprofile,petprofilepic;
    private TextView phoneNumber,mypet,mypetcolor,mypetgender,usernameOftheUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
       init();
        SharedPref.init(MyprofileActivity.this);
        if (SharedPref.read("Animal", "").contains("dog")) {
            petprofilepic.setImageResource(R.drawable.dog);
        }
        if (SharedPref.read("Animal", "").contains("cat")) {
            petprofilepic.setImageResource(R.drawable.cat);
        }
        if (SharedPref.read("Animal", "").contains("rabbit")) {
            petprofilepic.setImageResource(R.drawable.rabbit);
        }
        if (SharedPref.read("Animal", "").contains("fish")) {
            petprofilepic.setImageResource(R.drawable.fish);
        }
        if (SharedPref.read("Animal", "").contains("bird")) {
            petprofilepic.setImageResource(R.drawable.bird);
        }
        Log.d("useree",String.valueOf(SharedPref.read("username","")));
        usernameOftheUser.setText(String.valueOf(SharedPref.read("username","")));
        phoneNumber.setText(String.valueOf(SharedPref.read("Phone","")));
        mypet.setText(String.valueOf(SharedPref.read("Animal", "")));
        phoneNumber.setText(String.valueOf(SharedPref.read("Phone","")));
        phoneNumber.setText(String.valueOf(SharedPref.read("Phone","")));
        backfrommyprofile = findViewById(R.id.backfrommyprofile);
        backfrommyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyprofileActivity.this,HomeActivity.class));
                finish();
            }
        });
    }

    private void init() {
        phoneNumber = findViewById(R.id.username);
        mypet = findViewById(R.id.mypet);
        mypetcolor = findViewById(R.id.mypetcolor);
        mypetgender = findViewById(R.id.mypetgender);
        petprofilepic = findViewById(R.id.petprofilepic);
        usernameOftheUser = findViewById(R.id.usernameOftheUser);
    }
}