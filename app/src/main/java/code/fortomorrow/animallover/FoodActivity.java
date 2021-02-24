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
                AlertDialog.Builder builder = new AlertDialog.Builder(FoodActivity.this);
                LayoutInflater inflater = (LayoutInflater) FoodActivity.this.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view2 = inflater.inflate(R.layout.aleartdogfood, null);
                builder.setView(view2);
                ImageView close = view2.findViewById(R.id.closeId);
                AlertDialog alert = builder.create();
                close.setOnClickListener(view -> alert.dismiss());
                alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alert.setCancelable(false);
                alert.show();
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
    }

    private void init() {
        carfoodcard = findViewById(R.id.carfoodcard);
        birdfoodcard = findViewById(R.id.birdfoodcard);
        dogfoodcard = findViewById(R.id.dogfoodcard);
        fishfoodcard = findViewById(R.id.fishfoodcard);
        rabbitfood = findViewById(R.id.rabbitfood);
    }
}