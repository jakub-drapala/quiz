package com.drapala.quiz.entity;

import javax.persistence.*;

@Entity
public class Answers {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String answerA;

    @Column(nullable = false)
    private String answerB;

    @Column(nullable = false)
    private String answerC;

    @Column(nullable = false)
    private String answerD;

    @Column(nullable = false)
    private String correct;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "answers")
    private Question question;

    protected Answers() {
    }

    public Answers(String answerA, String answerB, String answerC, String answerD, String correct) {
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrect() {
        return correct;
    }

    public Question getQuestion() {
        return question;
    }
}
