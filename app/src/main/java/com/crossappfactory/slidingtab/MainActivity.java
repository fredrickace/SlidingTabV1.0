package com.crossappfactory.slidingtab;

import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.crossappfactory.slidingtab.tabs.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager myViewPager;
    SlidingTabLayout slidingTabLayout;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.appToolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Fred");

        myViewPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyViewAdapter myViewAdapter = new MyViewAdapter(fragmentManager, this);
        myViewPager.setAdapter(myViewAdapter);

        slidingTabLayout =  (SlidingTabLayout) findViewById(R.id.slideTab);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setCustomTabView(R.layout.custom_tab, R.id.tabTextView);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorTab));
//        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//
//               return getResources().getColor(R.color.colorAccent);
//            }
//        });
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        slidingTabLayout.setViewPager(myViewPager);



    }
}
