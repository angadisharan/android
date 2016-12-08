package com.mathrusoft.demoactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 07/12/16.
 */

public class ActivityDemo extends Activity {

    private Button mButton;
    private EditText mEditTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);

        mButton = (Button) findViewById(R.id.button_greeting);
        mEditTextName = (EditText) findViewById(R.id.name);

        mButton.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String name = mEditTextName.getText().toString();
            String message = "Welcome " + name + " to Android Class";

            Toast.makeText(ActivityDemo.this.getApplicationContext(),
                    message,
                    Toast.LENGTH_SHORT).show();
        }
    };

}
