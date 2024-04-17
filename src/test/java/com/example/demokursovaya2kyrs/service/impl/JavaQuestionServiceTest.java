package com.example.demokursovaya2kyrs.service.impl;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.exception.NotUniqueQuestionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.function.Supplier;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    @DisplayName("Корректно добавляет вопрос")
    void add() {
        Question expected = new Question("String", "String");

        //Test
        Question actual = javaQuestionService.add(expected);

        //Check
        assertThat(expected).isEqualTo(actual);

    }

    @Test
    @DisplayName("Выбрасывает исключение если вопрос дублируется ")
    void add1() {
        Question expected = new Question("String", "String");
        javaQuestionService.add(expected);
        //Test
        assertThrows(NotUniqueQuestionException.class, () -> javaQuestionService.add(expected));


    }

    @Test
    void testAdd() {
        String question = "Test";
        String question2 = "Test2";
        //Test
        Question actual = javaQuestionService.add(question, question2);
        //Check
        assertThat(actual).isEqualTo(new Question(question, question2));
    }

    @Test
    void testAdd1() {
        String question = "Test";
        String question2 = "Test2";
        javaQuestionService.add(question, question2);
        //Test
        assertThatThrownBy(() -> javaQuestionService.add(question, question2));
    }

    @Test
    void remove() {
        javaQuestionService.add(null);
        try {
            javaQuestionService.add(null);
            Assertions.fail();
        } catch (Exception e) {
        }
    }

    @Test
    void getAll() {
        javaQuestionService.getAll();


    }

    @Test
    void getRandom() {
    }
}