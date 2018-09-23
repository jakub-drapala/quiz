package com.drapala.quiz.config;

import com.drapala.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * Created by maczi on 2018-09-23.
 */

@Configuration
public class Config {

    private ArrayList<String> questions;

   //@Autowired
    private QuestionRepository repository;

    @Bean
    public String message(){
        return "My Message";
    }
}
