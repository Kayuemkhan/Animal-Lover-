package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;
import code.fortomorrow.animallover.fragments.DoctordetailsBottomsheetFragment;
import code.fortomorrow.animallover.utils.SharedPref;

public class ProfessionalsActivity extends AppCompatActivity {
    private RecyclerView professionalsrecylerview;
    private List<ProfessionalData> exampleList;
    private List<ProfessionalData> data;
    private ImageView backImageViewIdDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        professionalsrecylerview = findViewById(R.id.professionalsrecylerview);
        backImageViewIdDoctor = findViewById(R.id.backImageViewIdDoctor);
        professionalsrecylerview.setLayoutManager(new LinearLayoutManager(ProfessionalsActivity.this));
        exampleList = new ArrayList<>();
        data = new ArrayList<>();
        exampleList.add(new ProfessionalData(1, "Dr. Mohammad Mamunur Rashid", "", "01725-808534", "Central Veterinary Hospital", "Veterinary Surgeon", "DVM, MS in Theriogenology"));
        exampleList.add(new ProfessionalData(1, "Dr. Arifur Rabbi", "veterinarybd@hotmail.com", "01725-808534", "Ta 173/2 Lake view road, Godara ghat to Hatirjheel Road, Dhaka 1212", "Veterinary Doctor", "DVM, MS (Bangladesh Agricultural University, Mymensingh)"));
        exampleList.add(new ProfessionalData(1, "Vet Dr. Sagir Uddin Ahmed", "bdvet.com@gmail.com", "01912251312", "Dr. Sagir's Pet Clinic & Research Center", "Pet Doctor, Veterinary Surgeon", "DVM, MS in Theriogenology"));
        exampleList.add(new ProfessionalData(1, "Dr. Md. Mahbubul Alam Bhuiyan", "", "01711-146012", "67/2, North Bashaboo, Khilgaon, Dhaka", "Additional Veterinary officer", "Specialist in Treatment, Vaccination & Management of Pet Animal & Birds"));

        professionalsrecylerview.setAdapter(new ProfessionalsAdapters(ProfessionalsActivity.this, exampleList));
        backImageViewIdDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfessionalsActivity.this, HomeActivity.class));
            }
        });
    }

    public void showDoctorDetails(String professionalName) {
        DoctordetailsBottomsheetFragment addPhotoBottomDialogFragment =
                new DoctordetailsBottomsheetFragment(ProfessionalsActivity.this);
        Bundle bundle = new Bundle();
        String json = new Gson().toJson(exampleList);
        bundle.putString("key", json);
        bundle.putString("professionalName",professionalName);

        addPhotoBottomDialogFragment.setArguments(bundle);
        addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                "DoctordetailsBottomsheetFragment");
//        addPhotoBottomDialogFragment.setListData(exampleList,professionalName);
//        if(!professionalName.isEmpty()){
//            setData(professionalName);
//        }
    }

    public void hey() {
        Log.d("checkhere2222222","I'm here");
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse(SharedPref.read("doctorPhone","")));
//        startActivity(intent);
       // calltoSomeOne();
    }

//    private void calltoSomeOne() {
//        Log.d("ihe","I'm Here");
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse("0377778888"));
//        if (ActivityCompat.checkSelfPermission(ProfessionalsActivity.this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        startActivity(callIntent);


}