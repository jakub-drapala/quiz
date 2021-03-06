package com.drapala.quiz.service;

import com.drapala.quiz.model.History;

import java.util.ArrayList;

public interface Quiz {


    void saveQuestions();

    void setCategory(String category);

    int increaseAndGetId();

    String getQuestion(int id);

    ArrayList<String> getAnswers(String question);

    String getCorrectAnswer(String question);

    int getQuestionsListSize();

    boolean checkAnswer(String clientAnswer, String correctAnswer);

    String showResult();

    void resetAll();

    History getHistory();

    int getQuizDuration();

}
