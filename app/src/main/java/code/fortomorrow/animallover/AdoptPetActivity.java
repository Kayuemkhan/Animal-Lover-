package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdoptPetActivity extends AppCompatActivity {
    private RecyclerView petrecylerview;
    private int images [] = {R.drawable.peta,R.drawable.petb,R.drawable.petc,R.drawable.petd};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_pet);
        petrecylerview = findViewById(R.id.petrecylerview);
        petrecylerview.setLayoutManager(new GridLayoutManager(AdoptPetActivity.this, 5));
        List<String> list = new ArrayList<>();
        //list.addAll(Arrays.asList(images));
//        petrecylerview.setAdapter(new );
    }
}