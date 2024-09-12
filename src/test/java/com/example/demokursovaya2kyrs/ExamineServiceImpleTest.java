package com.example.demokursovaya2kyrs;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.service.QuestionService;
import com.example.demokursovaya2kyrs.service.impl.ExaminerService;
import com.example.demokursovaya2kyrs.service.impl.ExaminerServiceImpl;
import jdk.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExamineServiceImpleTest {
    @InjectMocks
    ExaminerServiceImpl examinerService;
    @Mock
    QuestionService questionService;


    @Test
    void getQuestionRandom() {
        Question question1 = new Question("Test", "Test2");
        Question question2 = new Question("Testt", "Test3");
        Question question3 = new Question("Testtt", "Test4");
        List<Question> questions = new ArrayList<>(List.of(question1, question2, question3));
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandom()).thenReturn(question1).thenReturn(question2).thenReturn(question3);
        examinerService.getQuestions(1);
    }
}
