package com.drapala.quiz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Service
public class QuizService {


    private QuestionsReceiver questionsReceiver;


    private ArrayList<String> questionsList;

    private int index = 0;


    @Autowired
    public QuizService(QuestionsReceiver questionsReceiver) {
        this.questionsReceiver = questionsReceiver;
    }


    public int getIndex() {
        return ++index;
    }

    public boolean saveAllQuestions() {
        if (index==0) {
            questionsList = questionsReceiver.getAllQuestions();
            log.info("Saved question list {}", questionsList);
        return true;
        }
        log.info("Questionlist is already finished");
        return false;
    }

    public ArrayList<String> getQuestionsList() {
        return questionsList;
    }

    public String getNextQuestion(){
        return questionsList.get(index++);
    }

    public int getQuestionsListSize() {
        return this.questionsList.size();
    }
}
