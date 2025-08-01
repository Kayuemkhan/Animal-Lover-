package code.fortomorrow.animallover.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyprofileActivity extends AppCompatActivity {
    private ImageView backfrommyprofile,petprofilepic;
    private TextView mypet,mypetcolor,mypetgender;
    private DatabaseReference databaseReference;
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
//        usernameOftheUser.setText(String.valueOf(SharedPref.read("username","")));
        mypet.setText(String.valueOf(SharedPref.read("Animal", "")));
        backfrommyprofile = findViewById(R.id.backfrommyprofile);
        backfrommyprofile.setOnClickListener(v -> {
            startActivity(new Intent(MyprofileActivity.this,HomeActivity.class));
            finish();
        });
    }

    private void init() {
        mypet = findViewById(R.id.mypet);
        mypetcolor = findViewById(R.id.mypetcolor);
        mypetgender = findViewById(R.id.mypetgender);
        petprofilepic = findViewById(R.id.petprofilepic);
    }
}