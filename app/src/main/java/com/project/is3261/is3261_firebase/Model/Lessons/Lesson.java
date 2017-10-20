package com.project.is3261.is3261_firebase.Model.Lessons;

import android.widget.ImageView;

/**
 * Created by xunda on 19/10/17.
 */

public class Lesson {
    public String author;
    public String title;
    public String description;
    public String url;
    public ImageView urlImageView;
    public String urlToImage;
    public String publishedAt;
    public int imageId;

    public static final int USER_INTERFACE_1 = 5;
    public static final int USER_INTERFACE_2 = 5;
    public static final int USER_INTERFACE_3 = 5;
    public static final int USER_INTERFACE_4 = 5;
    public static final int USER_INTERFACE_5 = 5;

    public static final int USER_INPUT_1 = 5;
    public static final int USER_INPUT_2 = 5;
    public static final int USER_INPUT_3 = 5;
    public static final int USER_INPUT_4 = 5;
    public static final int USER_INPUT_5 = 5;

    public static final int MULTIPLE_SCREEN_1 = 5;
    public static final int MULTIPLE_SCREEN_2 = 5;
    public static final int MULTIPLE_SCREEN_3 = 5;
    public static final int MULTIPLE_SCREEN_4 = 5;
    public static final int MULTIPLE_SCREEN_5 = 5;

    public static final int DATA_STORAGE_1= 5;
    public static final int DATA_STORAGE_2= 5;
    public static final int DATA_STORAGE_3= 5;
    public static final int DATA_STORAGE_4= 5;
    public static final int DATA_STORAGE_5= 5;

    public static final int NETWORKING_1 = 5;
    public static final int NETWORKING_2 = 5;
    public static final int NETWORKING_3 = 5;
    public static final int NETWORKING_4 = 5;
    public static final int NETWORKING_5 = 5;


    public Lesson(String title, String description) {
        this.title = title;
        this.description = description;
        //this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUrl(){
        return url;
    }

    public String getImageUrl() {
        return urlToImage;
    }
}
