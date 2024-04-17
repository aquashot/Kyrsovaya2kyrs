package com.example.demokursovaya2kyrs.service.impl;

import com.example.demokursovaya2kyrs.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestions(int amount);
}
