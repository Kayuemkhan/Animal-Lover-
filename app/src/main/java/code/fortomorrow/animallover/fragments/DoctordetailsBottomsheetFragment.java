package code.fortomorrow.animallover.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.R;

public class DoctordetailsBottomsheetFragment extends BottomSheetDialogFragment {
    private List<ProfessionalData> professionalData;
    private TextView doctorname;
    String data;
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
        View view = inflater.inflate(R.layout.fragment_doctordetails_bottomsheet, container, false);
        data =  getArguments().getString("key");
        Log.d("key",""+data);
        doctorname =view.findViewById(R.id.doctorname);
        doctorname.setText(String.valueOf(data));
        return view;
    }

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }
    public void setListData(List<ProfessionalData> exampleList, String professionalName){

        Log.d("professionalName",""+professionalName);
        professionalData = exampleList;
    }

}