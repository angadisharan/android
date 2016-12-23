package com.mathrusoft.activitynavpaneldemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mathrusoft.activitynavpaneldemo.fragment.FragmentCamera;
import com.mathrusoft.activitynavpaneldemo.fragment.FragmentGallery;
import com.mathrusoft.activitynavpaneldemo.fragment.FragmentHome;
import com.mathrusoft.activitynavpaneldemo.fragment.FragmentSlideShow;
import com.mathrusoft.activitynavpaneldemo.fragment.FragmentTools;

public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Context mContext;

//    Button mButtonChangeVisibility;
//    TextView mTextViewOne;
//    TextView mTextViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(mOnClickListener);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_holder, new FragmentHome());
        fragmentTransaction.commit();

        Log.d("MYAPP", " Updated code here ======== ");
//        System.out.print("dsfa sdf dsafds fd");

//        mButtonChangeVisibility = (Button) findViewById(R.id.button_change_visibility);
//        mButtonChangeVisibility.setOnClickListener(mOnClickListener);
//
//        mTextViewOne = (TextView) findViewById(R.id.text_one);
//        mTextViewTwo = (TextView) findViewById(R.id.text_two);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fab:
                    Toast.makeText(mContext, "Fab clicked", Toast.LENGTH_SHORT).show();
                    break;
//                case R.id.button_change_visibility:
//                    changeVisibility();
//                    break;
            }
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
        }


    };

    private void changeVisibility() {

//        mTextViewOne.setVisibility(mTextViewOne.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
//        mTextViewTwo.setVisibility(mTextViewTwo.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);

//        if (mTextViewOne.getVisibility() == View.VISIBLE) {
//            mTextViewOne.setVisibility(View.GONE);
//            return;
//        }
//        if (mTextViewOne.getVisibility() == View.GONE) {
//            mTextViewOne.setVisibility(View.VISIBLE);
//            return;
//        }
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

        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.my_action_one:
                Toast.makeText(mContext, "Action one clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_action_two:
                Toast.makeText(mContext, "Action Two clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_camera:
                    replaceFragment(new FragmentCamera());
                    break;
                case R.id.nav_gallery:
                    replaceFragment(new FragmentGallery());
                    break;
                case R.id.nav_slideshow:
                    replaceFragment(new FragmentSlideShow());
                    break;
                case R.id.nav_manage:
                    replaceFragment(new FragmentTools());
                    break;
                case R.id.nav_share:
//                    replaceFragment(new FragmentTools());
                    Toast.makeText(mContext, "nav_share clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_send:
                    Toast.makeText(mContext, "nav_send clicked", Toast.LENGTH_SHORT).show();
            }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
