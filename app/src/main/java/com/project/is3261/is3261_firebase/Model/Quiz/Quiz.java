package com.project.is3261.is3261_firebase.Model.Quiz;

/**
 * Created by xunda on 26/10/17.
 */

public class Quiz {
    public String question;
    public String[] options;
    public int answer;

    public Quiz(){}

    public Quiz(String question, String[] options, int answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuizQuestion(){
        return this.question;
    }

    public String[] getQuizOptions(){
        return this.options;
    }

    public int getQuizAnswer(){
        return this.answer;
    }
}
