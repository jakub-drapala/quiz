package com.drapala.quiz.service;

import com.drapala.quiz.model.AnswerChecker;
import com.drapala.quiz.model.History;
import com.drapala.quiz.repository.QuestionRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Service
public class QuizService implements Quiz{


    private QuestionRepository repository;

    private int index = 0;

    private ArrayList<String> questions;

    private AnswerChecker checker;

    @Getter
    private History history;

    private String category;


    @Autowired
    public QuizService (QuestionRepository repository) {
        this.repository = repository;
        this.checker = new AnswerChecker();
        this.history = new History();
    }

    public void saveAndShuffleQuestions() {
        log.info("Questions has been saved");
        this.questions = this.repository.getAllQuestions(category);
        Collections.shuffle(this.questions);
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
        ArrayList answers = this.repository.getAnswersOfSingleQuestion(question);
        Collections.shuffle(answers);
        return answers;
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



    public void resetAll() {
        this.index = 0;
        this.history.reset();
        this.checker.reset();
    }




}
