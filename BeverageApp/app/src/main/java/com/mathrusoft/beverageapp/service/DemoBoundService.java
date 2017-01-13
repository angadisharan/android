package com.mathrusoft.beverageapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 13/01/17.
 */

public class DemoBoundService extends Service {


    List<String> mSongList = new ArrayList<>();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        for (int i = 0; i < 10; i++) {
            Log.d("MYAPP", "inside service LOOP " + i);
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MYAPP", "DemoBoundService service onDestroy");

        Toast.makeText(this, "Sercice Stoped", Toast.LENGTH_SHORT).show();
    }

    MyBinder iBinder = new MyBinder();

    public class MyBinder extends Binder {
        public DemoBoundService getService() {
            return DemoBoundService.this;
        }
    }

    String mCurrentSongStatus;
    int currentSongPosition = 0;

    public void initSongs() {
        for (int i = 0; i < 20; i++) {
            mSongList.add("Song " + i);
        }
    }

    public void playNext() {
        mCurrentSongStatus = "PLAYING";
        currentSongPosition++;
        if (currentSongPosition >= mSongList.size()) {
            currentSongPosition = 0;
        }
    }

    public void playPrevious() {
        mCurrentSongStatus = "PLAYING";
        currentSongPosition--;
        if (currentSongPosition < 0) {
            currentSongPosition = 0;
        }
    }

    public void pause() {
        mCurrentSongStatus = "PAUSE";
    }

    public String getCurrentStatus() {
        return mSongList.get(currentSongPosition) + " " + mCurrentSongStatus;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
