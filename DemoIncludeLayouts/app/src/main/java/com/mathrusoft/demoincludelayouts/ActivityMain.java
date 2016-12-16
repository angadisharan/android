package com.mathrusoft.demoincludelayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {

    Button mButtonA;
    Button mButtonB;
    TextView mTextViewA;
    TextView mTextViewB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mButtonA = (Button) findViewById(R.id.button_a);
        mButtonB = (Button) findViewById(R.id.button_b);

        mTextViewA = (TextView) findViewById(R.id.textview_a);
        mTextViewB = (TextView) findViewById(R.id.textview_b);

        mButtonA.setOnClickListener(mOnClickListener);
        mButtonB.setOnClickListener(mOnClickListener);

    }

    int mCountButtonA;
    int mCountButtonB;


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_a:
                    mCountButtonA++;
                    mTextViewA.setText("Button click count " + mCountButtonA);
                    break;
                case R.id.button_b:
                    mCountButtonB++;
                    mTextViewB.setText("Button click count " + mCountButtonB);
                    break;
            }

        }
    };

}
