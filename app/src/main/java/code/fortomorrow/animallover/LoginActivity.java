package code.fortomorrow.animallover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.sign_up)
    TextView signUp;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.passwordET)
    EditText passwordET;
    private ProgressDialog loadingBar1;
//    private FirebaseAuth mAuth;
    @BindView(R.id.login_button)
    Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loadingBar1 = new ProgressDialog(this);
//        mAuth = FirebaseAuth.getInstance();
    }
    @OnClick(R.id.login_button)
    public void checkFields() {
        String email = emailET.getText().toString();
        String pass = passwordET.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailET.setError("Phone Field can't be Blank");
            return;
        }
        else if(TextUtils.isEmpty(pass)){
            passwordET.setError("Password Field can't be Blank");
            return;
        }
        else {
            loadingBar1.setTitle("Login Account");
            loadingBar1.setMessage("Please Wait, While we are checking the credentials");
            loadingBar1.setCanceledOnTouchOutside(false);
            loadingBar1.show();
            AllowAccssAccount(email,pass);
        }
    }

    private void AllowAccssAccount(String email, String pass) {
//        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//
//                    FirebaseUser user = mAuth.getCurrentUser();
//
//                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                    finish();
//                    loadingBar1.dismiss();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),"Email & Password is not Correct",Toast.LENGTH_LONG).show();
//                    loadingBar1.dismiss();
//                }
//            }
//        });
    }

    @OnClick(R.id.sign_up)
    public void signup(){
        startActivity(new Intent(getApplicationContext(),SignupActivity.class));
    }
    @OnClick(R.id.backfromlogin)
    public void backfromlogin(){
        startActivity(new Intent(getApplicationContext(),LaunchActivity.class));
    }
}