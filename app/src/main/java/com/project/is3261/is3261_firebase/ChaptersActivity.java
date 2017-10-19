package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import layout.Chapters.ChaptersUserInterfaceFragment;

public class ChaptersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        String title = getIntent().getStringExtra("title");

        if(title.equals("User Interface")){
            Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
            ChaptersUserInterfaceFragment chaptersUserInterfaceFragment = new ChaptersUserInterfaceFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersUserInterfaceFragment);
            fragmentTransaction.commit();
        }



    }
}
