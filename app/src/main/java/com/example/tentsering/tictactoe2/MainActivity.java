package com.example.tentsering.tictactoe2;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentOne.SendMessage{

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void sendDatatoTwo(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
        f.getReceivedMessage(message);
    }

//    @Override
//    public void sendDatatoThree(int score) {
//        String tag2 = "android:switcher:" + R.id.viewPager + ":" + 2;
//        FragmentThree f3 = (FragmentThree) getSupportFragmentManager().findFragmentByTag(tag2);
//        f3.getScore(score);
//    }
}

























