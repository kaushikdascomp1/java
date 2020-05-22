package com.interview.java.designpatterns.ratelimiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class APILimiterController {

    @GetMapping("/developers")
    public @ResponseBody
    String developerApi(){
        return "Developer API Access granted";
    }

    @GetMapping("/organizations")
    public @ResponseBody
    String organizationApi(){
        return "Organization API Access granted";
    }


}
