package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.ProfessionalsActivity;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.fragments.DoctordetailsBottomsheetFragment;

public class ProfessionalsAdapters extends RecyclerView.Adapter<ProfessionalsAdapters.ViewHolder> {
    private Context context;
    private List<ProfessionalData> professionalData;
    private ProfessionalsActivity professionalsActivity;
    public ProfessionalsAdapters(ProfessionalsActivity professionalsActivity, List<ProfessionalData> exampleList) {
        this.context =professionalsActivity;
        this.professionalData = exampleList;
        this.professionalsActivity = professionalsActivity;
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
        holder.designation.setText(professionalData.get(i).getDesination());
        holder.qualification.setText(professionalData.get(i).getQualification());
        holder.cell.setText(professionalData.get(i).getCell());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professionalsActivity.showDoctorDetails();
            }
        });
    }

    @Override
    public int getItemCount() {
        return professionalData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView doctor,designation,qualification,cell;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor = itemView.findViewById(R.id.doctor);
            designation = itemView.findViewById(R.id.designation);
            qualification = itemView.findViewById(R.id.qualification);
            cell = itemView.findViewById(R.id.cell);
            view = itemView;
        }
    }
}
