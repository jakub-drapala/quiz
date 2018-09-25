package com.drapala.quiz.repository;

import com.drapala.quiz.QuizApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maczi on 2018-09-22.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuizApplication.class)
@Slf4j
public class JPQLTests {

    @Autowired
    EntityManager em;

    @Test
    public void getOneQuestion() {
        Query query = em.createQuery("Select q.content From Question q where id=1");
        Object result = query.getSingleResult();
        log.info("content where id=1: {}", result);

    }

    @Test
    public void getAllQuestions() {
        Query query = em.createQuery("Select q.content From Question q");
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        log.info("Contents of all questions: {}", questions);
    }

    @Test
    @Transactional
    public void getQuestions() {
        ArrayList<String> questions = new ArrayList<>();

        Query query = em.createQuery("Select q.answers.answerA From Question q where id= :i")
                                        .setParameter("i", 1);
        Object result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerB From Question q where id= :i")
                                        .setParameter("i", 1);
        result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerC From Question q where id= :i")
                                        .setParameter("i", 1);
        result = query.getSingleResult();
        questions.add((String)result);

        query = em.createQuery("Select q.answers.answerD From Question q where id= :i")
                                        .setParameter("i", 1);
        result = query.getSingleResult();
        questions.add((String)result);



        log.info("Answer of question id=1: {}", questions);
    }


}
