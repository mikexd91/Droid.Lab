package com.project.is3261.is3261_firebase.Model.Quiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import layout.DetailedQuizSlideFragment;

/**
 * Created by xunda on 26/10/17.
 */

public class DetailedQuizAdapter  extends FragmentStatePagerAdapter {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */

    private FragmentManager mFragmentManager;
    private ArrayList<Quiz> mQuizList;
    private final Bundle fragmentBundle;
    private Quiz mQuiz;
    private int fragNum;
    private int quizNum;
    private String quizType;

    public DetailedQuizAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.mFragmentManager = fm;
        this.fragmentBundle = bundle;

        this.fragNum = fragmentBundle.getInt("val");
        this.quizType = fragmentBundle.getString("title");
        this.quizNum = fragmentBundle.getInt("quiz");
        QuizGenerator newQuiz = new QuizGenerator(fragNum, quizType, quizNum);
        this.mQuiz = newQuiz.getQuiz();
        this.mQuizList = newQuiz.getQuizList();
    }

    @Override
    public int getCount() {
        return mQuizList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
//        this.fragmentBundle.putInt("val",position);
//        DetailedQuizScreenSlideFragment mFragment = new DetailedQuizScreenSlideFragment();
//        mFragment.setArguments(this.fragmentBundle);
//        return mFragment;
        return DetailedQuizSlideFragment.init(position,quizType,quizNum);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
