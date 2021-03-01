package code.fortomorrow.animallover.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import code.fortomorrow.animallover.HomeActivity;
import code.fortomorrow.animallover.LoginActivity;
import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;


public class PetNameFragment extends Fragment {
    private ImageView arrowbuttonfrompetname;
    private TextView petnameET;
    public PetNameFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_name, container, false);
        petnameET = view.findViewById(R.id.petnameET);
        petnameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String petname = s.toString();
                SharedPref.read("PetName",petname);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        arrowbuttonfrompetname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });
    }

    private void init(View view) {
        arrowbuttonfrompetname= view.findViewById(R.id.arrowbuttonfrompetname);
//        imageselectedfittingview.setImageResource(R.drawable.cat);
    }

}