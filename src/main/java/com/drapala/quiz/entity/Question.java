package com.drapala.quiz.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by maczi on 2018-09-22.
 */

@Entity
public class Question {

    @Id
    @GeneratedValue
    private int id;

    @Getter
    private String content;

    public Question(String content) {
        this.content = content;
    }

    protected Question() {}


}
