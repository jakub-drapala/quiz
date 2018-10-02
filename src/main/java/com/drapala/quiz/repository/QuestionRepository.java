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

    public ArrayList<String> getAllQuestions() /*necessary*/{
        Query query = em.createQuery("Select q.content From Question q");
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        log.info("Contents of all questions: {}", questions);
        return questions;
    }

    private ArrayList<String> getAnswersOfSingleQuestion(int i) {
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


        log.info("Answer of question id={}: {}",i, questions);

        return questions;
    }



    private LinkedHashMap<Integer, String> getAllQuestionsMapedWithId() {

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

    public HashMap<String, ArrayList<String>> getAnswersOfParticularQuestion() /*necessary*/ {
        int id = minValueOfId();
        LinkedHashMap<Integer, String> questionsWithId = getAllQuestionsMapedWithId();
        HashMap<String, ArrayList<String>> questionMapedWithAnswer = new HashMap<>();

        String question;
        ArrayList<String> answers;

        int maxId = maxValueOfId();
        while (id <= maxId) {
            if (questionsWithId.containsKey(id)) {
                question = questionsWithId.get(id);
                answers = getAnswersOfSingleQuestion(id);
                questionMapedWithAnswer.put(question, answers );
            }
            id++;
        }
        return questionMapedWithAnswer;
    }

    public HashMap<String, String> getCorrectAnswer() /*necessary*/ {

        HashMap<String, String> correctMappedWithQuestion = new HashMap<>();

        Query query;
        String resultKey;
        String resultValue;

        HashSet<Integer> idContainer = getIdContainer();

        for (int i=minValueOfId(); i<=maxValueOfId(); i++) {

            if (idContainer.contains(i)) {

                query = em.createQuery("Select q.content from Question q where id= :i")
                        .setParameter("i", i);
                resultKey = (String) query.getSingleResult();

                query = em.createQuery("Select q.answers.answerA from Question q where id= :i")
                        .setParameter("i", i);
                resultValue = (String) query.getSingleResult();
                correctMappedWithQuestion.put(resultKey, resultValue);
            }
        }
        log.info("Correct value list: {}", correctMappedWithQuestion);
        return  correctMappedWithQuestion;
    }


    private int minValueOfId() {
        Query  query =  em.createQuery("Select Min(q.id) From Question q");
        Integer result = (Integer) query.getSingleResult();

        return result;
    }


    private int maxValueOfId() {
        Query  query =  em.createQuery("Select Max(q.id) From Question q");
        Integer result = (Integer) query.getSingleResult();
        return result;
    }

    private HashSet<Integer> getIdContainer() {
        HashSet<Integer> idContainer = new HashSet<>();
        Query query = em.createQuery("Select q.id from Question q");
        List<Integer> resultList = query.getResultList();
        idContainer.addAll(resultList);
        log.info("Container of id: {}", idContainer);
        return idContainer;
    }



}
