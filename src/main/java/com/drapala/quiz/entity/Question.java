package com.drapala.quiz.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by maczi on 2018-09-22.
 */

@Entity
public class Question {

    @Id
    @GeneratedValue
    private int id;



    @Getter
    @Column(nullable = false)
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    private Answers answers;

    public Question(String content) {
        this.content = content;
    }

    protected Question() {}

    public Answers getAnswers() {
        return answers;
    }


}
