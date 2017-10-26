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

    public LessonGenerator() {

    }

    public LessonGenerator(int fragNum, String lessonType, int lessonNum) {
        if (lessonType.equals("userInterface")) {
            this.mLesson = generateUserInterfaceLesson(fragNum, lessonNum);
        } else if (lessonType.equals("userInput")) {
            this.mLesson = generateUserInput(fragNum, lessonNum);
        } else if (lessonType.equals("multipleScreen")) {
            this.mLesson = generateMultipleScreen(fragNum, lessonNum);
        } else if (lessonType.equals("dataStorage")) {
            this.mLesson = generateDataStorage(fragNum, lessonNum);
        } else {
            this.mLesson = generateNetworking(fragNum, lessonNum);
        }
    }

    private Lesson generateUserInterfaceLesson(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description = {LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_3};
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        return mLessonList.get(fragNum);
    }

    private Lesson generateUserInput(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description = {LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_3};
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        return mLessonList.get(fragNum);
    }

    private Lesson generateMultipleScreen(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description = {LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_3};
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        return mLessonList.get(fragNum);
    }

    private Lesson generateDataStorage(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description = {LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_3};
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        return mLessonList.get(fragNum);
    }

    private Lesson generateNetworking(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description = {LessonContent.CHAPTER_1_LESSON_1_2, LessonContent.CHAPTER_1_LESSON_1_3};
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        mLessonList.add(new Lesson(LessonContent.CHAPTER_1_LESSON_1_1, description, false, false));
        return mLessonList.get(fragNum);
    }

    public Lesson getLesson() {
        return this.mLesson;
    }

    public ArrayList<Lesson> getLessonList() {
        return this.mLessonList;
    }
}
