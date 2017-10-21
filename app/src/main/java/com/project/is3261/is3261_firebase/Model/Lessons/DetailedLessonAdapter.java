package com.project.is3261.is3261_firebase.Model.Lessons;

/**
 * Created by xunda on 19/10/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

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
    private Lesson mLesson;
    private int fragNum;
    private int lessonNum;
    private String lessonType;

    public DetailedLessonAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.mFragmentManager = fm;
        this.fragmentBundle = bundle;

        this.fragNum = fragmentBundle.getInt("val");
        this.lessonType = fragmentBundle.getString("title");
        this.lessonNum = fragmentBundle.getInt("lesson");
        LessonGenerator newLesson = new LessonGenerator(fragNum, lessonType, lessonNum);
        this.mLesson = newLesson.getLesson();
        this.mLessonList = newLesson.getLessonList();
    }

    @Override
    public int getCount() {
        return mLessonList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
//        this.fragmentBundle.putInt("val",position);
//        DetailedLessonScreenSlideFragment mFragment = new DetailedLessonScreenSlideFragment();
//        mFragment.setArguments(this.fragmentBundle);
//        return mFragment;
        return DetailedLessonScreenSlideFragment.init(position,lessonType,lessonNum);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
