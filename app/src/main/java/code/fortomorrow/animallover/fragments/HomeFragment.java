package code.fortomorrow.animallover.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import code.fortomorrow.animallover.ui.AdoptPetActivity;
import code.fortomorrow.animallover.ui.BlogsActivity;
import code.fortomorrow.animallover.ui.FoodActivity;
import code.fortomorrow.animallover.ui.HealthActivity;
import code.fortomorrow.animallover.ui.MyPetActivity;
import code.fortomorrow.animallover.ui.ProfessionalsActivity;
import code.fortomorrow.animallover.R;


public class HomeFragment extends Fragment {
    private LinearLayout adopt;
    private LinearLayout professionals,blogs,food,health,mypetsIcon;

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

        adopt.setOnClickListener(v -> Toast.makeText(requireActivity(), "The feature will be coming soon", Toast.LENGTH_SHORT).show());

        professionals.setOnClickListener(v -> startActivity(new Intent(getActivity(), ProfessionalsActivity.class)));

        blogs.setOnClickListener(v -> startActivity(new Intent(getActivity(), BlogsActivity.class)));

        food.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), FoodActivity.class));
        });

        health.setOnClickListener(v -> startActivity(new Intent(getActivity(), HealthActivity.class)));

        mypetsIcon.setOnClickListener(v -> startActivity(new Intent(getActivity(), MyPetActivity.class)));

        return view;
    }

    private void init(View view) {
        adopt = view.findViewById(R.id.adopt);
        professionals = view.findViewById(R.id.professionals);
        blogs = view.findViewById(R.id.blogs);
        food= view.findViewById(R.id.food);
        health = view.findViewById(R.id.health);
        mypetsIcon = view.findViewById(R.id.mypetsIcon);
    }
}