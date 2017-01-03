package com.mathrusoft.beverageapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.List;


/**
 * Created by sharanangadi on 03/01/17.
 */

public class AdapterBeverageRecyclerView extends RecyclerView.Adapter<AdapterBeverageRecyclerView.MyViewHolder> {

    List<ModelBeverage> mList;

    public AdapterBeverageRecyclerView(List<ModelBeverage> list) {
        mList = list;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beverage_recycler_view, null);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelBeverage modelBeverage = mList.get(holder.getAdapterPosition());

        holder.mPrice.setText(modelBeverage.getPrice() + "");
        holder.mDescription.setText(modelBeverage.getDescription());
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mPrice;
        TextView mDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mDescription = (TextView) itemView.findViewById(R.id.description);
        }
    }

}
