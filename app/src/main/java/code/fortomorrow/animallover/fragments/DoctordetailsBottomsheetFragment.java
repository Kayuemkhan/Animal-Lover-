package code.fortomorrow.animallover.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.ProfessionalsActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class DoctordetailsBottomsheetFragment extends BottomSheetDialogFragment {
    private List<ProfessionalData> professionalData;
    private TextView doctorname,email,chamber,desination,qualification,cell;
    private TextView callme,emailme;
    String data;
    String professionalName;
    ProfessionalData[] langs;
    ProfessionalsActivity professionalsActivity;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;

    public DoctordetailsBottomsheetFragment(ProfessionalsActivity professionalsActivity) {
        this.professionalsActivity = professionalsActivity;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.init(getActivity());
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.AppBottomSheetDialogTheme);
    }
   // public static final String TAG = "DoctordetailsBottomsheetFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctordetails_bottomsheet, container, false);
        doctorname =view.findViewById(R.id.doctorname);
        email =view.findViewById(R.id.email);
        chamber =view.findViewById(R.id.chamber);
        desination =view.findViewById(R.id.desination);
        qualification =view.findViewById(R.id.qualification);
        cell =view.findViewById(R.id.cell);
        callme =view.findViewById(R.id.callme);
        callme.isClickable();
        emailme =view.findViewById(R.id.emailme);
        callme.setOnClickListener(v -> {
            dismiss();
            Uri uri = Uri.parse("www.google.com");
//            Intent intent = new Intent(Intent.ACTION_DIAL);
            //intent.setData(Uri.parse(SharedPref.read("doctorPhone","")));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent,uri);
//            v.getContext().startActivity(intent);
            //professionalsActivity.hey();
            //dismiss();
        });


        data =  getArguments().getString("key");
        professionalName = getArguments().getString("professionalName");
        Log.d("professionalName",""+professionalName);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            langs = objectMapper.readValue(data, ProfessionalData[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<ProfessionalData> langList = new ArrayList(Arrays.asList(langs));


        for(int i =0;i<langList.size();i++){
            if(langList.get(i).getProfessionalName().contains(professionalName)){
                doctorname.setText(langList.get(i).getProfessionalName());
                if(!langList.get(i).getEmail().isEmpty()){
                    SharedPref.write("doctorEmail",langList.get(i).getEmail());
                    email.setText(langList.get(i).getEmail());
                }
                else {
                    email.setText("No Email Is Available");
                }
                chamber.setText(langList.get(i).getChamber());
                desination.setText(langList.get(i).getDesination());
                qualification.setText(langList.get(i).getQualification());
                SharedPref.write("doctorPhone",langList.get(i).getCell());
                cell.setText("Cell : "+langList.get(i).getCell());
            }

        }
        return view;
    }

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }


}