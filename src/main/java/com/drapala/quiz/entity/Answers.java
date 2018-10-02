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


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "answers")
    private Question question;

    protected Answers() {
    }

    public Answers(String answerA, String answerB, String answerC, String answerD) {
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
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


    public Question getQuestion() {
        return question;
    }
}
