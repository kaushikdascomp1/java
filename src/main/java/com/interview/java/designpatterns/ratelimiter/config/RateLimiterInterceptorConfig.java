package com.interview.java.designpatterns.ratelimiter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RateLimiterInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RateLimiterConfiguration limiterConfiguration;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(limiterConfiguration);
    }


}
