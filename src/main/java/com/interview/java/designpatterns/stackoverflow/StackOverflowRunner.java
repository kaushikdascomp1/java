package com.interview.java.designpatterns.stackoverflow;

import com.interview.java.designpatterns.stackoverflow.controller.StackController;
import com.interview.java.designpatterns.stackoverflow.enums.QuestionStatus;
import com.interview.java.designpatterns.stackoverflow.model.Answer;
import com.interview.java.designpatterns.stackoverflow.model.Comment;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class StackOverflowRunner implements CommandLineRunner {

    @Autowired
    public StackController stackController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StackOverflow Runner Started");
        //intializeStackOverFlow();

    }

    private void intializeStackOverFlow() {
        Question question = new Question();
        question.setTitle("Test Question");
        question.setDesc("dfs");
        question.setStatus(QuestionStatus.OPEN);
        question.setUpVote(1);

        Comment comment =new Comment("hsdf",2);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        Answer answer = new Answer("dfdsf",2,commentList);
        question.getAnswers().add(answer);

        Question question1 = stackController.postQuestion(question);
        System.out.println(question1);

        Iterable<Question> allQuestions = stackController.getAllQuestions();
        System.out.println(allQuestions);

        List<Question> searchQuestions = stackController.searchByTitle("Test");
        System.out.println("Search Questions Results:   "+searchQuestions);

        List<Question> searchAll = stackController.search("dfs");
        System.out.println("Search All Questions Results:   "+searchAll);
    }
}
