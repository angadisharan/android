package com.mathrusoft.beverageapp.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.adapter.AdapterBeverageRecyclerView;
import com.mathrusoft.beverageapp.callback.CallbackItemEdit;
import com.mathrusoft.beverageapp.database.DataSource;
import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 03/01/17.
 */

public class FragmentBeverageRecyclerView extends Fragment {


    private RecyclerView mRecyclerView;
    private AdapterBeverageRecyclerView mAdapterBeverageRecyclerView;
    List<ModelBeverage> mList = new ArrayList<>();
    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beverage_recycler_view, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());
    }

    private void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapterBeverageRecyclerView = new AdapterBeverageRecyclerView(mContext, mList);
        mAdapterBeverageRecyclerView.setEditCallback(mCallbackItemEdit);

        mRecyclerView.setAdapter(mAdapterBeverageRecyclerView);
        getDataFromDB();
    }

    private void getDataFromDB() {
        List<ModelBeverage> dbData = new DataSource(mContext).getAllBeverages();
        mList.clear();
        mList.addAll(dbData);
        mAdapterBeverageRecyclerView.notifyDataSetChanged();
    }


    CallbackItemEdit mCallbackItemEdit = new CallbackItemEdit() {
        @Override
        public void doEdit(int position) {
            showEditDialogue(position);
        }

        @Override
        public void doDelete(int position) {
            ModelBeverage modelBeverage = mList.get(position);
            new DataSource(mContext).deleteBeverage(modelBeverage);
            mList.remove(position);
            mAdapterBeverageRecyclerView.notifyDataSetChanged();
        }
    };

    private void showEditDialogue(int position) {
        final ModelBeverage modelBeverage = mList.get(position);


        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.fragment_create_beverage);

        final EditText editTextName = (EditText) dialog.findViewById(R.id.beverage_name);
        final EditText editTextPrice = (EditText) dialog.findViewById(R.id.beverage_price);
        final EditText editTextDescription = (EditText) dialog.findViewById(R.id.beverage_description);

        Button button = (Button) dialog.findViewById(R.id.button_submit);

        editTextName.setText(modelBeverage.getName());
        editTextPrice.setText(modelBeverage.getPrice() + "");
        editTextDescription.setText(modelBeverage.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelBeverage.setName(editTextName.getText().toString());
                float price = Float.parseFloat(editTextPrice.getText().toString());
                modelBeverage.setPrice(price);
                modelBeverage.setDescription(editTextDescription.getText().toString());

                new DataSource(mContext).updateBeverageModel(modelBeverage);
                mAdapterBeverageRecyclerView.notifyDataSetChanged();
                dialog.dismiss();

                Toast.makeText(mContext, "Beverage Updated", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }


}
