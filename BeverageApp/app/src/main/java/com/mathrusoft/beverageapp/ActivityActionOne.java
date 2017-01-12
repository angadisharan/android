package com.mathrusoft.beverageapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mathrusoft.beverageapp.service.DemoIntentService;
import com.mathrusoft.beverageapp.service.DemoService;

/**
 * Created by sharanangadi on 11/01/17.
 */

public class ActivityActionOne extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_action_one);

        mContext = this.getApplicationContext();

        findViewById(R.id.start_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.stop_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.start_intent_service).setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start_service:
                    Intent intentStartService = new Intent(mContext, DemoService.class);
                    mContext.startService(intentStartService);
                    break;
                case R.id.stop_service:
                    Intent intentStopService = new Intent(mContext, DemoService.class);
                    mContext.stopService(intentStopService);
                    break;
                case R.id.start_intent_service:
                    Intent intentIntentService = new Intent(mContext, DemoIntentService.class);
                    mContext.startService(intentIntentService);
                    break;
            }
        }
    };

}
