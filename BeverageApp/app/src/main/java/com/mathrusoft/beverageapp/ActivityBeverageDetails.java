package com.mathrusoft.beverageapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.beverageapp.adapter.PagerAdapterBeverageDetails;
import com.mathrusoft.beverageapp.fragment.FragmentBeverageDetails;
import com.mathrusoft.beverageapp.fragment.FragmentBeverageRating;
import com.mathrusoft.beverageapp.fragment.FragmentRestaurantLocation;

/**
 * Created by sharanangadi on 06/01/17.
 */

public class ActivityBeverageDetails extends AppCompatActivity {


    ViewPager mViewPager;
    TabLayout mTabLayout;
    PagerAdapterBeverageDetails mPagerAdapterBeverageDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beverage_details);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mPagerAdapterBeverageDetails = new PagerAdapterBeverageDetails(getSupportFragmentManager());

        addFragments();
    }

    private void addFragments() {
        mPagerAdapterBeverageDetails.addFragment(new FragmentBeverageDetails(), getString(R.string.details));
        mPagerAdapterBeverageDetails.addFragment(new FragmentBeverageRating(), getString(R.string.rating));
        mPagerAdapterBeverageDetails.addFragment(new FragmentRestaurantLocation(), getString(R.string.restaurant_location));

        mViewPager.setAdapter(mPagerAdapterBeverageDetails);

        mTabLayout.setupWithViewPager(mViewPager);
    }


}
