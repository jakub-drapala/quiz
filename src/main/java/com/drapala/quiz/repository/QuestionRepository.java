package com.drapala.quiz.repository;

import com.drapala.quiz.entity.Answers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Repository
@Transactional
public class QuestionRepository {

    @Autowired
    EntityManager em;

    public ArrayList<String> getAllQuestions(String category) /*necessary*/{
        Query query = em.createQuery("Select q.content From Question q where q.category = :cat")
                .setParameter("cat", category);
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        log.info("Contents of all questions: {}", questions);
        return questions;
    }

    public ArrayList<String> getAnswersOfSingleQuestion(String content) {

        Query query = em.createQuery("Select q.answers from Question q where q.content= :content")
                .setParameter("content", content);
        Answers answers =  (Answers) query.getSingleResult();
        log.info("Answers of question= {}", answers.getAllAnswers());

        return answers.getAllAnswers();
    }

    public String getCorrectAnswer(String content) {

        Query query = em.createQuery("Select q.answers.correct from Question q where q.content= :content")
                .setParameter("content", content);

        String correctAnswer = (String) query.getSingleResult();

        return correctAnswer;
    }



}
