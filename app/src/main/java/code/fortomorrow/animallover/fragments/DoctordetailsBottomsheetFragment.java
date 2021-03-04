package code.fortomorrow.animallover.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import code.fortomorrow.animallover.R;

public class DoctordetailsBottomsheetFragment extends BottomSheetDialogFragment {

    public DoctordetailsBottomsheetFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
    }
    public static final String TAG = "DoctordetailsBottomsheetFragment";
    public static DoctordetailsBottomsheetFragment newInstance() {
        return new DoctordetailsBottomsheetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_doctordetails_bottomsheet, container, false);
    }

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }
}