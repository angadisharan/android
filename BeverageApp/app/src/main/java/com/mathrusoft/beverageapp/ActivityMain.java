package com.mathrusoft.beverageapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mathrusoft.beverageapp.fragment.FragmentBeverageList;
import com.mathrusoft.beverageapp.fragment.FragmentBeverageRecyclerView;
import com.mathrusoft.beverageapp.fragment.FragmentCreateBeverage;
import com.mathrusoft.beverageapp.service.DemoService;

public class ActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        showNotification();

        Intent intent = new Intent(mContext, DemoService.class);
        startService(intent);
    }

    private void showNotification() {


        Intent actionContentIntent = new Intent(mContext, ActivityMain.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 123, actionContentIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent intentActionOne = new Intent(mContext, ActivityActionOne.class);
        PendingIntent pendingIntentActionOne = PendingIntent.getActivity(this, 1212, intentActionOne, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new android.support.v7.app.NotificationCompat.Builder(mContext)
                .setVisibility(android.support.v7.app.NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent) // #3
                .setContentTitle("Title here ")
                .setContentText("Notification message here ")
                .setAutoCancel(true)
                .addAction(R.drawable.ic_menu_camera, "Action One", pendingIntentActionOne)
                .addAction(R.drawable.ic_menu_camera, "dummy action", pendingIntentActionOne)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .build();

            NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(211, notification);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_beverage:
                getSupportActionBar().setTitle("Create Beverage");
                switchFragment(new FragmentCreateBeverage());
                break;
            case R.id.beverage_list:
                getSupportActionBar().setTitle("Beverage List");
                switchFragment(new FragmentBeverageList());
                break;
            case R.id.nav_recycler_view_beverage:
                getSupportActionBar().setTitle("Beverage (Recycler View)");
                switchFragment(new FragmentBeverageRecyclerView());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, fragment);
        fragmentTransaction.commit();
    }
}
