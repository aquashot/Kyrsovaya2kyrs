package com.example.demokursovaya2kyrs;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.service.QuestionService;
import com.example.demokursovaya2kyrs.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamineServiceImpleTest {
    @Mock
    private QuestionService mockQuestionService;

    @InjectMocks
    ExaminerServiceImpl out;
    Question one = new Question("How old are you?", "30");
    Question two = new Question("How are you?", "i'm fine");
    Question three = new Question("How are you?", "i'm great");
    Question four = new Question("Where are you from?", "i'm from Russia");
    Set<Question> all = new HashSet<>(Set.of(one, two, three, four));


    @Test
    void getSizeRandomQuestions() {

        when(mockQuestionService.getAll())
                .thenReturn(all);
        when(mockQuestionService.getRandom())
                .thenReturn(one, two, three, four);

        assertEquals(3, out.getQuestions(3).size());
    }
}