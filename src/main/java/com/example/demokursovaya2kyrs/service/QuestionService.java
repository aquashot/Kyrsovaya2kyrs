package com.example.demokursovaya2kyrs.service;

import com.example.demokursovaya2kyrs.entity.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandom();


}
