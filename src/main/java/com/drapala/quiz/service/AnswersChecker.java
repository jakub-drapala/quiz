package com.drapala.quiz.service;

import com.drapala.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AnswersChecker {

    @Autowired
    private QuestionRepository repository;

    String answer;

    int answerAmount = 0;

    int correctAnswer = 0;


    HashMap<String, String> answersKey;


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public void saveAnswersKey() {
        answersKey = repository.getCorrect();
    }

    public HashMap<String, String> getAnswersKey() {
        return answersKey;
    }


        public String getAnswerKey(String question) {
        return answersKey.get(question);
    }

    public boolean checkAnswer(String answer, String key) {
        answerAmount++;
        if (answer.equals(key)) {
            correctAnswer++;
            return true;
        } else {
            return false;
        }
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getAllAnswers() {
        return answerAmount;
    }
}
