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

    @Column
    private String category;

    @OneToOne(fetch = FetchType.LAZY)
    private Answers answers;

    public Question(String content, String category) {
        this.content = content;
        this.category = category;
    }

    protected Question() {}




}
