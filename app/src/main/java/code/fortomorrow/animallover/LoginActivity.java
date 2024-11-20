package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.fragments.SignInFragment;
import code.fortomorrow.animallover.fragments.SignUpFragment;
import code.fortomorrow.animallover.utils.SharedPref;

public class LoginActivity extends AppCompatActivity {
    private TextView loginSelector, signupSelector;
    private View viewborder1, viewborder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        SharedPref.init(LoginActivity.this);
        Log.d("logees",SharedPref.read("LOGGEDIN",""));
        ImageView backbuttonfromLogin = findViewById(R.id.backbuttonfromLogin);
        backbuttonfromLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
        if (SharedPref.read("UserStatus", "").contains("SignUp")) {
            viewborder1.setVisibility(View.INVISIBLE);
            viewborder2.setVisibility(View.VISIBLE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.signinSignUpFragment, new SignUpFragment());
            ft.commit();
            SharedPref.write("UserStatus", "");
        } else if (SharedPref.read("UserStatus", "").contains("SignIn")) {
            viewborder1.setVisibility(View.VISIBLE);
            viewborder2.setVisibility(View.INVISIBLE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.signinSignUpFragment, new SignInFragment());
            ft.commit();
            SharedPref.write("UserStatus", "");
        } else {
            viewborder1.setVisibility(View.VISIBLE);
            viewborder2.setVisibility(View.INVISIBLE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.signinSignUpFragment, new SignInFragment());
            ft.commit();
        }
        loginSelector.setOnClickListener(v -> {
            viewborder1.setVisibility(View.VISIBLE);
            viewborder2.setVisibility(View.INVISIBLE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.signinSignUpFragment, new SignInFragment());
            ft.commit();
        });
        signupSelector.setOnClickListener(v -> {
            viewborder1.setVisibility(View.INVISIBLE);
            viewborder2.setVisibility(View.VISIBLE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.signinSignUpFragment, new SignUpFragment());
            ft.commit();
        });


    }

    private void init() {
        viewborder1 = findViewById(R.id.viewborder1);
        viewborder2 = findViewById(R.id.viewborder2);
        loginSelector = findViewById(R.id.loginSelector);
        signupSelector = findViewById(R.id.signupSelector);
    }
}