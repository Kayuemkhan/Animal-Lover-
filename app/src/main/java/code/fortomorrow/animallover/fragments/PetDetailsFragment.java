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

import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class PetDetailsFragment extends Fragment {
    private ImageView arrowinpetdetailsIV;
    private ImageView imageselectedfittingviewinpetdetails;
    SharedPreferences pref;
    String selected;
    public PetDetailsFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        pref = this.getActivity().getSharedPreferences("pref",Context.MODE_PRIVATE);
       // pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_details,container,false);
        pref = container.getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
//        String selected = pref.getString("Animal", "");
        selected = ChildFragment3.animals;
        //selected = String.valueOf(SharedPref.read("Animal","")).trim();
        arrowinpetdetailsIV = view.findViewById(R.id.arrowinpetdetailsIV);
        arrowinpetdetailsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).nextfragment();
            }
        });
        imageselectedfittingviewinpetdetails = view.findViewById(R.id.imageselectedfittingviewinpetdetails);

        if(selected.contains("dog")){
            imageselectedfittingviewinpetdetails.setImageResource(R.drawable.dog);
        }
        else if(selected.contains("cat")){
            imageselectedfittingviewinpetdetails.setImageResource(R.drawable.cat);
        }
        else if(selected.contains("rabbit")){
            imageselectedfittingviewinpetdetails.setImageResource(R.drawable.rabbit);
        }
        return view;
    }

}