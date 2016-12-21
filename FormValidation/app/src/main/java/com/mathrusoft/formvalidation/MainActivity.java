package com.mathrusoft.formvalidation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mathrusoft.formvalidation.model.ModelItem;

public class MainActivity extends AppCompatActivity {

    Button mButtonOrderItem;
    EditText mEditTextItemName;
    EditText mEditTextQuantity;
    EditText mEditTextDeliveryDate;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        mEditTextItemName = (EditText) findViewById(R.id.item_name);
        mEditTextQuantity = (EditText) findViewById(R.id.item_quantity);
        mEditTextDeliveryDate = (EditText) findViewById(R.id.delivery_date);

        mButtonOrderItem = (Button) findViewById(R.id.button_submit);
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

            ModelItem modelItem = new ModelItem();
            modelItem.setName(mEditTextItemName.getText().toString());

            try {
                int quantity = Integer.parseInt(mEditTextQuantity.getText().toString());
                modelItem.setQuantity(quantity);
            } catch (Exception e) {
                Toast.makeText(mContext, "Please enter valid number for quantity", Toast.LENGTH_SHORT).show();
                Log.d("MYAPP", "Could not parse int " + mEditTextQuantity.getText().toString());
                Log.d("MYAPP", e.getMessage());
                Log.e("MYAPP", "Exception", e);
                return;
            }

            modelItem.setDate(mEditTextDeliveryDate.getText().toString());

            sendDataToServer(modelItem);

            Toast.makeText(mContext, "Order Received", Toast.LENGTH_SHORT).show();
            //Clear old data
            mEditTextItemName.setText("");
            mEditTextQuantity.setText("");
            mEditTextDeliveryDate.setText("");
        }
    };

    private void sendDataToServer(ModelItem modelItem) {
        //perform submit data to server
    }


}
