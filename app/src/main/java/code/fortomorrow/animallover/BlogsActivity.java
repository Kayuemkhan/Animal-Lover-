package code.fortomorrow.animallover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import code.fortomorrow.animallover.ModelClass.BlogModelClass;
import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.adapters.BlogsAdapters;
import code.fortomorrow.animallover.adapters.ProfessionalsAdapters;
import de.hdodenhof.circleimageview.CircleImageView;

public class BlogsActivity extends AppCompatActivity {
    private RecyclerView blogsrecylerview;
    private List<BlogModelClass> exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        blogsrecylerview = findViewById(R.id.blogsrecylerview);
        blogsrecylerview.setLayoutManager(new LinearLayoutManager(BlogsActivity.this));
        exampleList = new ArrayList<>();
        exampleList.add(new BlogModelClass (R.drawable.peta, "Save Cats from many harmful Disease", "Abu Sayem","RadCat is having a voluntary recall and we inadvertently fed our cats the contaminated food! Yes, before the recall was announced, WE bought one of the offending foods (the Turkey – but Chicken and Beef were affected too). And. Fed. It. To. Our. Cats. Twice (sort of). YIKES! But first, don’t panic."));
        exampleList.add(new BlogModelClass(R.drawable.petb, "Save Dogs from many harmful Disease", "Rakib Khan","RadCat is having a voluntary recall and we inadvertently fed our cats the contaminated food! Yes, before the recall was announced, WE bought one of the offending foods (the Turkey – but Chicken and Beef were affected too). And. Fed. It. To. Our. Cats. Twice (sort of). YIKES! But first, don’t panic."));
        exampleList.add(new BlogModelClass(R.drawable.petc, "Panedemic Health Tips", "Saifa Borsha","RadCat is having a voluntary recall and we inadvertently fed our cats the contaminated food! Yes, before the recall was announced, WE bought one of the offending foods (the Turkey – but Chicken and Beef were affected too). And. Fed. It. To. Our. Cats. Twice (sort of). YIKES! But first, don’t panic."));
        exampleList.add(new BlogModelClass(R.drawable.petd, "Save Rabbit", "Maruf Hossain","RadCat is having a voluntary recall and we inadvertently fed our cats the contaminated food! Yes, before the recall was announced, WE bought one of the offending foods (the Turkey – but Chicken and Beef were affected too). And. Fed. It. To. Our. Cats. Twice (sort of). YIKES! But first, don’t panic."));
        blogsrecylerview.setAdapter(new BlogsAdapters(BlogsActivity.this,exampleList,BlogsActivity.this));
    }
    public void viewa(int imageResource, String s, String email, String description){
        AlertDialog.Builder builder = new AlertDialog.Builder(BlogsActivity.this);
        LayoutInflater inflater = (LayoutInflater) BlogsActivity.this.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.aleartblogs, null);
        CircleImageView imageblogs = view2.findViewById(R.id.imageblogs);
        TextView blogshead = view2.findViewById(R.id.blogshead);
        TextView authorBlogs = view2.findViewById(R.id.authorBlogs);
        TextView discriptionblogs = view2.findViewById(R.id.discriptionblogs);
        imageblogs.setImageResource(imageResource);
        blogshead.setText(description);
        authorBlogs.setText(s);
        discriptionblogs.setText(email);
        builder.setView(view2);
        ImageView close = view2.findViewById(R.id.closeId);
        AlertDialog alert = builder.create();
        close.setOnClickListener(view -> alert.dismiss());
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.setCancelable(false);
        alert.show();
    }
}