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
    private LinearLayout rabit, cat, dog,fish,bird;
    public static int roll;
    private ImageView imagetickinrabbit, imagetickincat,imagetickindog,imagetickinfish,imagetickinbird;
    SharedPreferences preferences;
    public static String animals="";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child3,container,false);
        SharedPref.init(container.getContext());
        preferences = container.getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        dog = view.findViewById(R.id.dog);
        cat = view.findViewById(R.id.cat);
        rabit = view.findViewById(R.id.rabbit);
        fish = view.findViewById(R.id.fish);
        bird = view.findViewById(R.id.bird);

        imagetickinrabbit = view.findViewById(R.id.imagetickinrabbit);
        imagetickincat = view.findViewById(R.id.imagetickincat);
        imagetickindog = view.findViewById(R.id.imagetickindog);
        imagetickinfish = view.findViewById(R.id.imagetickinfish);
        imagetickinbird = view.findViewById(R.id.imagetickinbird);
        dog.setOnClickListener(v -> {
            imagetickindog.setBackgroundColor(getResources().getColor(R.color.red));
            SharedPref.write("Animal", "dog");
            animals = "dog";
            ((MainActivity)getActivity()).nextfragment();
        });
        cat.setOnClickListener(v -> {
            imagetickincat.setBackgroundColor(getResources().getColor(R.color.red));
            SharedPref.write("Animal", "cat");
            animals = "cat";
            ((MainActivity)getActivity()).nextfragment();

        });
        rabit.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Rabbit",Toast.LENGTH_SHORT).show();
            imagetickinrabbit.setBackgroundColor(getResources().getColor(R.color.red));
            SharedPref.write("Animal","rabbit");
            animals = "rabbit";
            ((MainActivity)getActivity()).nextfragment();

        });
        fish.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Rabbit",Toast.LENGTH_SHORT).show();
            imagetickinfish.setBackgroundColor(getResources().getColor(R.color.red));
            SharedPref.write("Animal","fish");
            animals = "fish";
            ((MainActivity)getActivity()).nextfragment();

        });
        bird.setOnClickListener(v -> {
            Toast.makeText(getActivity(),"Rabbit",Toast.LENGTH_SHORT).show();
            imagetickinbird.setBackgroundColor(getResources().getColor(R.color.red));
            SharedPref.write("Animal","bird");
            animals = "bird";
            ((MainActivity)getActivity()).nextfragment();

        });
        return view;
    }


}