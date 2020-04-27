package com.interview.java.designpatterns;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.java.designpatterns.stackoverflow.enums.QuestionStatus;
import com.interview.java.designpatterns.stackoverflow.model.Answer;
import com.interview.java.designpatterns.stackoverflow.model.Comment;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
public abstract class AbstractTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public Question initializeQuestionSet() {
        Question question = new Question();
        question.setTitle("Test Question");
        question.setDesc("dfs");
        question.setStatus(QuestionStatus.OPEN);
        question.setUpVote(1);

        Comment comment = new Comment("hsdf", 2);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        Answer answer = new Answer("dfdsf", 2, commentList);
        question.getAnswers().add(answer);
        return question;
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

}
