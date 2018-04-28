package com.example.panea.tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public class FragmentAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Main Attractions", "Parks", "Bars", "Clubs" };

    public FragmentAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MainAttractionsFragment();
        } else if (position == 1){
            return new ParksFragment();
        } else if (position == 2) {
            return new BarsFragment();
        } else {
            return new ClubsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
