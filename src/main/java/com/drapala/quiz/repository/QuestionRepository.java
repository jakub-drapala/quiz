package com.drapala.quiz.repository;

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


        log.info("Answer of question id=i: {}", questions);

        return questions;
    }

//    public HashMap<String, ArrayList<String>> getAnswersOfParticularQuestion() {
//
//        HashMap<String, ArrayList<String>> answers = new HashMap<>();
//        int id = 1;
//        ArrayList<String> questions = getAllQuestions();
//        String questionToPut;
//
//        for (int i=0; i< questions.size(); i++) {
//            questionToPut = questions.get(i);
//            answers.put(questionToPut, getAnswersOfQuestion(id++));
//        }
//        return answers;
//    }


    public LinkedHashMap<Integer, String> getAllQuestionsMapedWithId() {

        Query query = em.createQuery("Select q.content From Question q");
        List<String> resultList = query.getResultList();
        Set<String> questions = new LinkedHashSet<>(resultList);
        log.info("Contents of all questions: {}", questions);

        query = em.createQuery("Select q.id From Question q");
        List<Integer> resultList2 =  query.getResultList();
        Set<Integer> identificators = new LinkedHashSet<>(resultList2);
        log.info("Id of all questions: {}", identificators);

        LinkedHashMap<Integer, String> questionsMapedWithId = new LinkedHashMap<>();
        Iterator<Integer> idIterator = identificators.iterator();
        Iterator<String> contentIterator = questions.iterator();

        while(idIterator.hasNext() && contentIterator.hasNext()) {
            questionsMapedWithId.put(idIterator.next(), contentIterator.next());
        }

        log.info("Question maped with ID {}", questionsMapedWithId);
        return questionsMapedWithId;

    }

    public HashMap<String, ArrayList<String>> getAnswersOfParticularQuestion() {
        int id = minValueOfId();
        LinkedHashMap<Integer, String> questionsWithId = getAllQuestionsMapedWithId();
        HashMap<String, ArrayList<String>> questionMapedWithAnswer = new HashMap<>();

        String question;
        ArrayList<String> answers;

        int maxId = maxValueOfId();
        while (id <= maxId) {
            if (questionsWithId.containsKey(id)) {
                question = questionsWithId.get(id);
                answers = getAnswersOfQuestion(id);
                questionMapedWithAnswer.put(question, answers );
            }
            id++;
        }
        return questionMapedWithAnswer;
    }

    public HashMap<String, String> getCorrectAnswer() {
        HashMap<String, String> correctMappedWithQuestion = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();
        for (int i = 1; i<6; i++) {
            Query query = em.createQuery("Select q.content From Question q where id= :i")
                    .setParameter("i", i);
            String question = (String) query.getSingleResult();

            query = em.createQuery("Select q.answers.correct From Question q where id= :i")
                    .setParameter("i", i);
            String result = (String) query.getSingleResult();
            if (result.toUpperCase().equals("A")) {
                query = em.createQuery("Select q.answers.answerA From Question q where id= :i")
                        .setParameter("i", i);
            } else if (result.toUpperCase().equals("B")) {
                query = em.createQuery("Select q.answers.answerB From Question q where id= :i")
                        .setParameter("i", i);
            } else if (result.toUpperCase().equals("C")) {
                query = em.createQuery("Select q.answers.answerC From Question q where id= :i")
                        .setParameter("i", i);
            } else if (result.toUpperCase().equals("D")) {
                query = em.createQuery("Select q.answers.answerD From Question q where id= :i")
                        .setParameter("i", i);
            }
            result = (String) query.getSingleResult();
            results.add(result);
            correctMappedWithQuestion.put(question, result);
        }


        log.info("Correct answers {}", correctMappedWithQuestion);
        return correctMappedWithQuestion;
    }











    public int minValueOfId() {
        Query  query =  em.createQuery("Select Min(q.id) From Question q");
        Integer result = (Integer) query.getSingleResult();


        return result;
    }


    public int maxValueOfId() {
        Query  query =  em.createQuery("Select Max(q.id) From Question q");
        Integer result = (Integer) query.getSingleResult();


        return result;
    }





}
