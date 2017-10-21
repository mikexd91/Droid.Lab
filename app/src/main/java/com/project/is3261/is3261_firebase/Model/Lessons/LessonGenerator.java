package com.project.is3261.is3261_firebase.Model.Lessons;

import java.util.ArrayList;

/**
 * Created by xunda on 20/10/17.
 */

public class LessonGenerator {
    private ArrayList<Lesson> mLessonList;
    private Lesson mLesson;
    private int fragNum;
    private String lessonType;
    private static int USER_INTERFACE_LESSON = 18;
    private static int USER_INPUT_LESSON = 22;
    private static int MULTIPLE_SCREEN_LESSON = 48;

    public LessonGenerator(){

    }

    public LessonGenerator(int fragNum, String lessonType, int lessonNum){
        if (lessonType.equals("userInterface")){
            this.mLesson = generateUserInterfaceLesson(fragNum, lessonNum);
        }else if (lessonType.equals("userInput")) {
            this.mLesson = generateUserInput(fragNum, lessonNum);
        }else if (lessonType.equals("multipleScreen")) {
            this.mLesson = generateMultipleScreen(fragNum, lessonNum);
        }else if (lessonType.equals("dataStorage")) {
            this.mLesson = generateDataStorage(fragNum, lessonNum);
        }else{
            this.mLesson = generateNetworking(fragNum, lessonNum);
        }
    }

    private Lesson generateUserInterfaceLesson(int fragNum, int lessonNum){
        mLessonList = new ArrayList<>();
        switch(lessonNum){
            case 1:
                mLessonList.add(new Lesson("User Interface 1-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Interface 1-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Interface 1-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Interface 1-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Interface 1-5", "this is a description 5"));
            case 2:
                mLessonList.add(new Lesson("User Interface 2-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Interface 2-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Interface 2-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Interface 2-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Interface 2-5", "this is a description 5"));
            case 3:
                mLessonList.add(new Lesson("User Interface 3-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Interface 3-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Interface 3-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Interface 3-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Interface 3-5", "this is a description 5"));
            case 4:
                mLessonList.add(new Lesson("User Interface 4-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Interface 4-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Interface 4-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Interface 4-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Interface 4-5", "this is a description 5"));
            case 5:
                mLessonList.add(new Lesson("User Interface 5-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Interface 5-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Interface 5-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Interface 5-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Interface 5-5", "this is a description 5"));
        }

        return mLessonList.get(fragNum);
    }

    private Lesson generateUserInput(int fragNum, int lessonNum){
        mLessonList = new ArrayList<>();
        switch(lessonNum){
            case 1:
                mLessonList.add(new Lesson("User Input 1-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Input 1-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Input 1-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Input 1-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Input 1-5", "this is a description 5"));
            case 2:
                mLessonList.add(new Lesson("User Input 2-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Input 2-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Input 2-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Input 2-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Input 2-5", "this is a description 5"));
            case 3:
                mLessonList.add(new Lesson("User Input 3-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Input 3-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Input 3-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Input 3-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Input 3-5", "this is a description 5"));
            case 4:
                mLessonList.add(new Lesson("User Input 4-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Input 4-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Input 4-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Input 4-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Input 4-5", "this is a description 5"));
            case 5:
                mLessonList.add(new Lesson("User Input 5-1", "this is a description 1"));
                mLessonList.add(new Lesson("User Input 5-2", "this is a description 2"));
                mLessonList.add(new Lesson("User Input 5-3", "this is a description 3"));
                mLessonList.add(new Lesson("User Input 5-4", "this is a description 4"));
                mLessonList.add(new Lesson("User Input 5-5", "this is a description 5"));
        }
        return mLessonList.get(fragNum);
    }

    private Lesson generateMultipleScreen(int fragNum, int lessonNum){
        mLessonList = new ArrayList<>();
        switch(lessonNum){
            case 1:
                mLessonList.add(new Lesson("Multiple Screen 1-1", "this is a description 1"));
                mLessonList.add(new Lesson("Multiple Screen 1-2", "this is a description 2"));
                mLessonList.add(new Lesson("Multiple Screen 1-3", "this is a description 3"));
                mLessonList.add(new Lesson("Multiple Screen 1-4", "this is a description 4"));
                mLessonList.add(new Lesson("Multiple Screen 1-5", "this is a description 5"));
            case 2:
                mLessonList.add(new Lesson("Multiple Screen 2-1", "this is a description 1"));
                mLessonList.add(new Lesson("Multiple Screen 2-2", "this is a description 2"));
                mLessonList.add(new Lesson("Multiple Screen 2-3", "this is a description 3"));
                mLessonList.add(new Lesson("Multiple Screen 2-4", "this is a description 4"));
                mLessonList.add(new Lesson("Multiple Screen 2-5", "this is a description 5"));
            case 3:
                mLessonList.add(new Lesson("Multiple Screen 3-1", "this is a description 1"));
                mLessonList.add(new Lesson("Multiple Screen 3-2", "this is a description 2"));
                mLessonList.add(new Lesson("Multiple Screen 3-3", "this is a description 3"));
                mLessonList.add(new Lesson("Multiple Screen 3-4", "this is a description 4"));
                mLessonList.add(new Lesson("Multiple Screen 3-5", "this is a description 5"));
            case 4:
                mLessonList.add(new Lesson("Multiple Screen 4-1", "this is a description 1"));
                mLessonList.add(new Lesson("Multiple Screen 4-2", "this is a description 2"));
                mLessonList.add(new Lesson("Multiple Screen 4-3", "this is a description 3"));
                mLessonList.add(new Lesson("Multiple Screen 4-4", "this is a description 4"));
                mLessonList.add(new Lesson("Multiple Screen 4-5", "this is a description 5"));
            case 5:
                mLessonList.add(new Lesson("Multiple Screen 5-1", "this is a description 1"));
                mLessonList.add(new Lesson("Multiple Screen 5-2", "this is a description 2"));
                mLessonList.add(new Lesson("Multiple Screen 5-3", "this is a description 3"));
                mLessonList.add(new Lesson("Multiple Screen 5-4", "this is a description 4"));
                mLessonList.add(new Lesson("Multiple Screen 5-5", "this is a description 5"));
        }
        return mLessonList.get(fragNum);
    }

