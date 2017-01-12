package com.mathrusoft.beverageapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 12/01/17.
 */

public class DemoIntentService extends IntentService {

    public DemoIntentService() {
        super("MyIntentDemoService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(this, "Sercice started", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < 10; i++) {
            Log.d("MYAPP", "inside service LOOP " + i);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("MYAPP", "inside service onDestroy");

        Toast.makeText(this, "Sercice Stoped", Toast.LENGTH_SHORT).show();

    }
}
