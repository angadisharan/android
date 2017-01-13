package com.mathrusoft.beverageapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 12/01/17.
 */

public class DemoService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Sercice started", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < 10; i++) {
            Log.d("MYAPP", "inside service LOOP " + i);
        }

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MYAPP", "inside service onDestroy");

        Toast.makeText(this, "Sercice Stoped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
