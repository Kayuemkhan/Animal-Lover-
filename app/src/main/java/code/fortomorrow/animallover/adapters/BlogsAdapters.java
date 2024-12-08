package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.ui.BlogsActivity;
import code.fortomorrow.animallover.model.BlogModelClass;
import code.fortomorrow.animallover.R;

public class BlogsAdapters extends RecyclerView.Adapter<BlogsAdapters.ViewHolder> {
    private final Context context;
    private final List<BlogModelClass> blogslist;
    private final BlogsActivity blogsActivity;

    public BlogsAdapters(BlogsActivity blogsActivity, List<BlogModelClass> exampleList, BlogsActivity activity) {
        this.context = blogsActivity;
        this.blogslist = exampleList;
        this.blogsActivity = activity;
    }

    @NonNull
    @Override
    public BlogsAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designblog,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogsAdapters.ViewHolder holder, int i) {
        holder.blogheadline.setText(blogslist.get(i).getProfessionalName());
        holder.blogpicture.setImageResource(blogslist.get(i).getImageResource());
        holder.writeer.setText("Author: "+blogslist.get(i).getEmail());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blogsActivity.viewa(blogslist.get(i).getImageResource(),blogslist.get(i).getEmail(),blogslist.get(i).getDescription(),blogslist.get(i).getProfessionalName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return blogslist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView blogpicture;
        private final TextView blogheadline;
        private final TextView writeer;
        private final View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            blogpicture = itemView.findViewById(R.id.blogpicture);
            //actionId = itemView.findViewById(R.id.actionId);
            blogheadline = itemView.findViewById(R.id.blogheadline);
            writeer = itemView.findViewById(R.id.writeer);
        }
    }
}
