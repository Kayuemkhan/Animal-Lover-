package code.fortomorrow.animallover.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class PetDetailsFragment extends Fragment {
    private ImageView arrowinpetdetailsIV;
    SharedPreferences pref;
    private TextView malePet, femalePet;
    private Fragment fragment;
    String selected;
    public PetDetailsFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        SharedPref.init(getActivity());
        fragment = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_details,container,false);
        malePet = view.findViewById(R.id.malePet);
        femalePet = view.findViewById(R.id.femalePet);
        pref = container.getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
//        String selected = pref.getString("Animal", "");
        selected = ChildFragment3.animals;
        //selected = String.valueOf(SharedPref.read("Animal","")).trim();
        arrowinpetdetailsIV = view.findViewById(R.id.arrowinpetdetailsIV);
        arrowinpetdetailsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).nextfragment();
                //requireActivity().onBackPressed();
                //getActivity().getFragmentManager().beginTransaction().remove(fragment).commit();
            }
        });

        malePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.write("GENDER","Male");
                ((MainActivity)getActivity()).nextfragment();
                //requireActivity().onBackPressed();
            }
        });
        femalePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.write("GENDER","FEMALE");
                ((MainActivity)getActivity()).nextfragment();
                //requireActivity().onBackPressed();
            }
        });
        return view;
    }

}