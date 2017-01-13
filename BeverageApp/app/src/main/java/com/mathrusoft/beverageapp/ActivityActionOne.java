package com.mathrusoft.beverageapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mathrusoft.beverageapp.service.DemoBoundService;
import com.mathrusoft.beverageapp.service.DemoIntentService;
import com.mathrusoft.beverageapp.service.DemoService;

/**
 * Created by sharanangadi on 11/01/17.
 */

public class ActivityActionOne extends AppCompatActivity {

    Context mContext;
    TextView textViewSongStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_action_one);

        mContext = this.getApplicationContext();

        textViewSongStatus = (TextView) findViewById(R.id.song_status);

        findViewById(R.id.start_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.stop_service).setOnClickListener(mOnClickListener);
        findViewById(R.id.start_intent_service).setOnClickListener(mOnClickListener);

        findViewById(R.id.next).setOnClickListener(mOnClickListener);
        findViewById(R.id.pause).setOnClickListener(mOnClickListener);
        findViewById(R.id.previous).setOnClickListener(mOnClickListener);
        findViewById(R.id.current_status).setOnClickListener(mOnClickListener);
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

                case R.id.next:
                    if (mDemoBoundService != null) {
                        mDemoBoundService.playNext();
                    }
                    break;

                case R.id.pause:
                    if (mDemoBoundService != null) {
                        mDemoBoundService.pause();
                    }
                    break;

                case R.id.previous:
                    if (mDemoBoundService != null) {
                        mDemoBoundService.playPrevious();
                    }
                    break;
                case R.id.current_status:
                    if (mDemoBoundService != null) {
                        textViewSongStatus.setText(mDemoBoundService.getCurrentStatus());
                    }
                    break;
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(mContext, DemoBoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mServiceConnection);
    }

    DemoBoundService mDemoBoundService;


    boolean mServiceBound = false;

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            Log.d("MYAPP", "Service Connected");

            DemoBoundService.MyBinder myBinder = (DemoBoundService.MyBinder) iBinder;
            mDemoBoundService = myBinder.getService();
            mServiceBound = true;
            mDemoBoundService.initSongs();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
            Log.d("MYAPP", "Service disconnected");

        }
    };

}
