package code.fortomorrow.animallover.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import code.fortomorrow.animallover.R;

public class FishMedicineFragment extends Fragment {
    private LinearLayout fishframent, birdfragment,rabbitfragment;
    public FishMedicineFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("hereingcheck","I'm heres");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fish_medicine, container, false);
        init(view);
        String strtext = getArguments().getString("animalnow");
        if(strtext.contains("fish")){
            fishframent.setVisibility(View.VISIBLE);
        }
        if(strtext.contains("bird")){
            birdfragment.setVisibility(View.VISIBLE);
        }
        if(strtext.contains("rabbit")){
            rabbitfragment.setVisibility(View.VISIBLE);
        }
        return view;
    }

    private void init(View view) {
        fishframent = view.findViewById(R.id.fishframent);
        birdfragment = view.findViewById(R.id.birdfragment);
        rabbitfragment = view.findViewById(R.id.rabbitfragment);
    }
}