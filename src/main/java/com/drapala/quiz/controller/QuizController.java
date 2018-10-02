package com.drapala.quiz.controller;

import com.drapala.quiz.service.AnswersChecker;
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

    private AnswersChecker answersChecker;

    private String tempAnswer;


    @Autowired
    public QuizController(QuizService quizService) {
        log.info("Controller Constructor is running");
        this.quizService = quizService;
        this.answersChecker = new AnswersChecker();
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("quiz-1")
    public String startQuiz1(@RequestParam int id, Model model) {
        this.quizService.saveAllQuestions();

        int currentQuestion = id + 1;

        String question = quizService.getQuestionsList().get(id);
        log.info("Current question: {}", question);
        tempAnswer = quizService.getAnswer(question);
        log.info("Current temp answer: {}", tempAnswer);
        log.info("Answers of Question: {}", quizService.getAnswersList());
        log.info("Questions in order to display: {}", quizService.getQuestionsList());
        model.addAttribute("numberOfQuestion", currentQuestion);
        model.addAttribute("amoutOfAllQuestions", quizService.getQuestionsListSize());
        model.addAttribute("Question", question);
        log.info("Answers: {}", quizService.getAnswerOfParticularQuestion(question));
        model.addAttribute("answers", quizService.getAnswerOfParticularQuestion(question));
        model.addAttribute("AnswerKey",quizService.getAnswer(question));


        return "quiz1";
    }




    @PostMapping("quiz-1")
    public String nextQuestion(@RequestParam(name="answer", defaultValue = "haveNotAnswer")String answer) {

        this.quizService.checkAnswer(answer, tempAnswer);
        log.info("Comparison! {} ?=? {}", answer, tempAnswer);


        String id = "" + this.quizService.getIndex();
        log.info("Current id = {}", id );
        log.info("Answer: {}", answer);
        if (Integer.parseInt(id) == 0) {
            return "error";
        } else if (Integer.parseInt(id) < quizService.getQuestionsListSize()) {
            return "redirect:/quiz-1?id=" + id;
        } else {
            return "redirect:/result";
        }
    }

    @GetMapping("result")
    public String showResult(Model model) {
        model.addAttribute("correctAnswers", quizService.getAmountOfCorrectAnswers());
        model.addAttribute("allAnswers", quizService.getAmountOfAllAnswers());
        return "result";
    }


}
