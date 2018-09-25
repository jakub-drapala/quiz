package com.drapala.quiz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

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
            Collections.shuffle(questionsList);
        return questionsList;
    }


    public int getQuestionsListSize() {
        return this.questionsList.size();
    }

    public ArrayList<String> getAnswersOfQuestion(int index) {
        return this.questionsReceiver.getRepository().getAnswersOfQuestion(index+1);
    }

    public ArrayList<String> getAnswersOfParticularQuestion(String question) {
        return this.questionsReceiver.getAnswer().get(question);
    }



}
