package com.drapala.quiz.repository;

import com.drapala.quiz.QuizApplication;
import com.drapala.quiz.entity.Answers;
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
import java.util.*;

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
        query = em.createQuery("Select q.id From Question q");
        resultList = query.getResultList();
        questions = new ArrayList<>(resultList);
        log.info("Id of all questions: {}", questions);
    }

    @Test
    public void getAllQuestionsFromCategory() {
        String category = "history";
        Query query = em.createQuery("Select q.content From Question q where q.category = :cat")
                .setParameter("cat", category);
        List<String> resultList = query.getResultList();
        log.info("All questions: {}", resultList);
    }

    @Test
    public void getAllQuestionsMapedWithId() {

        Query query = em.createQuery("Select q.content From Question q");
        List<String> resultList = query.getResultList();
        Set<String> questions = new LinkedHashSet<>(resultList);
        log.info("Contents of all questions: {}", questions);

        query = em.createQuery("Select q.id From Question q");
        List<Integer> resultList2 =  query.getResultList();
        Set<Integer> identificators = new LinkedHashSet<>(resultList2);
        log.info("Id of all questions: {}", identificators);

        Map<Integer, String> questionsMapedWithId = new LinkedHashMap<>();
        Iterator<Integer> idIterator = identificators.iterator();
        Iterator<String> contentIterator = questions.iterator();

        while(idIterator.hasNext() && contentIterator.hasNext()) {
            questionsMapedWithId.put(idIterator.next(), contentIterator.next());
        }

        log.info("Question maped with ID {}", questionsMapedWithId);

    }




/*    @Test
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
    }*/

    @Test
    public void maxValueOfId() {
        Query  query = em.createQuery("Select Max(q.id) From Question q");
        Object result = query.getSingleResult();
        log.info("Max value of Id: {}", result);

    }

/*    @Test
    public void getCorrectAnswer() {
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
    }*/

/*    @Test
    public void getCorrectAnswer2() {

        HashMap<String, String> correctMappedWithQuestion = new HashMap<>();

        Query query;
        String resultKey;
        String resultValue;
        for (int i=1; i<10; i++) {
            query = em.createQuery("Select q.content from Question q where id= :i")
                .setParameter("i", i);
            resultKey = (String) query.getSingleResult();

            query = em.createQuery("Select q.answers.answerA from Question q where id= :i")
                .setParameter("i", i);
            resultValue = (String) query.getSingleResult();
            correctMappedWithQuestion.put(resultKey, resultValue);
        }
        log.info("Correct value list: {}", correctMappedWithQuestion);
    }*/




    @Test
    public void getCorrect() {
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
                result = "AnswerA";
            } else if (result.toUpperCase().equals("B")) {
                result = "AnswerB";
            } else if (result.toUpperCase().equals("C")) {
                result = "AnswerC";
            } else if (result.toUpperCase().equals("D")) {
                result = "AnswerD";
            }

            results.add(result);
            correctMappedWithQuestion.put(question, result);
        }

        log.info("Correct answers {}", correctMappedWithQuestion);
    }





    @Test
    public void getIdContainer() {
        HashSet<Integer> idContainer = new HashSet<>();
        Query query = em.createQuery("Select q.id from Question q");
        List<Integer> resultList = query.getResultList();
        idContainer.addAll(resultList);
        log.info("Container of id: {}", idContainer);
    }

/*    @Test
    public void getAllAnswers() {
        Query query = em.createQuery("Select q.answers.answerA, q.answers.answerB, q.answers.answerC, q.answers.answerD from Question q");
        Object resultList =  (Object) query.getResultList().get(0);
        log.info("Response {}", resultList);
    }*/

    @Test
    public void getAllAnswers2() {
        Query query = em.createQuery("Select q.answers from Question q where q.id= 1");
        Object resultList =  (Object) query.getSingleResult();
        Answers answers = (Answers) resultList;
        log.info("Response {}", answers.getAllAnswers());


    }

/*    @Test
    public void getCorrect2() {
        Query query = em.createQuery("Select q.answers.correct from Question q where q.content='Jaka jest najdłuższa rzeka w Polsce?'");
        String result = (String) query.getSingleResult();
        log.info("Correct Answer {}", result);

    }*/

    @Test
    public void getAllQuestions3() /*necessary*/{
        String category = "history";
        Query query = em.createQuery("Select q.content From Question q where q.category = :cat")
                .setParameter("cat", category);
        List<String> resultList = query.getResultList();
        ArrayList<String> questions = new ArrayList<>(resultList);
        log.info("Contents of all questions: {}", questions);
    }







}