    private Lesson generateDataStorage(int fragNum, int lessonNum){
        mLessonList = new ArrayList<>();
        switch(lessonNum){
            case 1:
                mLessonList.add(new Lesson("Data Storage 1-1", "this is a description 1"));
                mLessonList.add(new Lesson("Data Storage 1-2", "this is a description 2"));
                mLessonList.add(new Lesson("Data Storage 1-3", "this is a description 3"));
                mLessonList.add(new Lesson("Data Storage 1-4", "this is a description 4"));
                mLessonList.add(new Lesson("Data Storage 1-5", "this is a description 5"));
            case 2:
                mLessonList.add(new Lesson("Data Storage 2-1", "this is a description 1"));
                mLessonList.add(new Lesson("Data Storage 2-2", "this is a description 2"));
                mLessonList.add(new Lesson("Data Storage 2-3", "this is a description 3"));
                mLessonList.add(new Lesson("Data Storage 2-4", "this is a description 4"));
                mLessonList.add(new Lesson("Data Storage 2-5", "this is a description 5"));
            case 3:
                mLessonList.add(new Lesson("Data Storage 3-1", "this is a description 1"));
                mLessonList.add(new Lesson("Data Storage 3-2", "this is a description 2"));
                mLessonList.add(new Lesson("Data Storage 3-3", "this is a description 3"));
                mLessonList.add(new Lesson("Data Storage 3-4", "this is a description 4"));
                mLessonList.add(new Lesson("Data Storage 3-5", "this is a description 5"));
            case 4:
                mLessonList.add(new Lesson("Data Storage 4-1", "this is a description 1"));
                mLessonList.add(new Lesson("Data Storage 4-2", "this is a description 2"));
                mLessonList.add(new Lesson("Data Storage 4-3", "this is a description 3"));
                mLessonList.add(new Lesson("Data Storage 4-4", "this is a description 4"));
                mLessonList.add(new Lesson("Data Storage 4-5", "this is a description 5"));
            case 5:
                mLessonList.add(new Lesson("Data Storage 5-1", "this is a description 1"));
                mLessonList.add(new Lesson("Data Storage 5-2", "this is a description 2"));
                mLessonList.add(new Lesson("Data Storage 5-3", "this is a description 3"));
                mLessonList.add(new Lesson("Data Storage 5-4", "this is a description 4"));
                mLessonList.add(new Lesson("Data Storage 5-5", "this is a description 5"));
        }
        return mLessonList.get(fragNum);
    }

    private Lesson generateNetworking(int fragNum, int lessonNum){
        mLessonList = new ArrayList<>();
        switch(lessonNum){
            case 1:
                mLessonList.add(new Lesson("Networking 1-1", "this is a description 1"));
                mLessonList.add(new Lesson("Networking 1-2", "this is a description 2"));
                mLessonList.add(new Lesson("Networking 1-3", "this is a description 3"));
                mLessonList.add(new Lesson("Networking 1-4", "this is a description 4"));
                mLessonList.add(new Lesson("Networking 1-5", "this is a description 5"));
            case 2:
                mLessonList.add(new Lesson("Networking 2-1", "this is a description 1"));
                mLessonList.add(new Lesson("Networking 2-2", "this is a description 2"));
                mLessonList.add(new Lesson("Networking 2-3", "this is a description 3"));
                mLessonList.add(new Lesson("Networking 2-4", "this is a description 4"));
                mLessonList.add(new Lesson("Networking 2-5", "this is a description 5"));
            case 3:
                mLessonList.add(new Lesson("Networking 3-1", "this is a description 1"));
                mLessonList.add(new Lesson("Networking 3-2", "this is a description 2"));
                mLessonList.add(new Lesson("Networking 3-3", "this is a description 3"));
                mLessonList.add(new Lesson("Networking 3-4", "this is a description 4"));
                mLessonList.add(new Lesson("Networking 3-5", "this is a description 5"));
            case 4:
                mLessonList.add(new Lesson("Networking 4-1", "this is a description 1"));
                mLessonList.add(new Lesson("Networking 4-2", "this is a description 2"));
                mLessonList.add(new Lesson("Networking 4-3", "this is a description 3"));
                mLessonList.add(new Lesson("Networking 4-4", "this is a description 4"));
                mLessonList.add(new Lesson("Networking 4-5", "this is a description 5"));
            case 5:
                mLessonList.add(new Lesson("Networking 5-1", "this is a description 1"));
                mLessonList.add(new Lesson("Networking 5-2", "this is a description 2"));
                mLessonList.add(new Lesson("Networking 5-3", "this is a description 3"));
                mLessonList.add(new Lesson("Networking 5-4", "this is a description 4"));
                mLessonList.add(new Lesson("Networking 5-5", "this is a description 5"));
        }
        return mLessonList.get(fragNum);
    }

    public Lesson getLesson(){
        return this.mLesson;
    }
    public ArrayList<Lesson> getLessonList(){ return this.mLessonList;}
}
