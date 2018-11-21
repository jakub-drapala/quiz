package com.drapala.quiz.service;

import com.drapala.quiz.model.AnswerChecker;
import com.drapala.quiz.model.History;
import com.drapala.quiz.model.Timer;
import com.drapala.quiz.repository.QuestionRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Service
public class QuizService implements Quiz{


    private QuestionRepository repository;

    private int index = 0;

    private List<String> questions;

    private AnswerChecker checker;

    private Timer timer;

    @Getter
    private History history;

    private String category;


    @Autowired
    public QuizService (QuestionRepository repository) {
        this.repository = repository;
        this.checker = new AnswerChecker();
        this.history = new History();
        this.timer = new Timer();
    }

    public void saveQuestions() {
        this.questions = this.repository.AllQuestionsInRandomOrder(category);
        this.timer.startTimer();
        log.info("Questions has been saved and timer is started.");
    }

    public void setCategory(String category) {
        log.info("Category: {}", category);
        this.category = category;
    }

    public int getAmountOfAllQuestions() {
        return this.questions.size();
    }


    public int increaseAndGetId() {
        return ++this.index;
    }

    public String getQuestion(int id) {
        return this.questions.get(id);
    }


    public ArrayList<String> getAnswers(String question) {
        List <String> answers = this.repository.getAnswersOfSingleQuestion(question);
        ArrayList<String> answersInArrayList = new ArrayList<>(answers);

        return answersInArrayList;
    }

    public String getCorrectAnswer(String question) {
        return this.repository.getCorrectAnswer(question);
    }

    public int getQuestionsListSize() {
        return this.questions.size();
    }

    public boolean checkAnswer(String clientAnswer, String correctAnswer) {
        return this.checker.checkAnswer(clientAnswer, correctAnswer);
    }

    public int getAmountOfCorrectAnswers() {
        return this.checker.getCorrectAnswerAmount();
    }

    public int getAmountOfAllAnswers() {
        return this.checker.getAnswersAmount();
    }

    @Override
    public int getQuizDuration() {
        return Integer.parseInt(timer.toString());
    }

    public void resetAll() {
        this.index = 0;
        this.history.reset();
        this.checker.reset();
    }




}
