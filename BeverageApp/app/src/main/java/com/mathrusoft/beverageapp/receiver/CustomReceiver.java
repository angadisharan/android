package com.mathrusoft.beverageapp.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.util.Log;

import com.mathrusoft.beverageapp.ActivityMain;
import com.mathrusoft.beverageapp.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by sharanangadi on 16/01/17.
 */

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MYAPP", "Inside onReceive CustomReceiver ========= ");

        Intent actionContentIntent = new Intent(context, ActivityMain.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 121, actionContentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new android.support.v7.app.NotificationCompat.Builder(context)
                .setVisibility(android.support.v7.app.NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent) // #3
                .setContentTitle("Custom receiver")
                .setContentText("Received Custom Receiver")
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(122, notification);

    }


}
