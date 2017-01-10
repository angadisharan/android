package com.mathrusoft.beverageapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mathrusoft.beverageapp.adapter.PagerAdapterBeverageDetails;
import com.mathrusoft.beverageapp.fragment.FragmentBeverageDetails;
import com.mathrusoft.beverageapp.fragment.FragmentBeverageRating;
import com.mathrusoft.beverageapp.fragment.FragmentRestaurantLocation;
import com.mathrusoft.beverageapp.model.ModelBeverage;

/**
 * Created by sharanangadi on 06/01/17.
 */

public class ActivityBeverageDetails extends AppCompatActivity {

    public static final String KEY_DATA = "KEY_DATA";

    ViewPager mViewPager;
    TabLayout mTabLayout;
    PagerAdapterBeverageDetails mPagerAdapterBeverageDetails;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this.getApplicationContext();


        setContentView(R.layout.activity_beverage_details);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mPagerAdapterBeverageDetails = new PagerAdapterBeverageDetails(getSupportFragmentManager());

        handleIntent(getIntent());

        addFragments();


    }

    ModelBeverage mModelBeverage;

    private void handleIntent(Intent intent) {
        mModelBeverage = (ModelBeverage) intent.getSerializableExtra(KEY_DATA);

        if (mModelBeverage != null) {
            Toast.makeText(mContext, "Got Data " + mModelBeverage.getName() + " ", Toast.LENGTH_SHORT).show();
        }
    }


    private void addFragments() {


        FragmentBeverageDetails fragmentBeverageDetails = new FragmentBeverageDetails();

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_DATA, mModelBeverage);
        fragmentBeverageDetails.setArguments(bundle);

        mPagerAdapterBeverageDetails.addFragment(fragmentBeverageDetails, getString(R.string.details));
        mPagerAdapterBeverageDetails.addFragment(new FragmentBeverageRating(), getString(R.string.rating));
        mPagerAdapterBeverageDetails.addFragment(new FragmentRestaurantLocation(), getString(R.string.restaurant_location));

        mViewPager.setAdapter(mPagerAdapterBeverageDetails);

        mTabLayout.setupWithViewPager(mViewPager);
    }


}
