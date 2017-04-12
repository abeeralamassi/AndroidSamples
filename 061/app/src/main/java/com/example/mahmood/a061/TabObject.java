package com.example.mahmood.a061;

import android.support.v4.app.Fragment;

/**
 * Created by mahmood on 4/1/17.
 */

public class TabObject {

    public TabObject(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    Fragment fragment;
    String title;


}
