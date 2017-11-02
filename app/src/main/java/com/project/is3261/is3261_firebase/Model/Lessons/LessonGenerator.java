package com.project.is3261.is3261_firebase.Model.Lessons;

import java.util.ArrayList;

/**
 * Created by xunda on 20/10/17.
 */

public class LessonGenerator {
    private ArrayList<Lesson> mLessonList;
    private Lesson mLesson;

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

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_1_TITLE, LessonContentChapt1.LESSON_1_IMAGE, false, true));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_2_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_2_TITLE, LessonContentChapt1.LESSON_2_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_3_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_3_TITLE, LessonContentChapt1.LESSON_3_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_4_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_4_TITLE, LessonContentChapt1.LESSON_4_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_5_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_5_TITLE, LessonContentChapt1.LESSON_5_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_6_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_6_TITLE, LessonContentChapt1.LESSON_6_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_7_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_7_TITLE, LessonContentChapt1.LESSON_7_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_8_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_8_TITLE, LessonContentChapt1.LESSON_8_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_9_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_9_TITLE, LessonContentChapt1.LESSON_9_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_10_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_10_TITLE, LessonContentChapt1.LESSON_10_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_11_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_11_TITLE, LessonContentChapt1.LESSON_11_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_12_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_12_TITLE, LessonContentChapt1.LESSON_12_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_13_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_13_TITLE, LessonContentChapt1.LESSON_13_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_14_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_14_TITLE, LessonContentChapt1.LESSON_14_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_15_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_15_TITLE, LessonContentChapt1.LESSON_15_YOUTUBE, true,false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_16_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_16_TITLE, LessonContentChapt1.LESSON_16_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_17_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_17_TITLE, LessonContentChapt1.LESSON_17_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_18_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt1.LESSON_18_TITLE, LessonContentChapt1.LESSON_18_YOUTUBE, true, false));
                mLessonList.add(new Lesson("Conclusion", false, false));

        return mLessonList.get(fragNum);
    }

    private Lesson generateUserInput(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
//        String[] description ={};
//        String[] description1 = {LessonContentChapt2.LESSON_1_DES1, LessonContentChapt2.LESSON_1_DES2};
//        String[] description4 = {LessonContentChapt2.LESSON_4_DES1};
//        String[] description5 = {LessonContentChapt2.LESSON_5_DES1};
//        String[] description6 = {LessonContentChapt2.LESSON_6_DES1};
//        String[] description7 = {LessonContentChapt2.LESSON_7_DES1};
//        String[] description9 = {LessonContentChapt2.LESSON_9_DES1};
//        String[] description11 = {LessonContentChapt2.LESSON_11_DES1};
//        String[] description19 = {LessonContentChapt2.LESSON_19_DES1};
//        String[] description21 = {LessonContentChapt2.LESSON_21_DES1};
//
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_1_TITLE, description1, LessonContentChapt2.LESSON_1_IMAGE, false, true));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_2_TITLE, description, LessonContentChapt2.LESSON_2_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_3_TITLE, description, LessonContentChapt2.LESSON_3_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_4_TITLE, description4, LessonContentChapt2.LESSON_4_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_5_TITLE, description5, LessonContentChapt2.LESSON_5_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_6_TITLE, description6, LessonContentChapt2.LESSON_6_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_7_TITLE, description7, LessonContentChapt2.LESSON_7_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_8_TITLE, description, LessonContentChapt2.LESSON_8_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_9_TITLE, description9, LessonContentChapt2.LESSON_9_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_10_TITLE, description, LessonContentChapt2.LESSON_10_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_11_TITLE, description11, LessonContentChapt2.LESSON_11_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_12_TITLE, description, LessonContentChapt2.LESSON_12_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_13_TITLE, description, LessonContentChapt2.LESSON_13_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_14_TITLE, description, LessonContentChapt2.LESSON_14_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_15_TITLE, description, LessonContentChapt2.LESSON_15_YOUTUBE, true,false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_16_TITLE, description, LessonContentChapt2.LESSON_16_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_17_TITLE, description, LessonContentChapt2.LESSON_17_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_18_TITLE, description, LessonContentChapt2.LESSON_18_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_19_TITLE, description19, LessonContentChapt2.LESSON_13_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_20_TITLE, description, LessonContentChapt2.LESSON_14_YOUTUBE, true, false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_21_TITLE, description21, LessonContentChapt2.LESSON_15_YOUTUBE, true,false));
//        mLessonList.add(new Lesson(LessonContentChapt2.LESSON_22_TITLE, description, LessonContentChapt2.LESSON_16_YOUTUBE, true, false));


                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_1_TITLE, LessonContentChapt2.LESSON_1_IMAGE, false, true));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_2_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_2_TITLE, LessonContentChapt2.LESSON_2_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_3_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_3_TITLE, LessonContentChapt2.LESSON_3_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_4_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_4_TITLE, LessonContentChapt2.LESSON_4_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_5_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_5_TITLE, LessonContentChapt2.LESSON_5_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_6_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_6_TITLE, LessonContentChapt2.LESSON_6_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_7_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_7_TITLE, LessonContentChapt2.LESSON_7_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_8_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_8_TITLE, LessonContentChapt2.LESSON_8_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_9_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_9_TITLE, LessonContentChapt2.LESSON_9_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_10_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_10_TITLE, LessonContentChapt2.LESSON_10_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_11_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_11_TITLE, LessonContentChapt2.LESSON_11_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_12_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_12_TITLE, LessonContentChapt2.LESSON_12_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_13_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_13_TITLE, LessonContentChapt2.LESSON_13_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_14_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_14_TITLE, LessonContentChapt2.LESSON_14_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_15_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_15_TITLE, LessonContentChapt2.LESSON_15_YOUTUBE, true,false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_16_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_16_TITLE, LessonContentChapt2.LESSON_16_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_17_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_17_TITLE, LessonContentChapt2.LESSON_17_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_18_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_18_TITLE, LessonContentChapt2.LESSON_18_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_19_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_19_TITLE, LessonContentChapt2.LESSON_19_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_20_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_20_TITLE, LessonContentChapt2.LESSON_20_YOUTUBE, true,false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_21_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_21_TITLE, LessonContentChapt2.LESSON_21_YOUTUBE, true, false));

                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_22_TITLE, false, false));
                mLessonList.add(new Lesson(LessonContentChapt2.LESSON_22_TITLE, LessonContentChapt2.LESSON_22_YOUTUBE, true, false));
                mLessonList.add(new Lesson("Conclusion", false, false));
        
        return mLessonList.get(fragNum);
    }

    private Lesson generateMultipleScreen(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();
        String[] description ={};
        String[] description3 = {LessonContentChapt3.LESSON_3_DES1};
        String[] description8 = {LessonContentChapt3.LESSON_8_DES1};
        String[] description12 = {LessonContentChapt3.LESSON_12_DES1};
        String[] description13 = {LessonContentChapt3.LESSON_13_DES1};
        String[] description14 = {LessonContentChapt3.LESSON_14_DES1};
        String[] description15 = {LessonContentChapt3.LESSON_15_DES1};
        String[] description29 = {LessonContentChapt3.LESSON_29_DES1};

        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_1_TITLE, description, LessonContentChapt3.LESSON_1_YOUTUBE, true, true));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_2_TITLE, description, LessonContentChapt3.LESSON_2_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_3_TITLE, description3, false, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_4_TITLE, description, LessonContentChapt3.LESSON_4_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_5_TITLE, description, LessonContentChapt3.LESSON_5_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_6_TITLE, description, LessonContentChapt3.LESSON_6_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_7_TITLE, description, LessonContentChapt3.LESSON_7_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_8_TITLE, description8, LessonContentChapt3.LESSON_8_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_9_TITLE, description, LessonContentChapt3.LESSON_9_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_10_TITLE, description, LessonContentChapt3.LESSON_10_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_11_TITLE, description, LessonContentChapt3.LESSON_11_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_12_TITLE, description12, LessonContentChapt3.LESSON_12_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_13_TITLE, description13, LessonContentChapt3.LESSON_13_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_14_TITLE, description14, LessonContentChapt3.LESSON_14_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_15_TITLE, description15, LessonContentChapt3.LESSON_15_YOUTUBE, true,false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_16_TITLE, description, LessonContentChapt3.LESSON_16_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_17_TITLE, description, LessonContentChapt3.LESSON_17_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_18_TITLE, description, LessonContentChapt3.LESSON_18_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_19_TITLE, description, LessonContentChapt3.LESSON_19_YOUTUBE, true, true));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_20_TITLE, description, LessonContentChapt3.LESSON_20_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_21_TITLE, description, LessonContentChapt3.LESSON_21_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_22_TITLE, description, LessonContentChapt3.LESSON_22_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_23_TITLE, description, LessonContentChapt3.LESSON_23_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_24_TITLE, description, LessonContentChapt3.LESSON_24_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_25_TITLE, description, LessonContentChapt3.LESSON_25_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_26_TITLE, description, LessonContentChapt3.LESSON_26_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_27_TITLE, description, LessonContentChapt3.LESSON_27_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_28_TITLE, description, LessonContentChapt3.LESSON_28_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_29_TITLE, description29, LessonContentChapt3.LESSON_29_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_30_TITLE, description, LessonContentChapt3.LESSON_30_YOUTUBE, true, true));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_31_TITLE, description, LessonContentChapt3.LESSON_31_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_32_TITLE, description3, LessonContentChapt3.LESSON_32_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_33_TITLE, description, LessonContentChapt3.LESSON_33_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_34_TITLE, description, LessonContentChapt3.LESSON_34_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_35_TITLE, description, LessonContentChapt3.LESSON_35_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_36_TITLE, description, LessonContentChapt3.LESSON_36_YOUTUBE, true, false));
        mLessonList.add(new Lesson(LessonContentChapt3.LESSON_37_TITLE, description8, LessonContentChapt3.LESSON_37_YOUTUBE, true, false));

        return mLessonList.get(fragNum);
    }

    private Lesson generateDataStorage(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();

        return mLessonList.get(fragNum);
    }

    private Lesson generateNetworking(int fragNum, int lessonNum) {
        mLessonList = new ArrayList<>();

        return mLessonList.get(fragNum);
    }

    public Lesson getLesson() {
        return this.mLesson;
    }

    public ArrayList<Lesson> getLessonList() {
        return this.mLessonList;
    }
}
