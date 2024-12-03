package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import code.fortomorrow.animallover.ui.AdoptPetActivity;
import code.fortomorrow.animallover.ui.AdoptPetActivityDetails;
import code.fortomorrow.animallover.model.AllAdoptPetsModel;
import code.fortomorrow.animallover.R;
import code.fortomorrow.animallover.utils.SharedPref;

public class PetAdoptAdapters extends RecyclerView.Adapter<PetAdoptAdapters.ViewHolder> {
    private final List<AllAdoptPetsModel> petadopt;
    private final Context context;

    public PetAdoptAdapters(AdoptPetActivity adoptPetActivity, List<AllAdoptPetsModel> allAdoptPetsModels) {
        this.petadopt = allAdoptPetsModels;
        this.context = adoptPetActivity;
        SharedPref.init(context);
    }

    @NonNull
    @Override
    public PetAdoptAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designadoptpet,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdoptAdapters.ViewHolder holder, int i) {
        holder.petname.setText(petadopt.get(i).getPetsName());
        holder.petLocation.setText(petadopt.get(i).getPetsPlace());
        Glide.with(context).load(petadopt.get(i).getImage()).placeholder(R.drawable.ic_baseline_pets_24).into(holder.petadoptIMG);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.write("pid",petadopt.get(i).getPid());
                context.startActivity(new Intent(context,AdoptPetActivityDetails.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return petadopt.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView petadoptIMG;
        private final TextView petname;
        private final TextView petLocation;
        private final View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            petadoptIMG = itemView.findViewById(R.id.petadoptIMG);
            petname = itemView.findViewById(R.id.petname);
            petLocation = itemView.findViewById(R.id.petLocation);
        }
    }
}
