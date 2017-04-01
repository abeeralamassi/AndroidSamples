package com.example.mahmood.a061;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mahmood on 4/1/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<TabObject> tabs=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    public void addTab(TabObject tab)
    {
        tabs.add(tab);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }
}
