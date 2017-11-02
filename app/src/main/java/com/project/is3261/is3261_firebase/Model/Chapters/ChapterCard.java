package com.project.is3261.is3261_firebase.Model.Chapters;

/**
 * Created by Bowen on 19/10/2017.
 */

public class ChapterCard {

    private String title;
    private String description;
    private Boolean isCompleted;

    public ChapterCard() {
    }

    public ChapterCard(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public Boolean getIsCompleted() { return isCompleted;}

    public void setIsCompleted(Boolean isCompleted) { this.isCompleted = isCompleted;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
