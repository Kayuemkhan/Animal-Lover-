package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class FoodActivity extends AppCompatActivity {
    private CardView carfoodcard,birdfoodcard,dogfoodcard,fishfoodcard,rabbitfood;
    private ImageView backfromfoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        init();
        carfoodcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SingleFoodsActivity.class);
                intent.putExtra("animal","cat");
                startActivity(intent);

            }
        });
        dogfoodcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SingleFoodsActivity.class);
                intent.putExtra("animal","dog");
                startActivity(intent);
            }
        });
        birdfoodcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SingleFoodsActivity.class);
                intent.putExtra("animal","bird");
                startActivity(intent);
            }
        });
        fishfoodcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SingleFoodsActivity.class);
                intent.putExtra("animal","fish");
                startActivity(intent);
            }
        });
        backfromfoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodActivity.this,HomeActivity.class));
                finish();
            }
        });
        rabbitfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,SingleFoodsActivity.class);
                intent.putExtra("animal","rabbit");
                startActivity(intent);
            }
        });
    }

    private void init() {
        carfoodcard = findViewById(R.id.carfoodcard);
        birdfoodcard = findViewById(R.id.birdfoodcard);
        dogfoodcard = findViewById(R.id.dogfoodcard);
        fishfoodcard = findViewById(R.id.fishfoodcard);
        rabbitfood = findViewById(R.id.rabbitfood);
        backfromfoods = findViewById(R.id.backfromfoods);
    }
}