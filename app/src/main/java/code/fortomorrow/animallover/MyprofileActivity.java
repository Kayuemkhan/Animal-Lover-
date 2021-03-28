package code.fortomorrow.animallover;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyprofileActivity extends AppCompatActivity {
    private ImageView backfrommyprofile,petprofilepic;
    private TextView phoneNumber,mypet,mypetcolor,mypetgender,usernameOftheUser,deletethisaccount;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
       init();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
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
        usernameOftheUser.setText(String.valueOf(SharedPref.read("username","")));
        phoneNumber.setText(String.valueOf(SharedPref.read("Phone","")));
        mypet.setText(String.valueOf(SharedPref.read("Animal", "")));
        phoneNumber.setText(String.valueOf(SharedPref.read("Phone","")));
        backfrommyprofile = findViewById(R.id.backfrommyprofile);
        backfrommyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyprofileActivity.this,HomeActivity.class));
                finish();
            }
        });
        deletethisaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence options[] = new CharSequence[]{
                        "Yes",
                        "No"
                };
                AlertDialog.Builder builder = new  AlertDialog.Builder(MyprofileActivity.this);
                builder.setTitle("Would you like to delete your account?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if(i== 0){
                            databaseReference.child(String.valueOf(SharedPref.read("Phone",""))).removeValue();
                            SharedPref.write("Visited","");
                            SharedPref.write("LOGGEDIN","");
                            SharedPref.write("username","");
                            SharedPref.write("Phone","");

                            startActivity(new Intent(MyprofileActivity.this,MainActivity.class));
                        }
                        else {
                            finish();
                        }
                    }


                });

                builder.show();

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
        deletethisaccount = findViewById(R.id.deletethisaccount);
    }
}