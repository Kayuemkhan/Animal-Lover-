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
import code.fortomorrow.animallover.ui.MyOrdersActivity;
import code.fortomorrow.animallover.R;

public class MyOrdersAdapters extends RecyclerView.Adapter<MyOrdersAdapters.Viewholder> {
    private Context context;
    private List<AllAdoptPetsModel> myOders;
    private String phone;
    public MyOrdersAdapters(MyOrdersActivity myOrdersActivity, List<AllAdoptPetsModel> myOrdersListData, String phone_number) {
        this.context = myOrdersActivity;
        this.myOders = myOrdersListData;
        this.phone = phone_number;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singlemyorderspage,parent,false);
        return new MyOrdersAdapters.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.order_user_name.setText(myOders.get(position).getPetsName());
        holder.order_phone_number.setText(phone);
        holder.order_address_city.setText(myOders.get(position).getPetsPlace());
        holder.order_date_time.setText(myOders.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return myOders.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView order_user_name, order_phone_number,order_address_city,order_date_time;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            order_user_name = itemView.findViewById(R.id.order_user_name);
            order_phone_number = itemView.findViewById(R.id.order_phone_number);
            order_address_city = itemView.findViewById(R.id.order_address_city);
            order_date_time = itemView.findViewById(R.id.order_date_time);

        }
    }
}
