package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.model.AllAdoptPetsModel;
import code.fortomorrow.animallover.ui.MyRequestActivity;
import code.fortomorrow.animallover.R;

public class MyRequestAdapters extends RecyclerView.Adapter<MyRequestAdapters.Viewholder> {
    private final Context context;
    private final List<AllAdoptPetsModel> allAdoptPetsModels;
    private final String phone_number;
    private final MyRequestActivity myRequestActivity;
    public MyRequestAdapters(MyRequestActivity myRequestActivity, List<AllAdoptPetsModel> myOrdersListData, String phone_number) {
        this.context = myRequestActivity;
        this.allAdoptPetsModels = myOrdersListData;
        this.phone_number = phone_number;
        this.myRequestActivity = myRequestActivity;
    }

    @NonNull
    @Override
    public MyRequestAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singlemyordersreqpage,parent,false);
        return new MyRequestAdapters.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestAdapters.Viewholder holder, int position) {
        holder.order_address_city.setText(allAdoptPetsModels.get(position).getPetsPlace());
        holder.order_date_time.setText(allAdoptPetsModels.get(position).getDate());
        holder.cellnow.setText(allAdoptPetsModels.get(position).getPhone_number());
        holder.acceptOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRequestActivity.accpetOrder(allAdoptPetsModels.get(position).getPhone_number());
            }
        });
        holder.callme.setOnClickListener(
            v -> myRequestActivity.callme(allAdoptPetsModels.get(position).getPhone_number()));
    }

    @Override
    public int getItemCount() {
        return allAdoptPetsModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView order_user_name;
      private TextView order_phone_number;
      private final TextView order_address_city;
      private final TextView order_date_time;
      private final TextView cellnow;
      private final TextView callme;
      private final TextView acceptOrder;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            order_address_city = itemView.findViewById(R.id.order_address_city);
            order_date_time = itemView.findViewById(R.id.order_date_time);
            cellnow = itemView.findViewById(R.id.cellnow);
            callme = itemView.findViewById(R.id.callme);
            acceptOrder = itemView.findViewById(R.id.acceptOrder);
        }
    }
}
