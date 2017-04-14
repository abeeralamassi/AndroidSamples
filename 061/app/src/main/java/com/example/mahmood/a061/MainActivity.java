package com.example.mahmood.a061;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());


        TabObject tab1=new TabObject(new HomeFragment(),"Home");
        TabObject tab2=new TabObject(new TopFreeFragment(),"Top Free");
        TabObject tab3=new TabObject(new TopPaidFragment(),"Top Paid");

        adapter.addTab(tab1);
        adapter.addTab(tab2);
        adapter.addTab(tab3);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
