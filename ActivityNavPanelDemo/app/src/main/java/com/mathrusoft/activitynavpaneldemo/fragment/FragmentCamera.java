package com.mathrusoft.activitynavpaneldemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.activitynavpaneldemo.R;

/**
 * Created by sharanangadi on 23/12/16.
 */

public class FragmentCamera extends Fragment {

    Button mButtonOrderItem;
    EditText mEditTextItemName;
    EditText mEditTextQuantity;
    EditText mEditTextDeliveryDate;

    Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, null);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity().getApplicationContext();

        initViews(getView());
    }

    private void initViews(View view) {
        mEditTextItemName = (EditText) view.findViewById(R.id.item_name);
        mEditTextQuantity = (EditText) view.findViewById(R.id.item_quantity);
        mEditTextDeliveryDate = (EditText) view.findViewById(R.id.delivery_date);

        mButtonOrderItem = (Button) view.findViewById(R.id.button_submit);
        mButtonOrderItem.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (TextUtils.isEmpty(mEditTextItemName.getText().toString())) {
                mEditTextItemName.setError("Name is Empty");
                mEditTextItemName.requestFocus();
                return;
            }

            if (TextUtils.isEmpty(mEditTextQuantity.getText().toString())) {
                mEditTextQuantity.setError("Quantity is Empty");
                mEditTextQuantity.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(mEditTextDeliveryDate.getText().toString())) {
                mEditTextDeliveryDate.setError("Delivery date is Empty");
                mEditTextDeliveryDate.requestFocus();
                return;
            }


            try {
                int quantity = Integer.parseInt(mEditTextQuantity.getText().toString());
            } catch (Exception e) {
                Toast.makeText(mContext, "Please enter valid number for quantity", Toast.LENGTH_SHORT).show();
                Log.d("MYAPP", "Could not parse int " + mEditTextQuantity.getText().toString());
                Log.d("MYAPP", e.getMessage());
                Log.e("MYAPP", "Exception", e);
                return;
            }

            Toast.makeText(mContext, "Order Received", Toast.LENGTH_SHORT).show();
            //Clear old data
            mEditTextItemName.setText("");
            mEditTextQuantity.setText("");
            mEditTextDeliveryDate.setText("");
        }
    };
}
