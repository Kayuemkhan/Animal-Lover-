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

import code.fortomorrow.animallover.AdoptPetActivity;
import code.fortomorrow.animallover.AdoptPetActivityDetails;
import code.fortomorrow.animallover.ModelClass.AllAdoptPetsModel;
import code.fortomorrow.animallover.ModelClass.ProfessionalData;
import code.fortomorrow.animallover.R;

public class PetAdoptAdapters extends RecyclerView.Adapter<PetAdoptAdapters.ViewHolder> {
    private List<AllAdoptPetsModel> petadopt;
    private Context context;

    public PetAdoptAdapters(AdoptPetActivity adoptPetActivity, List<AllAdoptPetsModel> allAdoptPetsModels) {
        this.petadopt = allAdoptPetsModels;
        this.context = adoptPetActivity;
    }

    @NonNull
    @Override
    public PetAdoptAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designadoptpet,parent,false);
        return new PetAdoptAdapters.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdoptAdapters.ViewHolder holder, int i) {
        holder.petname.setText(petadopt.get(i).getPetsName());
        holder.petLocation.setText(petadopt.get(i).getPetsPlace());
        Glide.with(context).load(petadopt.get(i).getImage()).placeholder(R.drawable.ic_baseline_pets_24).into(holder.petadoptIMG);

    }

    @Override
    public int getItemCount() {
        return petadopt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView petadoptIMG;
        private TextView petname;
        private TextView petLocation;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            petadoptIMG = itemView.findViewById(R.id.petadoptIMG);
            petname = itemView.findViewById(R.id.petname);
            petLocation = itemView.findViewById(R.id.petLocation);
        }
    }
}
