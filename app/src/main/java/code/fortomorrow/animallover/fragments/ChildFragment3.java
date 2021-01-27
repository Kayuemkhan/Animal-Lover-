package code.fortomorrow.animallover.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import code.fortomorrow.animallover.R;

public class ChildFragment3 extends Fragment {
    private LinearLayout rabit, cat, dog;
    public static int roll;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dog = view.findViewById(R.id.dog);
        cat = view.findViewById(R.id.cat);
        rabit = view.findViewById(R.id.rabbit);

        dog.setOnClickListener(v -> {
            roll = 1;
        });
        cat.setOnClickListener(v -> roll = 2);
        rabit.setOnClickListener(v -> roll = 3);
    }
}