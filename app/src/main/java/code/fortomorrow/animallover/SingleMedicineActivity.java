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
//        if(animall.contains("cat")){
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.framelayoutmedicine,new Fr)
//        }
        if(animalls.contains("fish")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayoutmedicine,new FishMedicineFragment());
            fragmentTransaction.commit();
        }
    }
}