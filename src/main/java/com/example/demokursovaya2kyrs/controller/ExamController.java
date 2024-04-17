package com.example.demokursovaya2kyrs.controller;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.service.impl.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question>getRandomQuestion(@PathVariable("amount")int amount){
        return examinerService.getQuestions(amount);
    }
}
