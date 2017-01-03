package com.mathrusoft.beverageapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.adapter.AdapterBeverageRecyclerView;
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

        mAdapterBeverageRecyclerView = new AdapterBeverageRecyclerView(mList);

        mRecyclerView.setAdapter(mAdapterBeverageRecyclerView);
        getDataFromDB();
    }

    private void getDataFromDB() {
        List<ModelBeverage> dbData = new DataSource(mContext).getAllBeverages();
        mList.clear();
        mList.addAll(dbData);
        mAdapterBeverageRecyclerView.notifyDataSetChanged();
    }


}
