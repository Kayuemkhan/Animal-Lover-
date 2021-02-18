package code.fortomorrow.animallover.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import code.fortomorrow.animallover.HomeActivity;
import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.ModelClass.Users;
import code.fortomorrow.animallover.R;


public class SignInFragment extends Fragment {
    private EditText InputNumber, InputPassword;
    private TextView LoginButton;
    ProgressDialog loadingBar1,loadingBar2;
    private TextView signupbtn;
    private String parentDbName ="Users";
    private CheckBox chkBoxRememberMe;
    public SignInFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        LoginButton = view.findViewById(R.id.login_btn);
        InputNumber = view.findViewById(R.id.login_phone_number_input);
        InputPassword = view.findViewById(R.id.login_password_input);
        loadingBar1 = new ProgressDialog(getActivity());
        chkBoxRememberMe = view.findViewById(R.id.remember_me_chkb);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        return view;
    }

    private void loginUser() {
        String phone = InputNumber.getText().toString();
        String password = InputPassword.getText().toString();

        if(TextUtils.isEmpty(phone)){
            InputNumber.setError("Phone Field can't be Blank");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            InputPassword.setError("Password Field can't be Blank");
            return;
        }
        else {
            loadingBar1.setTitle("Login Account");
            loadingBar1.setMessage("Please Wait, While we are checking the credentials");
            loadingBar1.setCanceledOnTouchOutside(false);
            loadingBar1.show();
            AllowAccssAccount(phone,password);
        }
    }
    private void AllowAccssAccount(final String phone, final String password) {

        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbName).child(phone).exists()){
                    Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone)){
                        if(usersData.getPassword().equals(password)){
                            if (parentDbName.equals("Users")) {
                                loadingBar1.dismiss();
                                Intent intent = new Intent(getActivity(), HomeActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }

                        }
                        else {
                            loadingBar1.dismiss();
                            Toast.makeText(getActivity(),"password is not Correct",Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                else {
                    Toast.makeText(getActivity(),"Account with this "+ phone+" number do not exists ",Toast.LENGTH_SHORT).show();
                    loadingBar1.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}