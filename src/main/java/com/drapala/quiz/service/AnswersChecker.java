package com.drapala.quiz.service;

import com.drapala.quiz.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class AnswersChecker {

    @Autowired
    private QuestionRepository repository;

    String answer;

    int answersAmount = 0;

    int correctAnswerAmount = 0;


    HashMap<String, String> answersKey;



    public void saveAnswersKey() {
        answersKey = repository.getCorrectAnswer();
    }

    public HashMap<String, String> getAnswersKey() {
        return answersKey;
    }


    public String getAnswersKey(String question) {
        log.info("Answers key: {}", answersKey);
        return answersKey.get(question);
    }

    public boolean checkAnswer(String answer, String key) {
        answersAmount++;
        if (answer.equals(key)) {
            correctAnswerAmount++;
            return true;
        } else {
            return false;
        }
    }

    public int getCorrectAnswerAmount() {
        return correctAnswerAmount;
    }

    public int getAllAnswersAmount() {
        return answersAmount;
    }
}
