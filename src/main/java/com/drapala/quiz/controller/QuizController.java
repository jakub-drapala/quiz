package com.drapala.quiz.controller;

import com.drapala.quiz.service.QuizService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Controller
public class QuizController {


    private final QuizService quizService;


    @Autowired
    public QuizController(QuizService quizService) {
        log.info("Controller Constructor is running");
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String home(Model model) {
        //quizService.saveAllQuestions();
        return "index";
    }

    @GetMapping("quiz-1")
    public String startQuiz1(@RequestParam int id, Model model) {
        this.quizService.saveAllQuestions();
        model.addAttribute("Question", quizService.getQuestionsList().get(id));

        return "quiz1";
    }




    @GetMapping("goNext")
    public String nextQuestion() {
        String id = "" + this.quizService.getIndex();
        if (Integer.parseInt(id) < quizService.getQuestionsListSize()) {
            return "redirect:/quiz-1?id=" + id;
        } else {
            return "result";
        }
    }


}