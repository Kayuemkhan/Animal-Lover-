package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.BlogsAdapters;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;

public class BlogsActivity extends AppCompatActivity {
    private RecyclerView blogsrecylerview;
    private List<ProfessionalData> exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        blogsrecylerview = findViewById(R.id.blogsrecylerview);
        blogsrecylerview.setLayoutManager(new LinearLayoutManager(BlogsActivity.this));
        exampleList = new ArrayList<>();
        exampleList.add(new ProfessionalData (R.drawable.peta, "Save Cats", "ranju@gmail.com"));
        exampleList.add(new ProfessionalData(R.drawable.petb, "Save Dogs", "sanju@gmail.com"));
        exampleList.add(new ProfessionalData(R.drawable.petc, "Panedemic Health Tips", "rana@gmail.com"));
        exampleList.add(new ProfessionalData(R.drawable.petd, "Save Rabbit", "sana@gmail.com"));
        blogsrecylerview.setAdapter(new BlogsAdapters(BlogsActivity.this,exampleList));
    }
}