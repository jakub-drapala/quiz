package com.drapala.quiz.service;

import com.drapala.quiz.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Configuration
@Component
public class QuestionsReceiver {

    private ArrayList<String> questions;

    @Autowired
    private QuestionRepository repository;

    public QuestionsReceiver() {
        log.info("QuestionsReceiver Constructor is running");
    }


    public ArrayList<String> getAllQuestions() {
        ArrayList<String> allQuestions = repository.getAllQuestions();
        return allQuestions;
    }


    public QuestionRepository getRepository() {
        return repository;
    }









}
