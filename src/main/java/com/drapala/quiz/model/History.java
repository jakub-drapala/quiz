package com.drapala.quiz.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class History {

    private ArrayList<String> questionsHistory;

    private HashMap<String, Answer> answers;

    public History() {
        this.questionsHistory = new ArrayList<>();
        this.answers = new HashMap<>();
    }

    public void addQuestion(String question) {
        this.questionsHistory.add(question);
    }

    public boolean addAnswer(String question, String clientAnswer, String correctAnswer) {

        Answer toAdd = new Answer(clientAnswer, correctAnswer);
        this.answers.put(question, toAdd);
        return true;


    }


    public void reset() {
        this.questionsHistory.removeAll(questionsHistory);
        this.answers.clear();
    }


    @Getter
    private class Answer {

        private String clientAnswer;
        private String correctAnswer;
        private boolean correct;
        private boolean empty;

        public Answer(String clientAnswer, String correctAnswer) {
            this.clientAnswer = clientAnswer;
            this.correctAnswer = correctAnswer;

            if (!clientAnswer.equals("haveNotAnswer")) {
                this.empty = false;
                checkAnswer();
            } else {
                this.empty = true;
                this.correct = false;
            }
        }

        public boolean checkAnswer() {
            if (clientAnswer.equals(correctAnswer)) {
                this.correct = true;
                return true;
            } else {
                this.correct = false;
                return false;
            }
        }

    }
}
