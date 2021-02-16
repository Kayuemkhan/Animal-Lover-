package code.fortomorrow.animallover.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import code.fortomorrow.animallover.LoginActivity;
import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class ChildFragment2 extends Fragment {
    private TextView iAmanewuserTV;
    private MainActivity mainActivity;
    private TextView ihaveanaccountTV;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.init(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_child2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iAmanewuserTV= view.findViewById(R.id.iAmanewuserTV);
        ihaveanaccountTV = view.findViewById(R.id.ihaveanaccountTV);
        iAmanewuserTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.write("UserStatus","SignUp");
                startActivity(new Intent(getActivity(),LoginActivity.class));
//                ((MainActivity)getActivity()).nextfragment();
            }
        });
        ihaveanaccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.write("UserStatus","SignIn");
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
    }
}