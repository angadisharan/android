package com.mathrusoft.beverageapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathrusoft.beverageapp.ActivityBeverageDetails;
import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.model.ModelBeverage;

/**
 * Created by sharanangadi on 06/01/17.
 */

public class FragmentBeverageDetails extends Fragment {


    ModelBeverage mModelBeverage;

    TextView mTextViewName;
    TextView mTextViewPrice;
    TextView mTextViewDescription;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            mModelBeverage = (ModelBeverage) getArguments().getSerializable(ActivityBeverageDetails.KEY_DATA);
        }

        return inflater.inflate(R.layout.fragment_beverage_details, null);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews(getView());
    }

    private void initViews(View view) {
        mTextViewName = (TextView) view.findViewById(R.id.name);
        mTextViewPrice = (TextView) view.findViewById(R.id.price);
        mTextViewDescription = (TextView) view.findViewById(R.id.description);

        if (mModelBeverage == null) {
            return;
        }
        mTextViewName.setText(mModelBeverage.getName());
        mTextViewPrice.setText(mModelBeverage.getPrice() + "");
        mTextViewDescription.setText(mModelBeverage.getDescription());
    }
}
