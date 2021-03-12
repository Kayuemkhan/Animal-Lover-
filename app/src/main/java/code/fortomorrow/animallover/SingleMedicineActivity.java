package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import code.fortomorrow.animallover.fragments.FishMedicineFragment;

public class SingleMedicineActivity extends AppCompatActivity {
    private String animalls;
    private ImageView backfromsinglemedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_medicine);
        backfromsinglemedicine = findViewById(R.id.backfromsinglemedicine);
        backfromsinglemedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleMedicineActivity.this,HealthActivity.class));
                finish();
            }
        });
        Bundle bundle = new Bundle();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                animalls= null;
            } else {
                animalls= extras.getString("animalm");
            }
        } else {
            animalls= (String) savedInstanceState.getSerializable("animalm");
        }

        if(animalls.contains("fish")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FishMedicineFragment fishMedicineFragment = new FishMedicineFragment();
            bundle.putString("animalnow", "fish");
            fishMedicineFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.framelayoutmedicine,fishMedicineFragment);
            fragmentTransaction.commit();
        }

        if(animalls.contains("cat")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FishMedicineFragment fishMedicineFragment = new FishMedicineFragment();
            bundle.putString("animalnow", "cat");
            fishMedicineFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.framelayoutmedicine,fishMedicineFragment);
            fragmentTransaction.commit();
        }
        if(animalls.contains("bird")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FishMedicineFragment fishMedicineFragment = new FishMedicineFragment();
            bundle.putString("animalnow", "bird");
            fishMedicineFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.framelayoutmedicine,fishMedicineFragment);
            fragmentTransaction.commit();
        }
        if(animalls.contains("rabbit")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FishMedicineFragment fishMedicineFragment = new FishMedicineFragment();
            bundle.putString("animalnow", "rabbit");
            fishMedicineFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.framelayoutmedicine,fishMedicineFragment);
            fragmentTransaction.commit();
        }
        if(animalls.contains("dog")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            FishMedicineFragment fishMedicineFragment = new FishMedicineFragment();
            bundle.putString("animalnow", "dog");
            fishMedicineFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.framelayoutmedicine,fishMedicineFragment);
            fragmentTransaction.commit();
        }
    }
}