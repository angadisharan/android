package com.mathrusoft.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ActivityLifeCycleDemo extends AppCompatActivity {

    private static final String TAG = "MYAPP:ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_demo);

        findViewById(R.id.button_launch_activity_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityLifeCycleDemo.this, ActivityListDemo.class);
                startActivity(intent);

            }
        });

        Log.d(TAG, "insice Oncreate =============");


        attachFragment();

    }

    private void attachFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, new DemoFragment());
        fragmentTransaction.commit();
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
