package code.fortomorrow.animallover.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.fragments.BirdFoodFrament;
import code.fortomorrow.animallover.fragments.CatFoodFragment;
import code.fortomorrow.animallover.fragments.DogFoodFragment;
import code.fortomorrow.animallover.fragments.FishFoodFragment;
import code.fortomorrow.animallover.fragments.RabbitFoodFragment;

public class SingleFoodsActivity extends AppCompatActivity {
    String animall;
    private ImageView backfrommyfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_foods);
        backfrommyfood = findViewById(R.id.backfrommyfood);
        backfrommyfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleFoodsActivity.this,FoodActivity.class));
                finish();
            }
        });
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                animall= null;
            } else {
                animall= extras.getString("animal");
            }
        } else {
            animall= (String) savedInstanceState.getSerializable("animal");
        }
        if(animall.contains("bird")){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout1, new BirdFoodFrament());
            ft.commit();
        }
        if(animall.contains("cat")){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout1, new CatFoodFragment());
            ft.commit();
        }
        if(animall.contains("dog")){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout1, new DogFoodFragment());
            ft.commit();
        }
        if(animall.contains("fish")){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout1, new FishFoodFragment());
            ft.commit();
        }
        if(animall.contains("rabbit")){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout1, new RabbitFoodFragment());
            ft.commit();
        }
    }
}