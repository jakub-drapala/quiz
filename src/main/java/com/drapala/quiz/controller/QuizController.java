package com.drapala.quiz.controller;

import com.drapala.quiz.service.Quiz;
import com.drapala.quiz.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Controller
public class QuizController {


    private final Quiz quiz;

    private String tempQuestion;

    private String tempCorrectAnswer;


    @Autowired
    public QuizController(QuizService quizService) {
        log.info("Controller Constructor is running");
        this.quiz = quizService;

    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }


    @GetMapping(value = "/{category}")
    public String startQuiz(@PathVariable String category) {
        log.info("Chose category {}", category);
        this.quiz.setCategory(category);
        this.quiz.saveQuestions();
        return "redirect:/quiz/0";
    }


    @GetMapping("quiz/{questionId}")
    public String startQuiz1(@PathVariable(value = "questionId") int id, Model model) {

        model.addAttribute("numberOfQuestion", id+1);
        model.addAttribute("amoutOfAllQuestions", this.quiz.getQuestionsListSize());

        this.tempQuestion = this.quiz.getQuestion(id);
        this.quiz.getHistory().addQuestion(this.tempQuestion);

        model.addAttribute("question", this.tempQuestion);
        model.addAttribute("answers", this.quiz.getAnswers(this.tempQuestion));
        this.tempCorrectAnswer = this.quiz.getCorrectAnswer(this.tempQuestion);
        return "each_question";
    }

    @PostMapping("quiz/{questionId}")
    public String nextQuestion(@PathVariable(value = "questionId") int id, @RequestParam(name = "answer", defaultValue = "haveNotAnswer") String answer) {

        this.quiz.checkAnswer(answer, this.tempCorrectAnswer);

        this.quiz.getHistory().addAnswer(this.tempQuestion, answer, this.tempCorrectAnswer);

        id = this.quiz.increaseAndGetId();

        if (id == this.quiz.getQuestionsListSize()) {
            return "redirect:/result";
        }
        return "redirect:/quiz/" + id;
    }

    @GetMapping("result")
    public String showResult(Model model) {

        model.addAttribute("result",  this.quiz.showResult());

        model.addAttribute("questionsHistory", this.quiz.getHistory().getQuestionsHistory());

        model.addAttribute("answersHistory", this.quiz.getHistory().getAnswers());

        model.addAttribute("duration", this.quiz.getQuizDuration());


        return "result";
    }

    @GetMapping("goHome")
    public String goHome() {
        this.quiz.resetAll();
        return "redirect:/";
    }




}
