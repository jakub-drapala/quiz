package com.drapala.quiz.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Repository
@Transactional
public class QuestionRepository {

    @Autowired
    EntityManager em;

    public ArrayList<String> getAllQuestions() {
        Query query = em.createQuery("Select q.content From Question q");
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        log.info("Contents of all questions: {}", questions);
        return questions;
    }

    public ArrayList<String> getAnswersOfQuestion(int i) {
        ArrayList<String> questions = new ArrayList<>();


        Query query = em.createQuery("Select q.answers.answerA From Question q where id= :i")
                .setParameter("i", i);
        Object result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerB From Question q where id= :i")
                .setParameter("i", i);
        result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerC From Question q where id= :i")
                .setParameter("i", i);
        result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerD From Question q where id= :i")
                .setParameter("i", i);
        result = query.getSingleResult();
        questions.add((String)result);


        log.info("Answer of question id=1: {}", questions);

        return questions;
    }





}
