package com.example.mehul.fragment_slider_demo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mehul.fragment_slider_demo.R;
import com.example.mehul.fragment_slider_demo.adapter.ViewPagerAdapter;
import com.example.mehul.fragment_slider_demo.fragments.FragmentOne;
import com.example.mehul.fragment_slider_demo.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    public static MainActivity instance;

    private ViewPagerAdapter adapter;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    private ViewPager viewPager;
    private TabLayout allTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance=this;

        getAllWidgets();
        setupViewPager();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    private void getAllWidgets() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        allTabs = (TabLayout) findViewById(R.id.tabs);
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        adapter.addFragment(fragmentOne, "One");
        adapter.addFragment(fragmentTwo, "Two");
        setViewPageAdapter();
    }

    private void setViewPageAdapter() {
        viewPager.setAdapter(adapter);
        allTabs.setupWithViewPager(viewPager);
    }
}
