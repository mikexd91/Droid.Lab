package com.project.is3261.is3261_firebase.Model.Lessons;

import android.widget.ImageView;

/**
 * Created by xunda on 19/10/17.
 */

public class Lesson {
    public String author;
    public String title;
    public String[] description;
    public String url;
    public ImageView urlImageView;
    public String urlToImage;
    public String publishedAt;
    public String youtube;
    public String image;
    public int imageId;
    public boolean isVideoAvailable;
    public boolean isImageAvailable;

    public Lesson(){

    }
    public Lesson(String youtube, boolean isVideoAvailable){
        this.youtube = youtube;
        this.isVideoAvailable = isVideoAvailable;
    }

    public Lesson(String title, String[] description, boolean isVideoAvailable, boolean isImageAvailable) {
        this.title = title;
        this.description = description;
        this.isVideoAvailable = isVideoAvailable;
        this.isImageAvailable = isImageAvailable;
        //this.urlToImage = urlToImage;
    }

    public Lesson(String title, boolean isVideoAvailable, boolean isImageAvailable) {
        this.title = title;
        this.isVideoAvailable = isVideoAvailable;
        this.isImageAvailable = isImageAvailable;
    }

    public Lesson(String title, String youtube, boolean isVideoAvailable, boolean isImageAvailable) {
        this.title = title;
        this.isVideoAvailable = isVideoAvailable;
        this.isImageAvailable = isImageAvailable;
        this.youtube = youtube;
    }

    public Lesson(String title, String[] description, String youtube, boolean isVideoAvailable, boolean isImageAvailable) {
        this.title = title;
        this.description = description;
        this.isVideoAvailable = isVideoAvailable;
        this.isImageAvailable = isImageAvailable;
        this.youtube = youtube;
        //this.urlToImage = urlToImage;
    }

    public Lesson(String title, String[] description, String youtube, String image, boolean isVideoAvailable, boolean isImageAvailable) {
        this.title = title;
        this.description = description;
        this.isVideoAvailable = isVideoAvailable;
        this.isImageAvailable = isImageAvailable;
        this.youtube = youtube;
        this.image = image;
        //this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getYoutube() { return youtube;}

    public boolean isVideoAvailable(){ return isVideoAvailable;}

    public boolean isImageAvailable(){ return isImageAvailable;}

    public String[] getDescription() {
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
