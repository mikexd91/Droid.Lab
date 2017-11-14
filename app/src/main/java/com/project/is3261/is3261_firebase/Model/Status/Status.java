package com.project.is3261.is3261_firebase.Model.Status;

import android.widget.ImageView;

import java.util.List;

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
    public String uid;
    public int like;
    public int comment;
    public boolean hideButton;
    public List nameList;

    public Status(String status, String author, String time, String timePosted, String uid, int like, int comment, List namelist) {
        this.description = status;
        this.author = author;
        this.time = time;
        this.time = this.time.replace("from now", "ago");
        this.timePosted = timePosted;
        this.uid = uid;
        this.like = like;
        this.comment = comment;
        this.hideButton = false;
        this.nameList = namelist;
    }

    public Status(String status, String author, String time, String timePosted, String uid, int like, int comment, boolean hideButton) {
        this.description = status;
        this.author = author;
        this.time = time;
        this.time = this.time.replace("from now", "ago");
        this.timePosted = timePosted;
        this.uid = uid;
        this.like = like;
        this.comment = comment;
        this.hideButton = hideButton;
    }

    public List getNameList(){ return nameList;}

    public Boolean getHideButton(){ return hideButton;}

    public int getLike(){ return like;}

    public int getComment(){ return comment;}

    public String getUid(){ return uid;}

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
