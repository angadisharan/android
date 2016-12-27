package com.mathrusoft.activitylifecycle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ActivityB extends AppCompatActivity {
    private static final String TAG = "MYAPP:ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d(TAG, "insice Oncreate =============");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "insice onStart =============");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "insice onResume =============");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "insice onPause =============");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "insice onStop =============");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "insice onDestroy =============");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "insice onRestart =============");

    }

}
