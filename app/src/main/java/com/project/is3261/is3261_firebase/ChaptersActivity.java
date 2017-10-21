package com.project.is3261.is3261_firebase;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import layout.Chapters.ChaptersDataStorageFragment;
import layout.Chapters.ChaptersMultiscreenFragment;
import layout.Chapters.ChaptersNetworkingFragment;
import layout.Chapters.ChaptersUserInputFragment;
import layout.Chapters.ChaptersUserInterfaceFragment;

public class ChaptersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        String title = getIntent().getStringExtra("title");
        Toast.makeText(this, title,Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (title.equals("User Interface")) {
            ChaptersUserInterfaceFragment chaptersUserInterfaceFragment = new ChaptersUserInterfaceFragment();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersUserInterfaceFragment);
        }
        else if (title.equals("User Input")) {
            ChaptersUserInputFragment chaptersUserInputFragment = new ChaptersUserInputFragment();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersUserInputFragment);
        }
        else if (title.equals("Multiple Screen")) {
            ChaptersMultiscreenFragment chaptersMultiscreenFragment = new ChaptersMultiscreenFragment();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersMultiscreenFragment);
        }
        else if (title.equals("Data Storage")) {
            ChaptersDataStorageFragment chaptersDataStorageFragment = new ChaptersDataStorageFragment();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersDataStorageFragment);
        }
        else if (title.equals("Networking")) {
            ChaptersNetworkingFragment chaptersNetworkingFragment = new ChaptersNetworkingFragment();
            fragmentTransaction.replace(R.id.chapterFrame, chaptersNetworkingFragment);
        }

        fragmentTransaction.commit();
    }
}
