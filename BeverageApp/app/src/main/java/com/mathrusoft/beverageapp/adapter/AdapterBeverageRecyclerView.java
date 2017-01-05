package com.mathrusoft.beverageapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.callback.CallbackItemEdit;
import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.List;


/**
 * Created by sharanangadi on 03/01/17.
 */

public class AdapterBeverageRecyclerView extends RecyclerView.Adapter<AdapterBeverageRecyclerView.MyViewHolder> {

    List<ModelBeverage> mList;

    Context mContext;

    public AdapterBeverageRecyclerView(Context context, List<ModelBeverage> list) {
        mContext = context;
        mList = list;
    }

    CallbackItemEdit mCallbackItemEdit;

    public void setEditCallback(CallbackItemEdit editCallback) {
        mCallbackItemEdit = editCallback;
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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ModelBeverage modelBeverage = mList.get(holder.getAdapterPosition());

        holder.mName.setText(modelBeverage.getName() + "");
        holder.mPrice.setText(modelBeverage.getPrice() + "");
        holder.mDescription.setText(modelBeverage.getDescription());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.edit:
                        mCallbackItemEdit.doEdit(holder.getAdapterPosition());
                        break;
                    case R.id.delete:
                        mCallbackItemEdit.doDelete(holder.getAdapterPosition());
                        break;
                }
            }
        };

        holder.mImageViewEdit.setOnClickListener(onClickListener);
        holder.mImageViewDelete.setOnClickListener(onClickListener);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mPrice;
        TextView mDescription;

        ImageView mImageViewEdit;
        ImageView mImageViewDelete;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mDescription = (TextView) itemView.findViewById(R.id.description);

            mImageViewDelete = (ImageView) itemView.findViewById(R.id.delete);
            mImageViewEdit = (ImageView) itemView.findViewById(R.id.edit);
        }
    }

}
