package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;

public class ProfessionalsActivity extends AppCompatActivity {
    private RecyclerView professionalsrecylerview;
    private List<ProfessionalData> exampleList;
    private ImageView backImageViewIdDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        professionalsrecylerview = findViewById(R.id.professionalsrecylerview);
        backImageViewIdDoctor = findViewById(R.id.backImageViewIdDoctor);
        professionalsrecylerview.setLayoutManager(new LinearLayoutManager(ProfessionalsActivity.this));
        exampleList = new ArrayList<>();
        exampleList.add(new ProfessionalData (1, "Dr. Ranju", "ranju@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Shouvik", "sanju@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Rana", "rana@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Sana", "sana@gmail.com"));
        professionalsrecylerview.setAdapter(new ProfessionalsAdapters(ProfessionalsActivity.this,exampleList));
        backImageViewIdDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfessionalsActivity.this,HomeActivity.class));
            }
        });
    }
}