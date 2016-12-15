package com.mathrusoft.demostartactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sharanangadi on 15/12/16.
 */

public class ActivityB extends AppCompatActivity {

    Button mButtonFinish;
    Button mButtonLaunchMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_b);

        mButtonFinish = (Button) findViewById(R.id.finish);
        mButtonLaunchMain = (Button) findViewById(R.id.launch_main);

        mButtonFinish.setOnClickListener(mOnClickListener);
        mButtonLaunchMain.setOnClickListener(mOnClickListener);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.finish:
                    ActivityB.this.finish();
                    break;
                case R.id.launch_main:
                    Intent intent = new Intent(ActivityB.this, MainActivity.class);
                    ActivityB.this.startActivity(intent);
                    break;
            }
        }
    };

}
