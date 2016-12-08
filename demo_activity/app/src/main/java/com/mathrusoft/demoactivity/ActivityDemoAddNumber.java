package com.mathrusoft.demoactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 08/12/16.
 */

public class ActivityDemoAddNumber extends Activity {

    private EditText mEditTextNumberA;
    private EditText mEditTextNumberB;
    private Button mButtonAdd;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_add_number);

        mEditTextNumberA = (EditText) findViewById(R.id.number_a);
        mEditTextNumberB = (EditText) findViewById(R.id.number_b);
        mButtonAdd = (Button) findViewById(R.id.button_add);

        mButtonAdd.setOnClickListener(mOnClickListener);

        mContext = this.getApplicationContext();

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String numberA = mEditTextNumberA.getText().toString();
            String numberB = mEditTextNumberB.getText().toString();

//            int a = Integer.parseInt(numberA);
//            int b = Integer.parseInt(numberB);

//            int sum = a + b;

            String message = "SUM = " + numberA + numberB;
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

        }
    };

}
