package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import code.fortomorrow.animallover.utils.SharedPref;

public class HomeActivity extends AppCompatActivity {
    private ImageView imginhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imginhome = findViewById(R.id.imginhome);
        SharedPref.init(HomeActivity.this);
        SharedPreferences pref;
        pref = HomeActivity.this.getSharedPreferences("pref", Context.MODE_PRIVATE);
        String selected = pref.getString("Animal", "");
        if(selected.contains("dog")){
            imginhome.setImageResource(R.drawable.dog);
        }
        else if(selected.contains("cat")){
            imginhome.setImageResource(R.drawable.cat);
        }
        else if(selected.contains("rabbit")){
            imginhome.setImageResource(R.drawable.rabbit);
        }
    }
}