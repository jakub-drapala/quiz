package com.drapala.quiz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Service
public class QuizService {


    private QuestionsReceiver questionsReceiver;

    private ArrayList<String> questionsList; //necessary

    private Map<String, ArrayList<String>> answersList;

    private int index = 0;

    public AnswersChecker checker;


    @Autowired
    public QuizService(QuestionsReceiver questionsReceiver, AnswersChecker checker) {
        this.questionsReceiver = questionsReceiver;
        this.checker = checker;

        questionsList = questionsReceiver.getAllQuestions();
        log.info("Saved question list {}", questionsList);
        answersList = saveAnswersOfParticularQuestion();
        checker.saveAnswersKey();
        log.info("Answer key: {}", checker.getAnswersKey());
        shuffleQuestionsList();
    }


    public int getAndIncreaseIndex() /*necessary*/{
        return ++index;
    }



    public ArrayList<String> getQuestionsList() {
        return questionsList;
    }

    public void shuffleQuestionsList() {
        Collections.shuffle(questionsList);
        log.info("Shuffle is done");
    }


    public int getQuestionsListSize() /*necessary*/ {
        return this.questionsList.size();
    }


    public Map<String, ArrayList<String>> saveAnswersOfParticularQuestion() {
        return this.questionsReceiver.getRepository().getAnswersOfParticularQuestion();
    }


    public ArrayList<String> getAnswersOfParticularQuestion(String question) /*necessary*/ {
        ArrayList<String> answers =  answersList.get(question);
        Collections.shuffle(answers);
        return answers;
    }



    public String getAnswer(String question) /*necessary*/ {
        return checker.getAnswersKey(question);
    }

    public boolean checkAnswer /*necessary*/(String answer, String key) {
        return checker.checkAnswer(answer, key);
    }

    public int getAmountOfCorrectAnswers() /*necessary*/ {
        return checker.getCorrectAnswerAmount();
    }

    public int getAmountOfAllAnswers() /*necessary*/ {
        return checker.getAllAnswersAmount();
    }


}
