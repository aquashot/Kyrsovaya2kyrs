package com.example.demokursovaya2kyrs.service.impl;

import com.example.demokursovaya2kyrs.entity.Question;
import com.example.demokursovaya2kyrs.exception.NotUniqueQuestionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;


import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();
    private RandomGeneratorFactory<RandomGenerator> mockjavaRepository;


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
    void remove1() {
        Question expected = javaQuestionService.add("aa1", "aa2");
        Question actual = javaQuestionService.remove(expected);

        //Check
        assertThat(expected).isEqualTo(actual);
    }


    @Test
    void getAllTest() {

        Question question1 = new Question("Test", "Test2");
        Question question2 = new Question("Testt", "Test3");
        Question question3 = new Question("Testtt", "Test4");

        Collection<Question> expected = new ArrayList<>(List.of(question1, question2, question3));

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);

        Collection<Question> actual = javaQuestionService.getAll();

        assertThat(actual).containsAll(expected);
    }
}
