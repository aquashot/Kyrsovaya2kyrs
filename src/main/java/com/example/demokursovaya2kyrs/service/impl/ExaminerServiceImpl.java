package com.example.demokursovaya2kyrs.service.impl;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.exception.QuestionsAmountExceededException;
import com.example.demokursovaya2kyrs.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if(questionService.getAll().size()<amount){
            throw new QuestionsAmountExceededException();
        }
        return Stream.generate(questionService::getRandom)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }

}
