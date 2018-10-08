package com.drapala.quiz.model;

import com.drapala.quiz.repository.QuestionRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnswerChecker {



    @Getter
    int answersAmount = 0;

    @Getter
    int correctAnswerAmount = 0;



    public boolean checkAnswer(String clientsAnswer ,String correctAnswer) {
        answersAmount++;
        log.info("Comparision: {} ?= {}", clientsAnswer, correctAnswer);
        if (clientsAnswer.equals(correctAnswer)){
            correctAnswerAmount++;
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        answersAmount = 0;
        correctAnswerAmount = 0;
    }



}
