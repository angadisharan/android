package com.mathrusoft.beverageapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.adapter.AdapterBeverageList;
import com.mathrusoft.beverageapp.database.DataSource;
import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class FragmentBeverageList extends Fragment {

    List<ModelBeverage> mListModelBeverage = new ArrayList<>();
    AdapterBeverageList mAdapterBeverageList;
    ListView mListView;
    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beverage_list, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());
    }

    private void initViews(View view) {
        mListView = (ListView) view.findViewById(R.id.list_beverage);

        mAdapterBeverageList = new AdapterBeverageList(mContext, -1, mListModelBeverage);
        mListView.setAdapter(mAdapterBeverageList);

        getDataFromDB();
    }

    private void getDataFromDB() {
        List<ModelBeverage> dbData = new DataSource(mContext).getAllBeverages();
        mListModelBeverage.clear();
        mListModelBeverage.addAll(dbData);
        mAdapterBeverageList.notifyDataSetChanged();

    }
}
