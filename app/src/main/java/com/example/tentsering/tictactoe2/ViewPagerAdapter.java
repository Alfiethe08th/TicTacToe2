package com.example.tentsering.tictactoe2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Tenzin on 06/06/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment1 = null, fragment2 = null, fragment3 = null;

        if(position == 0) {
            fragment1 = new FragmentOne();
            return fragment1;
        }else if(position ==1) {
            fragment2 = new FragmentTwo();
           return fragment2;
        }else{fragment3 = new FragmentThree();
        return fragment3;}
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Tab-1";
        } else if (position == 1) {
            title = "Tab-2";
        } else {
            title ="Tab-3";
        }
        return title;
    }


}
