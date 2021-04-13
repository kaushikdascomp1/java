package com.interview.java.designpatterns.stackoverflow.controller;

import com.interview.java.designpatterns.stackoverflow.model.Question;
import com.interview.java.designpatterns.stackoverflow.service.StackOverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stack")
public class StackController {

    @Autowired
    public StackOverflowService stackOverflowService;

    @PostMapping("/save/question")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Question postQuestion(@RequestBody Question question){
                return stackOverflowService.postQuestion(question);
    }

    @GetMapping("/get/allquestions")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Iterable<Question> getAllQuestions(){
        return stackOverflowService.getAllQuestions();
    }

    @PostMapping("/searchByTitle/{text}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Question> searchByTitle(@PathVariable("text") String text){
        return stackOverflowService.findByTitle(text);
    }

    @PostMapping("/search/{text}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Question> search(@PathVariable("text") String text){
        return stackOverflowService.search(text);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
