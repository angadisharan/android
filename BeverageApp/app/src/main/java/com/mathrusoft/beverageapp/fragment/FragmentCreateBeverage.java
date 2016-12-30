package com.mathrusoft.beverageapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.beverageapp.R;
import com.mathrusoft.beverageapp.database.DataSource;
import com.mathrusoft.beverageapp.model.ModelBeverage;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class FragmentCreateBeverage extends Fragment {


    EditText mEditTextName;
    EditText mEditTextPrice;
    EditText mEditTextDescription;
    Button mButtonSave;

    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_beverage, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());
    }

    private void initViews(View view) {
        mEditTextName = (EditText) view.findViewById(R.id.beverage_name);
        mEditTextPrice = (EditText) view.findViewById(R.id.beverage_price);
        mEditTextDescription = (EditText) view.findViewById(R.id.beverage_description);
        mButtonSave = (Button) view.findViewById(R.id.button_submit);

        mButtonSave.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ModelBeverage modelBeverage = new ModelBeverage();
            modelBeverage.setName(mEditTextName.getText().toString());
            try {
                float price = Float.parseFloat(mEditTextPrice.getText().toString());
                modelBeverage.setPrice(price);
            } catch (Exception e) {
                Toast.makeText(mContext, "Invalid Price", Toast.LENGTH_SHORT).show();
                return;
            }
            modelBeverage.setDescription(mEditTextDescription.getText().toString());

            long id = new DataSource(mContext).insertBeverage(modelBeverage);
            Toast.makeText(mContext, "Insert ID " + id, Toast.LENGTH_SHORT).show();

            mEditTextName.setText("");
            mEditTextPrice.setText("");
            mEditTextDescription.setText("");

        }
    };

}
