package com.drapala.quiz.repository;

import com.drapala.quiz.entity.Answers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Repository
public class QuestionRepository {

    @Autowired
    EntityManager em;

    public List<String> AllQuestionsInRandomOrder(String category) {
        Query query = em.createQuery("Select q.content From Question q where q.category = :cat")
                .setParameter("cat", category);
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        Collections.shuffle(questions);
        log.info("Contents of all questions: {}", questions);
        return Collections.unmodifiableList(questions);
    }

    public List<String> getAnswersOfSingleQuestion(String content) {

        Query query = em.createQuery("Select q.answers from Question q where q.content= :content")
                .setParameter("content", content);
        Answers answers =  (Answers) query.getSingleResult();

        ArrayList<String> answersOfSingleQuestion = answers.getAllAnswersOfSingleQuestion();

        Collections.shuffle(answersOfSingleQuestion);
        log.info("Answers of question= {}", answersOfSingleQuestion);

        return Collections.unmodifiableList(answersOfSingleQuestion);
    }

    public String getCorrectAnswer(String content) {

        Query query = em.createQuery("Select q.answers.correct from Question q where q.content= :content")
                .setParameter("content", content);

        String correctAnswer = (String) query.getSingleResult();

        return correctAnswer;
    }



}
