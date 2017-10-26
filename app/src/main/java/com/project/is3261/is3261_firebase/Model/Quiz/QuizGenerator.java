package com.project.is3261.is3261_firebase.Model.Quiz;


import java.util.ArrayList;

/**
 * Created by xunda on 26/10/17.
 */

public class QuizGenerator {
    private ArrayList<Quiz> mQuizList;
    private Quiz mQuiz;
    private int fragNum;

    public QuizGenerator() {

    }

    public QuizGenerator(int fragNum, String quizType, int quizNum) {
        if (quizType.equals("userInterface")) {
            this.mQuiz = generateUserInterface(fragNum, quizNum);
        } else if (quizType.equals("userInput")) {
            this.mQuiz = generateUserInput(fragNum, quizNum);
        } else if (quizType.equals("multipleScreen")) {
            this.mQuiz = generateMultipleScreen(fragNum, quizNum);
        } else if (quizType.equals("dataStorage")) {
            this.mQuiz = generateDataStorage(fragNum, quizNum);
        } else {
            this.mQuiz = generateNetworking(fragNum, quizNum);
        }
    }

    private Quiz generateUserInterface(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();
        String[] options1 = {QuizContent.QUIZ_1_OPTION_1,
        QuizContent.QUIZ_1_OPTION_2, QuizContent.QUIZ_1_OPTION_3, QuizContent.QUIZ_1_OPTION_4};

        String[] options2 = {QuizContent.QUIZ_2_OPTION_1,
                QuizContent.QUIZ_2_OPTION_2, QuizContent.QUIZ_2_OPTION_3, QuizContent.QUIZ_2_OPTION_4};
        mQuizList.add(new Quiz(QuizContent.QUIZ_1, options1, 1));
        mQuizList.add(new Quiz(QuizContent.QUIZ_2, options2, 2));
        return mQuizList.get(fragNum);
    }

    private Quiz generateUserInput(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();
        String[] description = {QuizContent.QUIZ_1};
        mQuizList.add(new Quiz(QuizContent.QUIZ_1, description,1));

        return mQuizList.get(fragNum);
    }

    private Quiz generateMultipleScreen(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();
        String[] description = {QuizContent.QUIZ_1};
        mQuizList.add(new Quiz(QuizContent.QUIZ_1, description,1));

        return mQuizList.get(fragNum);
    }

    private Quiz generateDataStorage(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();
        String[] description = {QuizContent.QUIZ_1};
        mQuizList.add(new Quiz(QuizContent.QUIZ_1, description, 1));

        return mQuizList.get(fragNum);
    }

    private Quiz generateNetworking(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();
        String[] description = {QuizContent.QUIZ_1};
        mQuizList.add(new Quiz(QuizContent.QUIZ_1, description, 1));

        return mQuizList.get(fragNum);
    }

    public Quiz getQuiz() {
        return this.mQuiz;
    }

    public ArrayList<Quiz> getQuizList() {
        return this.mQuizList;
    }
}
