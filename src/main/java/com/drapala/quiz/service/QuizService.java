package com.drapala.quiz.service;

import com.drapala.quiz.model.AnswerChecker;
import com.drapala.quiz.model.History;
import com.drapala.quiz.repository.QuestionRepository;
import lombok.Getter;
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
public class QuizService {


    private QuestionRepository repository;

    private int index = 0;

    private ArrayList<String> questions;

    private AnswerChecker checker;

    private History history;



    @Autowired
    public QuizService (QuestionRepository repository, AnswerChecker checker) {
        this.repository = repository;
        this.checker = new AnswerChecker();
        this.history = new History();
    }

    @PostConstruct
    public void saveAndShuffleQuestions() {
        questions = repository.getAllQuestions();
        Collections.shuffle(questions);
    }

    public int getAmountOfAllQuestions() {
        return questions.size();
    }


    public int increaseAndGetId() {
        return ++index;
    }

    public String getQuestion(int id) {
        return questions.get(id);
    }


    public ArrayList<String> getAnswers(String question) {
        ArrayList answers = repository.getAnswersOfSingleQuestion(question);
        Collections.shuffle(answers);
        return answers;
    }

    public String getCorrectAnswer(String question) {
        return repository.getCorrectAnswer(question);
    }

    public int getQuestionsListSize() {
        return questions.size();
    }

    public boolean checkAnswer(String clientAnswer, String correctAnswer) {
        return checker.checkAnswer(clientAnswer, correctAnswer);
    }

    public int getAmountOfCorrectAnswers() {
        return checker.getCorrectAnswerAmount();
    }

    public int getAmountOfAllAnswers() {
        return checker.getAnswersAmount();
    }

    public History getHistory() {
        return history;
    }

/*    public ArrayList<String> getClientsAnswersHistory() {
        ArrayList<String> clientsAnswers = new ArrayList<>();
        for (int i=0; i < questions.size(); i++) {

        }
    }*/
}
