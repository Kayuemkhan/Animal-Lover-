package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.BlogsActivity;
import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.R;

public class BlogsAdapters extends RecyclerView.Adapter<BlogsAdapters.ViewHolder> {
    private Context context;
    private List<ProfessionalData> blogslist;

    public BlogsAdapters(BlogsActivity blogsActivity, List<ProfessionalData> exampleList) {
        this.context = blogsActivity;
        this.blogslist = exampleList;
    }

    @NonNull
    @Override
    public BlogsAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designblog,parent,false);
        return new BlogsAdapters.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogsAdapters.ViewHolder holder, int i) {
        holder.blogheadline.setText(blogslist.get(i).getProfessionalName());
        holder.blogpicture.setBackgroundResource(blogslist.get(i).getImageResource());
    }

    @Override
    public int getItemCount() {
        return blogslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout blogpicture;
        private TextView blogheadline;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            blogpicture = itemView.findViewById(R.id.blogpicture);
            //actionId = itemView.findViewById(R.id.actionId);
            blogheadline = itemView.findViewById(R.id.blogheadline);
        }
    }
}
