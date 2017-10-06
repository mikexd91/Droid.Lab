package com.project.is3261.is3261_firebase.Model;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by xunda on 6/10/17.
 */

public class Data {
    public String author;
    public String title;
    public String description;
    public String url;
    public ImageView urlImageView;
    public String urlToImage;
    public String publishedAt;
    public int imageId;

    public Data(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public Data(Context context, String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
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
