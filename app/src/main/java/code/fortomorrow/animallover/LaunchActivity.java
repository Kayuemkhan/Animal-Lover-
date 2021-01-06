package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.registerfromlaunch)
    public void registerfromlaunch(){
        startActivity(new Intent(LaunchActivity.this,SignupActivity.class));
    }
    @OnClick(R.id.loginfromlaunch)
    public void loginfromlaunch(){
        startActivity(new Intent(LaunchActivity.this,LoginActivity.class));
    }
}