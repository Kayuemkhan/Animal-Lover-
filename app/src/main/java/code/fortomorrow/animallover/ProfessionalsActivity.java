package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;

public class ProfessionalsActivity extends AppCompatActivity {
    private RecyclerView professionalsrecylerview;
    private List<ProfessionalData> exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professionals);
        professionalsrecylerview = findViewById(R.id.professionalsrecylerview);
        professionalsrecylerview.setLayoutManager(new LinearLayoutManager(ProfessionalsActivity.this));
        exampleList = new ArrayList<>();
        exampleList.add(new ProfessionalData (1, "Dr. Ranju", "ranju@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Shouvik", "sanju@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Rana", "rana@gmail.com"));
        exampleList.add(new ProfessionalData(1, "Dr. Sana", "sana@gmail.com"));
        professionalsrecylerview.setAdapter(new ProfessionalsAdapters(ProfessionalsActivity.this,exampleList));
    }
}