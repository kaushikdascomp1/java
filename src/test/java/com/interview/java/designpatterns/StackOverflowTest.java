package com.interview.java.designpatterns;

import com.interview.java.designpatterns.stackoverflow.controller.StackController;
import com.interview.java.designpatterns.stackoverflow.enums.QuestionStatus;
import com.interview.java.designpatterns.stackoverflow.model.Answer;
import com.interview.java.designpatterns.stackoverflow.model.Comment;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class StackOverflowTest extends AbstractTest{

    @Autowired
    public StackController stackController;

    private Question question;

    @BeforeEach
    public void setUp(){
        this.question = super.initializeQuestionSet();
    }


    @Test
    public void post_a_new_question() {
            //given
        //questions initlized

        //when
        Question savedQuestion = stackController.postQuestion(this.question);

        //then
        assertNotNull(savedQuestion);
        assertEquals(1,savedQuestion.getAnswers().size());
        assertEquals("dfs",savedQuestion.getDesc());
        assertEquals("dfdsf",savedQuestion.getAnswers().get(0).getText());
    }

    @Test
    public void get_all_questions(){
        //given
        //create test scenario
        post_a_new_question();

        //when
        Iterable<Question> allQuestions = stackController.getAllQuestions();

        //then
        assertNotNull(allQuestions);
        assertEquals(1,allQuestions.iterator().hasNext()? allQuestions.iterator().next().getAnswers().size():0);
        assertEquals("dfs",allQuestions.iterator().next().getDesc());
        assertEquals("dfdsf",allQuestions.iterator().next().getAnswers().get(0).getText());
    }

}
