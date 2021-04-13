package com.interview.java.designpatterns.stackoverflow.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.interview.java.designpatterns.AbstractTest;
import com.interview.java.designpatterns.stackoverflow.dao.StackOverflowRepository;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class StackControllerTest extends AbstractTest {

    @MockBean
    public StackController stackControllerMock;

    @MockBean
    public StackOverflowRepository repository;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void testPostQuestionAPI() throws Exception {

        //given
        String uri = "/api/stack/save/question";
        Question questionStub = initializeQuestionSet();
        String inputJson = super.mapToJson(questionStub);

        //when
        when(stackControllerMock.postQuestion(any(Question.class))).thenReturn(questionStub);

        MvcResult mvcResult = super.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        Question resultQuestion = super.mapFromJson(mvcResult.getResponse().getContentAsString(),Question.class);

        //then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        assertNotNull(resultQuestion);
        assertEquals(1,resultQuestion.getAnswers().size());
        assertEquals("dfs",resultQuestion.getDesc());
        assertEquals("dfdsf",resultQuestion.getAnswers().get(0).getText());

    }

    @Test
    void getAllQuestions() throws Exception{
        //given
        String uri = "/api/stack/get/allquestions";
        Question questionStub = initializeQuestionSet();
        List<Question> questionList = new ArrayList<>();
        questionList.add(questionStub);
        String inputJson = super.mapToJson(questionStub);

        //when
        when(stackControllerMock.getAllQuestions()).thenReturn(questionList);
        MvcResult mvcResult = super.mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        Question[] resultQuestion = super.mapFromJson(mvcResult.getResponse().getContentAsString(),Question[].class);

        int status = mvcResult.getResponse().getStatus();
        //then
        assertEquals(200, status);
        assertNotNull(resultQuestion);
        assertEquals(1,resultQuestion[0].getAnswers().size());
        assertEquals("dfs",resultQuestion[0].getDesc());
        assertEquals("dfdsf",resultQuestion[0].getAnswers().get(0).getText());

    }

    @Test
    void searchByTitle() {



    }

    @Test
    void search() {
    }
}