package com.drapala.quiz.controller;

import com.drapala.quiz.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by maczi on 2018-09-22.
 */
@Slf4j
@Controller
public class QuizController {


    private final QuizService quizService;

    private String tempQuestion;

    private String tempCorrectAnswer;


    @Autowired
    public QuizController(QuizService quizService) {
        log.info("Controller Constructor is running");
        this.quizService = quizService;

    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("history-quiz")
    public String startHistoryQuiz() {
        quizService.setCategory("history");
        quizService.saveAndShuffleQuestions();
        return "redirect:/quiz-1?id=0";
    }

    @GetMapping("geography-quiz")
    public String startGeographyQuiz() {
        quizService.setCategory("geography");
        quizService.saveAndShuffleQuestions();
        return "redirect:/quiz-1?id=0";
    }




    @GetMapping("quiz-1")
    public String startQuiz1(@RequestParam int id, Model model) {

        model.addAttribute("numberOfQuestion", id+1);
        model.addAttribute("amoutOfAllQuestions", quizService.getAmountOfAllQuestions());

        this.tempQuestion = quizService.getQuestion(id);
        quizService.getHistory().addQuestion(tempQuestion);

        model.addAttribute("question", tempQuestion);
        model.addAttribute("answers", quizService.getAnswers(tempQuestion));
        tempCorrectAnswer = quizService.getCorrectAnswer(tempQuestion);
        return "quiz1";
    }

    @PostMapping("quiz-1")
    public String nextQuestion(@RequestParam(name = "answer", defaultValue = "haveNotAnswer") String answer) {

        quizService.checkAnswer(answer, tempCorrectAnswer);

        quizService.getHistory().addAnswer(tempQuestion, answer, tempCorrectAnswer);

        Integer id = quizService.increaseAndGetId();
        log.info("Received answer: {}", answer);



        if (id == quizService.getQuestionsListSize()) {
            return "redirect:/result";
        }
        return "redirect:/quiz-1?id=" + id;
    }

    @GetMapping("result")
    public String showResult(Model model) {
        model.addAttribute("correctAnswers", "" + quizService.getAmountOfCorrectAnswers());
        model.addAttribute("allAnswers", "" + quizService.getAmountOfAllAnswers());

        model.addAttribute("questionsHistory", quizService.getHistory().getQuestionsHistory());


        model.addAttribute("answersHistory", quizService.getHistory().getAnswers());


        return "result";
    }

    @GetMapping("goHome")
    public String goHome() {
        quizService.resetAll();
        return "redirect:/";
    }






}
