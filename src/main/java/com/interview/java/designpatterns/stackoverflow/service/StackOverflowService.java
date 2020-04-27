package com.interview.java.designpatterns.stackoverflow.service;

import com.interview.java.designpatterns.stackoverflow.dao.StackOverflowRepository;
import com.interview.java.designpatterns.stackoverflow.enums.QuestionStatus;
import com.interview.java.designpatterns.stackoverflow.model.Answer;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import com.interview.java.designpatterns.stackoverflow.model.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StackOverflowService implements Search {

    public static Logger log = LoggerFactory.getLogger(StackOverflowService.class);

    @Autowired
    public StackOverflowRepository repository;

    public Question postQuestion(Question question){
        return repository.save(question);
    }

    public Iterable<Question> getAllQuestions(){
        return repository.findAll();
    }

    public Question submitAnswer(Long questionId, Answer  answer){
        Optional<Question> question = repository.findById(questionId);

        if(question.isPresent()){
            Question questionFromDB = question.get();
            if(questionFromDB.getStatus().equals(QuestionStatus.OPEN)){
                question.get().getAnswers().add(answer);
                repository.save(question.get());
            }else {
                log.error("Question Category should be in Open::");
            }

        }

        return question.get();
    }

    public List<Question> findByTitle(String text){
        return repository.findByTitle(text);
    }

    @Override
    public List<Question> search(String query) {
        return repository.search(query);
    }

}
