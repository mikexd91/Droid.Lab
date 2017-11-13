package com.project.is3261.is3261_firebase.Model.Status;

import android.widget.ImageView;

/**
 * Created by xunda on 6/10/17.
 */

public class Status {
    public String author;
    public String title;
    public String description;
    public String url;
    public ImageView urlImageView;
    public String urlToImage;
    public String publishedAt;
    public String time;
    public String timePosted;
    public int imageId;


    public Status(String status, String author, String time, String timePosted) {
        this.description = status;
        this.author = author;
        this.time = time;
        this.timePosted = timePosted;
    }

    public String getTimePosted(){ return timePosted;}

    public String getTime() {
        return time;
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
