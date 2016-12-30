package com.mathrusoft.beverageapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.List;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class AdapterBeverageList extends ArrayAdapter<ModelBeverage> {

    Context mContext;
    List<ModelBeverage> list;

    public AdapterBeverageList(Context context, int resource, List<ModelBeverage> objects) {
        super(context, resource, objects);
        list = objects;
        mContext = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_beverage, null);
        }

        ModelBeverage modelBeverage = list.get(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(modelBeverage.getName());
        ((TextView) convertView.findViewById(R.id.price)).setText(modelBeverage.getPrice() + "");
        ((TextView) convertView.findViewById(R.id.description)).setText(modelBeverage.getDescription());

        return convertView;
    }
}
