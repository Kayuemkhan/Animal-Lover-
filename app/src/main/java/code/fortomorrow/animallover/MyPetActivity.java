package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import code.fortomorrow.animallover.utils.SharedPref;

public class MyPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet);
        SharedPref.init(this);
    }
}