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

    private ArrayList<String> questionsList;

    private Map<String, ArrayList<String>> answersList;

    private Map<String, String> correctAnswersList;

    private int index = 0;

    public AnswersChecker checker;


    @Autowired
    public QuizService(QuestionsReceiver questionsReceiver, AnswersChecker checker) {
        this.questionsReceiver = questionsReceiver;
        this.checker = checker;
    }


    public int getIndex() {
        return ++index;
    }

    public boolean saveAllQuestions() {
        if (index==0) {
            questionsList = questionsReceiver.getAllQuestions();
            log.info("Saved question list {}", questionsList);
            answersList = saveAnswersOfParticularQuestion();
            checker.saveAnswersKey();
            log.info("Answer key: {}", checker.getAnswersKey());
            correctAnswersList = questionsReceiver.getRepository().getCorrectAnswer();
            shuffleQuestionsList();
        return true;
        }
        log.info("Questionlist is already finished");
        return false;
    }



    public ArrayList<String> getQuestionsList() {
            //Collections.shuffle(questionsList);
        return questionsList;
    }

    public void shuffleQuestionsList() {
        Collections.shuffle(questionsList);
        log.info("Shuffle is done");
    }


    public int getQuestionsListSize() {
        return this.questionsList.size();
    }

/*    public ArrayList<String> getAnswersOfQuestion(int index) {
        return this.questionsReceiver.getRepository().getAnswersOfQuestion(index+1);
    }*/

    public Map<String, ArrayList<String>> saveAnswersOfParticularQuestion() {
        return this.questionsReceiver.getRepository().getAnswersOfParticularQuestion();
    }

    public Map<String, ArrayList<String>> getAnswersList() {
        return answersList;
    }

    public ArrayList<String> getAnswerOfParticularQuestion(String question) {
        ArrayList<String> answers =  answersList.get(question);
        Collections.shuffle(answers);
        return answers;
    }



    public Map<String, String> getCorrectAnswersList() {
        return correctAnswersList;
    }

    public String getAnswer(String question) {
        return checker.getAnswerKey(question);
    }

    public boolean checkAnswer(String answer, String key) {
        return checker.checkAnswer(answer, key);
    }

    public int getAmountOfCorrectAnswers() {
        return checker.getCorrectAnswer();
    }

    public int getAmountOfAllAnswers() {
        return checker.getAllAnswers();
    }


}
