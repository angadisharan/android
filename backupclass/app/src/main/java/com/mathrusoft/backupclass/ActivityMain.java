package com.mathrusoft.backupclass;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    EditText mEditTextNumberA;
    EditText mEditTextNumberB;
    TextView mTextViewResult;
    Button mButtonAdd;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        mEditTextNumberA = (EditText) findViewById(R.id.number_a);
        mEditTextNumberB = (EditText) findViewById(R.id.number_b);

        mTextViewResult = (TextView) findViewById(R.id.result);

        mButtonAdd = (Button) findViewById(R.id.button_add);
        mButtonAdd.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String stringA = mEditTextNumberA.getText().toString();
            String stringB = mEditTextNumberB.getText().toString();


            try {
                int a = Integer.parseInt(stringA);
                int b = Integer.parseInt(stringB);
                String sum = a + " + " + b + " = " + (a + b);

                mTextViewResult.setText(sum);

                Toast.makeText(mContext, sum, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(mContext, "Invalid Int", Toast.LENGTH_SHORT).show();

            }


        }
    };

}
