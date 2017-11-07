package com.project.is3261.is3261_firebase.Model.Quiz;


import java.util.ArrayList;

/**
 * Created by xunda on 26/10/17.
 */

public class QuizGenerator {
    private ArrayList<Quiz> mQuizList;
    private Quiz mQuiz;

    public QuizGenerator() {

    }

    public QuizGenerator(int fragNum, String quizType, int quizNum) {
        if (quizType.equals("userInterface")) {
            this.mQuiz = generateUserInterface(fragNum, quizNum);
        } else if (quizType.equals("userInput")) {
            this.mQuiz = generateUserInput(fragNum, quizNum);
        } else if (quizType.equals("multipleScreen")) {
            this.mQuiz = generateMultiscreen(fragNum, quizNum);
        } else if (quizType.equals("extraQuestions")) {
            this.mQuiz = generateExtra(fragNum, quizNum);
        }
    }

    private Quiz generateUserInterface(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();

        String[] options1 = {QuizContentChap1.QUESTION_1_OPTION_1, QuizContentChap1.QUESTION_1_OPTION_2, QuizContentChap1.QUESTION_1_OPTION_3, QuizContentChap1.QUESTION_1_OPTION_4};
        String[] options2 = {QuizContentChap1.QUESTION_2_OPTION_1, QuizContentChap1.QUESTION_2_OPTION_2, QuizContentChap1.QUESTION_2_OPTION_3, QuizContentChap1.QUESTION_2_OPTION_4};
        String[] options3 = {QuizContentChap1.QUESTION_3_OPTION_1, QuizContentChap1.QUESTION_3_OPTION_2, QuizContentChap1.QUESTION_3_OPTION_3, QuizContentChap1.QUESTION_3_OPTION_4};
        String[] options4 = {QuizContentChap1.QUESTION_4_OPTION_1, QuizContentChap1.QUESTION_4_OPTION_2, QuizContentChap1.QUESTION_4_OPTION_3, QuizContentChap1.QUESTION_4_OPTION_4};
        String[] options5 = {QuizContentChap1.QUESTION_5_OPTION_1, QuizContentChap1.QUESTION_5_OPTION_2, QuizContentChap1.QUESTION_5_OPTION_3, QuizContentChap1.QUESTION_5_OPTION_4};
        String[] options6 = {QuizContentChap1.QUESTION_6_OPTION_1, QuizContentChap1.QUESTION_6_OPTION_2, QuizContentChap1.QUESTION_6_OPTION_3, QuizContentChap1.QUESTION_6_OPTION_4};

        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_1, options1, 1));
        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_2, options2, 1));
        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_3, options3, 2));
        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_4, options4, 3));
        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_5, options5, 4));
        mQuizList.add(new Quiz(QuizContentChap1.QUESTION_6, options6, 2));

        return mQuizList.get(fragNum);
    }

    private Quiz generateUserInput(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();

        String[] options1 = {QuizContentChap2.QUESTION_1_OPTION_1, QuizContentChap2.QUESTION_1_OPTION_2, QuizContentChap2.QUESTION_1_OPTION_3, QuizContentChap2.QUESTION_1_OPTION_4};
        String[] options2 = {QuizContentChap2.QUESTION_2_OPTION_1, QuizContentChap2.QUESTION_2_OPTION_2, QuizContentChap2.QUESTION_2_OPTION_3, QuizContentChap2.QUESTION_2_OPTION_4};
        String[] options3 = {QuizContentChap2.QUESTION_3_OPTION_1, QuizContentChap2.QUESTION_3_OPTION_2, QuizContentChap2.QUESTION_3_OPTION_3, QuizContentChap2.QUESTION_3_OPTION_4};
        String[] options4 = {QuizContentChap2.QUESTION_4_OPTION_1, QuizContentChap2.QUESTION_4_OPTION_2, QuizContentChap2.QUESTION_4_OPTION_3, QuizContentChap2.QUESTION_4_OPTION_4};
        String[] options5 = {QuizContentChap2.QUESTION_5_OPTION_1, QuizContentChap2.QUESTION_5_OPTION_2, QuizContentChap2.QUESTION_5_OPTION_3, QuizContentChap2.QUESTION_5_OPTION_4};
        String[] options6 = {QuizContentChap2.QUESTION_6_OPTION_1, QuizContentChap2.QUESTION_6_OPTION_2, QuizContentChap2.QUESTION_6_OPTION_3, QuizContentChap2.QUESTION_6_OPTION_4};

        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_1, options1, 2));
        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_2, options2, 3));
        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_3, options3, 3));
        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_4, options4, 1));
        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_5, options5, 4));
        mQuizList.add(new Quiz(QuizContentChap2.QUESTION_6, options6, 4));

        return mQuizList.get(fragNum);
    }

    private Quiz generateMultiscreen(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();

        String[] options1 = {QuizContentChap3.QUESTION_1_OPTION_1, QuizContentChap3.QUESTION_1_OPTION_2, QuizContentChap3.QUESTION_1_OPTION_3, QuizContentChap3.QUESTION_1_OPTION_4};
        String[] options2 = {QuizContentChap3.QUESTION_2_OPTION_1, QuizContentChap3.QUESTION_2_OPTION_2, QuizContentChap3.QUESTION_2_OPTION_3, QuizContentChap3.QUESTION_2_OPTION_4};
        String[] options3 = {QuizContentChap3.QUESTION_3_OPTION_1, QuizContentChap3.QUESTION_3_OPTION_2, QuizContentChap3.QUESTION_3_OPTION_3, QuizContentChap3.QUESTION_3_OPTION_4};
        String[] options4 = {QuizContentChap3.QUESTION_4_OPTION_1, QuizContentChap3.QUESTION_4_OPTION_2, QuizContentChap3.QUESTION_4_OPTION_3, QuizContentChap3.QUESTION_4_OPTION_4};
        String[] options5 = {QuizContentChap3.QUESTION_5_OPTION_1, QuizContentChap3.QUESTION_5_OPTION_2, QuizContentChap3.QUESTION_5_OPTION_3, QuizContentChap3.QUESTION_5_OPTION_4};
        String[] options6 = {QuizContentChap3.QUESTION_6_OPTION_1, QuizContentChap3.QUESTION_6_OPTION_2, QuizContentChap3.QUESTION_6_OPTION_3, QuizContentChap3.QUESTION_6_OPTION_4};

        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_1, options1, 4));
        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_2, options2, 2));
        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_3, options3, 1));
        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_4, options4, 4));
        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_5, options5, 2));
        mQuizList.add(new Quiz(QuizContentChap3.QUESTION_6, options6, 4));

        return mQuizList.get(fragNum);
    }

    private Quiz generateExtra(int fragNum, int quizNum) {
        mQuizList = new ArrayList<>();

        String[] options1 = {QuizContentExtra.QUESTION_1_OPTION_1, QuizContentExtra.QUESTION_1_OPTION_2, QuizContentExtra.QUESTION_1_OPTION_3, QuizContentExtra.QUESTION_1_OPTION_4};
        String[] options2 = {QuizContentExtra.QUESTION_2_OPTION_1, QuizContentExtra.QUESTION_2_OPTION_2, QuizContentExtra.QUESTION_2_OPTION_3, QuizContentExtra.QUESTION_2_OPTION_4};
        String[] options3 = {QuizContentExtra.QUESTION_3_OPTION_1, QuizContentExtra.QUESTION_3_OPTION_2, QuizContentExtra.QUESTION_3_OPTION_3, QuizContentExtra.QUESTION_3_OPTION_4};
        String[] options4 = {QuizContentExtra.QUESTION_4_OPTION_1, QuizContentExtra.QUESTION_4_OPTION_2, QuizContentExtra.QUESTION_4_OPTION_3, QuizContentExtra.QUESTION_4_OPTION_4};
        String[] options5 = {QuizContentExtra.QUESTION_5_OPTION_1, QuizContentExtra.QUESTION_5_OPTION_2, QuizContentExtra.QUESTION_5_OPTION_3, QuizContentExtra.QUESTION_5_OPTION_4};
        String[] options6 = {QuizContentExtra.QUESTION_6_OPTION_1, QuizContentExtra.QUESTION_6_OPTION_2, QuizContentExtra.QUESTION_6_OPTION_3, QuizContentExtra.QUESTION_6_OPTION_4};

        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_1, options1, 4));
        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_2, options2, 2));
        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_3, options3, 3));
        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_4, options4, 2));
        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_5, options5, 2));
        mQuizList.add(new Quiz(QuizContentExtra.QUESTION_6, options6, 4));

        return mQuizList.get(fragNum);
    }

    public Quiz getQuiz() {
        return this.mQuiz;
    }

    public ArrayList<Quiz> getQuizList() {
        return this.mQuizList;
    }
}
