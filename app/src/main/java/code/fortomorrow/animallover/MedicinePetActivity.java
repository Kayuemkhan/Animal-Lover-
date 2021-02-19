package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MedicinePetActivity extends AppCompatActivity {
    private CardView carmedicinecard,birdmedicinecard,dogmedicinecard,fishmedicinecard,rabbitMedicinefood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinepet_details);
        init();
        carmedicinecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MedicinePetActivity.this);
                LayoutInflater inflater = (LayoutInflater) MedicinePetActivity.this.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view2 = inflater.inflate(R.layout.catmedicine, null);
                builder.setView(view2);
                ImageView close = view2.findViewById(R.id.closeId);
                AlertDialog alert = builder.create();
                close.setOnClickListener(view -> alert.dismiss());
                alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alert.setCancelable(false);
                alert.show();
            }
        });
    }

    private void init() {
        carmedicinecard= findViewById(R.id.carmedicinecard);
        birdmedicinecard= findViewById(R.id.birdmedicinecard);
        dogmedicinecard= findViewById(R.id.dogmedicinecard);
        fishmedicinecard= findViewById(R.id.fishmedicinecard);
        rabbitMedicinefood= findViewById(R.id.rabbitMedicinefood);
    }
}