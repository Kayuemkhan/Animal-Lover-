package code.fortomorrow.animallover.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import code.fortomorrow.animallover.AdoptPetActivity;
import code.fortomorrow.animallover.ProfessionalsActivity;
import code.fortomorrow.animallover.R;


public class HomeFragment extends Fragment {
    private LinearLayout adopt;
    private LinearLayout professionals;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        init(view);
        adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AdoptPetActivity.class));
            }
        });
        professionals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfessionalsActivity.class));
            }
        });
        return view;
    }

    private void init(View view) {
        adopt = view.findViewById(R.id.adopt);
        professionals = view.findViewById(R.id.professionals);
    }
}