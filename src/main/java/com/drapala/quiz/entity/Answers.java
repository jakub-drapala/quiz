package com.drapala.quiz.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Answers {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String correct;

    @Column(nullable = false)
    private String incorrect1;

    @Column(nullable = false)
    private String incorrect2;

    @Column(nullable = false)
    private String incorrect3;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "answers")
    private Question question;

    protected Answers() {
    }

    public Answers(String correct, String incorrect1, String incorrect2, String incorrect3) {
        this.correct = correct;
        this.incorrect1 = incorrect1;
        this.incorrect2 = incorrect2;
        this.incorrect3 = incorrect3;
    }

    public int getId() {
        return id;
    }

    public String getCorrect() {
        return correct;
    }

    public String getIncorrect1() {
        return incorrect1;
    }

    public String getIncorrect2() {
        return incorrect2;
    }

    public String getIncorrect3() {
        return incorrect3;
    }

/*    public String [] getAllAnswers() {
         String [] answers = {this.correct, this.incorrect1, this.incorrect2, this.incorrect3};

         return answers;
    }*/

    public ArrayList<String> getAllAnswers() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(this.correct);
        answers.add(this.incorrect1);
        answers.add(this.incorrect2);
        answers.add(this.incorrect3);

        return answers;
    }


    public Question getQuestion() {
        return question;
    }
}
