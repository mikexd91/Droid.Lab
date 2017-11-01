package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.project.is3261.is3261_firebase.Model.Lessons.DetailedLessonAdapter;
import com.project.is3261.is3261_firebase.Model.Lessons.Lesson;

import java.util.ArrayList;

public class DetailLessonActivity extends AppCompatActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private DetailedLessonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lesson);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra("title");
        int lesson = getIntent().getIntExtra("lesson",0);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("lesson", lesson);

        if(title.equalsIgnoreCase("userinterface")){
            title = "User Interface";
        }else if(title.equalsIgnoreCase("userinput")){
            title = "User Input";
        }else if(title.equalsIgnoreCase("multiplescreen")){
            title = "Multiple Screens";
        }else if(title.equalsIgnoreCase("networking")){
            title = "Networking";
        }else{
            title = "Data Storage";
        }
        getSupportActionBar().setTitle(title);

        ArrayList<Lesson> mLessonList = new ArrayList<Lesson>();
        this.mAdapter = new DetailedLessonAdapter(getSupportFragmentManager(),bundle);
        this.mPager = (ViewPager) findViewById(R.id.pager);
        this.mPager.setAdapter(this.mAdapter);
        this.mPager.setOffscreenPageLimit(1);
        this.mPager.setPageTransformer(false, new ZoomOutPageTransformer());
        this.mPager.setCurrentItem(lesson);

        ProgressBar lessonProgress = (ProgressBar) findViewById(R.id.lessonProgress);
        lessonProgress.setMax(34);
        lessonProgress.setIndeterminate(false);
        lessonProgress.setProgress(this.mPager.getCurrentItem());

    }


    public void onComplete() {
        // After the fragment completes, it calls this callback.
        // setup the rest of your layout now
        this.mPager.setCurrentItem(0);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mPager.setCurrentItem(0);
    }

}

class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}

