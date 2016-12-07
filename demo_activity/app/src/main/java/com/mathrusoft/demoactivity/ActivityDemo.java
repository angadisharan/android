package com.mathrusoft.demoactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sharanangadi on 07/12/16.
 */

public class ActivityDemo extends Activity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);

        mButton = (Button) findViewById(R.id.button_greeting);
        mButton.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(ActivityDemo.this.getApplicationContext(),
                    "Welcome to Android Class",
                    Toast.LENGTH_SHORT).show();
        }
    };

}
