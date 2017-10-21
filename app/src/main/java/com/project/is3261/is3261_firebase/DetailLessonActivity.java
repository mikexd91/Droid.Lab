package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

        getSupportActionBar().setTitle(title + " "+ lesson);

        ArrayList<Lesson> mLessonList = new ArrayList<Lesson>();
        this.mAdapter = new DetailedLessonAdapter(getSupportFragmentManager(),bundle);
        this.mPager = (ViewPager) findViewById(R.id.pager);
        this.mPager.setAdapter(this.mAdapter);

        Button button = (Button) findViewById(R.id.previous);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        });
        button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
        });

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
