package com.mathrusoft.beverageapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 06/01/17.
 */

public class PagerAdapterBeverageDetails extends FragmentStatePagerAdapter {

    List<Fragment> mFragmentList = new ArrayList<>();
    List<String> mTitles = new ArrayList<>();

    public PagerAdapterBeverageDetails(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mTitles.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
