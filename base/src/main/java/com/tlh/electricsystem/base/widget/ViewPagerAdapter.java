package com.tlh.electricsystem.base.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;
    private List<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm,String[] mTitles, List<Fragment> fragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = fragments;
        fm.beginTransaction().commitAllowingStateLoss();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments == null ? new Fragment() : mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
