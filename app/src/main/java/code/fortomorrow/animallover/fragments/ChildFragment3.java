package code.fortomorrow.animallover.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import code.fortomorrow.animallover.MainActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class ChildFragment3 extends Fragment {
    private LinearLayout rabit, cat, dog;
    public static int roll;
    private ImageView imagetickinrabbit, imagetickincat,imagetickindog;
    SharedPreferences preferences;
    SharedPreferences.Editor edt;
    public static String animals="";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
         //preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        //preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child3,container,false);
        preferences = container.getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        dog = view.findViewById(R.id.dog);
        cat = view.findViewById(R.id.cat);
        rabit = view.findViewById(R.id.rabbit);
        imagetickinrabbit = view.findViewById(R.id.imagetickinrabbit);
        imagetickincat = view.findViewById(R.id.imagetickincat);
        imagetickindog = view.findViewById(R.id.imagetickindog);
        dog.setOnClickListener(v -> {
            imagetickindog.setBackgroundColor(getResources().getColor(R.color.red));
            edt = preferences.edit();
            edt.putString("Animal", "dog");
            edt.commit();
            animals = "dog";
            ((MainActivity)getActivity()).nextfragment();
        });
        cat.setOnClickListener(v -> {
            imagetickincat.setBackgroundColor(getResources().getColor(R.color.red));
            edt = preferences.edit();
            edt.putString("Animal", "cat");
            edt.commit();
            animals = "cat";
            ((MainActivity)getActivity()).nextfragment();

        });
        rabit.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Rabbit",Toast.LENGTH_SHORT).show();
            imagetickinrabbit.setBackgroundColor(getResources().getColor(R.color.red));
//            SharedPref.write("Animal","rabbit");
            edt = preferences.edit();
            edt.putString("Animal", "rabbit");
            edt.commit();
            animals = "rabbit";
            ((MainActivity)getActivity()).nextfragment();

        });
        return view;
    }


}