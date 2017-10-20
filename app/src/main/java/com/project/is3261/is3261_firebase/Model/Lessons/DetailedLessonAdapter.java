package com.project.is3261.is3261_firebase.Model.Lessons;

/**
 * Created by xunda on 19/10/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import layout.DetailedLessonScreenSlideFragment;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class DetailedLessonAdapter extends FragmentStatePagerAdapter {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */

    private FragmentManager mFragmentManager;
    private ArrayList<Lesson> mLessonList;
    private final Bundle fragmentBundle;

    public DetailedLessonAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.mFragmentManager = fm;
        this.fragmentBundle = bundle;
    }

    @Override
    public int getCount() {
        if (fragmentBundle.getString("title").toString().equalsIgnoreCase("userInterface")){
            switch(fragmentBundle.getInt("lesson")){
                case 1:
                    return Lesson.USER_INTERFACE_1;
                case 2:
                    return Lesson.USER_INTERFACE_2;
                case 3:
                    return Lesson.USER_INTERFACE_3;
                case 4:
                    return Lesson.USER_INTERFACE_4;
                case 5:
                    return Lesson.USER_INTERFACE_5;
            }
        }else if (fragmentBundle.getString("title").toString().equalsIgnoreCase("userInput")){
            switch(fragmentBundle.getInt("lesson")){
                case 1:
                    return Lesson.USER_INPUT_1;
                case 2:
                    return Lesson.USER_INPUT_2;
                case 3:
                    return Lesson.USER_INPUT_3;
                case 4:
                    return Lesson.USER_INPUT_4;
                case 5:
                    return Lesson.USER_INPUT_5;
            }
        }else if (fragmentBundle.getString("title").toString().equalsIgnoreCase("multipleScreen")){
            switch(fragmentBundle.getInt("lesson")){
                case 1:
                    return Lesson.MULTIPLE_SCREEN_1;
                case 2:
                    return Lesson.MULTIPLE_SCREEN_2;
                case 3:
                    return Lesson.MULTIPLE_SCREEN_3;
                case 4:
                    return Lesson.MULTIPLE_SCREEN_4;
                case 5:
                    return Lesson.MULTIPLE_SCREEN_5;
            }
        }else if (fragmentBundle.getString("title").toString().equalsIgnoreCase("dataStorage")){
            switch(fragmentBundle.getInt("lesson")){
                case 1:
                    return Lesson.DATA_STORAGE_1;
                case 2:
                    return Lesson.DATA_STORAGE_2;
                case 3:
                    return Lesson.DATA_STORAGE_3;
                case 4:
                    return Lesson.DATA_STORAGE_4;
                case 5:
                    return Lesson.DATA_STORAGE_5;
            }
        }else if (fragmentBundle.getString("title").toString().equalsIgnoreCase("networking")){
            switch(fragmentBundle.getInt("lesson")){
                case 1:
                    return Lesson.NETWORKING_1;
                case 2:
                    return Lesson.NETWORKING_2;
                case 3:
                    return Lesson.NETWORKING_3;
                case 4:
                    return Lesson.NETWORKING_4;
                case 5:
                    return Lesson.NETWORKING_5;
            }
        }
        return Lesson.USER_INTERFACE_1;
    }

    @Override
    public Fragment getItem(int position) {
        this.fragmentBundle.putInt("val",position);
        final DetailedLessonScreenSlideFragment mFragment = new DetailedLessonScreenSlideFragment();
        mFragment.setArguments(this.fragmentBundle);
        return mFragment;
    }


}
