package com.mathrusoft.demostartactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButtonLaunchActivityB;

    TextView mTextViewUserId;
    TextView mTextViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewUserId = (TextView) findViewById(R.id.user_id);
        mTextViewPassword = (TextView) findViewById(R.id.password);

        SharedPreferences preferences = getSharedPreferences("local", Context.MODE_PRIVATE);
        String userId = preferences.getString("user_id", "");
        String password = preferences.getString("password", "");

        mTextViewUserId.setText(userId);
        mTextViewPassword.setText(password);


        mButtonLaunchActivityB = (Button) findViewById(R.id.button_launch_activity_b);
        mButtonLaunchActivityB.setOnClickListener(mOnClickListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Launch Activity B

            Intent intent = new Intent(MainActivity.this, ActivityB.class);
            MainActivity.this.startActivity(intent);

        }
    };

}
