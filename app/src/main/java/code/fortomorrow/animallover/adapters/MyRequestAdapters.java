package code.fortomorrow.animallover.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import code.fortomorrow.animallover.ModelClass.AllAdoptPetsModel;
import code.fortomorrow.animallover.MyRequestActivity;
import code.fortomorrow.animallover.R;

public class MyRequestAdapters extends RecyclerView.Adapter<MyRequestAdapters.Viewholder> {
    private Context context;
    private List<AllAdoptPetsModel> allAdoptPetsModels;
    private String phone_number;
    public MyRequestAdapters(MyRequestActivity myRequestActivity, List<AllAdoptPetsModel> myOrdersListData, String phone_number) {
        this.context = myRequestActivity;
        this.allAdoptPetsModels = myOrdersListData;
        this.phone_number = phone_number;
        Log.d("state","I'm here");
    }

    @NonNull
    @Override
    public MyRequestAdapters.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singlemyordersreqpage,parent,false);
        return new MyRequestAdapters.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestAdapters.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allAdoptPetsModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView order_user_name,order_phone_number,order_address_city,order_date_time,cellnow,callme,acceptOrder;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            order_user_name = itemView.findViewById(R.id.order_user_name);
            order_phone_number = itemView.findViewById(R.id.order_phone_number);
            order_address_city = itemView.findViewById(R.id.order_address_city);
            order_date_time = itemView.findViewById(R.id.order_date_time);
            cellnow = itemView.findViewById(R.id.cellnow);
            callme = itemView.findViewById(R.id.callme);
            acceptOrder = itemView.findViewById(R.id.acceptOrder);
        }
    }
}
