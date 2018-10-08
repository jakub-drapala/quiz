package com.drapala.quiz.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

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
        if (!clientAnswer.equals("haveNotAnswer")) {
            Answer toAdd = new Answer(clientAnswer, correctAnswer);
            answers.put(question, toAdd);
            return true;
        }
        return false;
    }

    public ArrayList<String> getQuestionsHistory() {
        return this.questionsHistory;
    }

    public HashMap<String, Answer> getAnswers() {
        return answers;
    }

    public void reset() {
        questionsHistory.removeAll(questionsHistory);
        answers.clear();
    }

    public class Answer {


        private String clientAnswer;
        private String correctAnswer;
        boolean correct;

        public Answer(String clientAnswer, String correctAnswer) {
            this.clientAnswer = clientAnswer;
            this.correctAnswer = correctAnswer;
            checkAnswer();
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

        public String getClientAnswer() {
            return clientAnswer;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public boolean isCorrect() {
            return correct;
        }



        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Answer{");
            sb.append(clientAnswer).append('\'');
            sb.append(correctAnswer).append('\'');
            sb.append(correct);
            return sb.toString();
        }
    }
}
