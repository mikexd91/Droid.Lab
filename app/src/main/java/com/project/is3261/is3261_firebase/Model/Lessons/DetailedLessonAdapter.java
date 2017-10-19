package com.project.is3261.is3261_firebase.Model.Lessons;

/**
 * Created by xunda on 19/10/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.DetailedLessonScreenSlideFragment;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class DetailedLessonAdapter extends FragmentStatePagerAdapter {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    public DetailedLessonAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new DetailedLessonScreenSlideFragment();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
