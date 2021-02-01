package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.ProfessionalsActivity;
import code.fortomorrow.animallover.R;

public class ProfessionalsAdapters extends RecyclerView.Adapter<ProfessionalsAdapters.ViewHolder> {
    private Context context;
    private List<ProfessionalData> professionalData;
    public ProfessionalsAdapters(ProfessionalsActivity professionalsActivity, List<ProfessionalData> exampleList) {
        this.context =professionalsActivity;
        this.professionalData = exampleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designprofessional,parent,false);
        return new ProfessionalsAdapters.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.doctor.setText(professionalData.get(i).getProfessionalName());
        holder.emaildoctor.setText(professionalData.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return professionalData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doctor;
        private TextView emaildoctor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor = itemView.findViewById(R.id.doctor);
            emaildoctor = itemView.findViewById(R.id.emaildoctor);
        }
    }
}
