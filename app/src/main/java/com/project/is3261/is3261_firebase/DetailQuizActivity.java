package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.project.is3261.is3261_firebase.Model.Quiz.DetailedQuizAdapter;
import com.project.is3261.is3261_firebase.Model.Quiz.Quiz;

import java.util.ArrayList;

public class DetailQuizActivity extends AppCompatActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private DetailedQuizAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quiz);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra("title");
        int quiz = getIntent().getIntExtra("quiz", 0);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("quiz", quiz);

        if (title.equalsIgnoreCase("userInterface")) {
            title = "User Interface";
        } else if (title.equalsIgnoreCase("userInput")) {
            title = "User Input";
        } else if (title.equalsIgnoreCase("multiscreen")) {
            title = "Multiscreen";
        } else if (title.equalsIgnoreCase("extraQuestions")) {
            title = "Extra Questions";
        }

        getSupportActionBar().setTitle(title);

        ArrayList<Quiz> mQuizList = new ArrayList<Quiz>();
        this.mAdapter = new DetailedQuizAdapter(getSupportFragmentManager(), bundle);
        this.mPager = (ViewPager) findViewById(R.id.pager);
        this.mPager.setAdapter(this.mAdapter);
        //Toast.makeText(this,"display thisss: "+ quiz,Toast.LENGTH_SHORT).show();
        this.mPager.setCurrentItem(quiz);

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
