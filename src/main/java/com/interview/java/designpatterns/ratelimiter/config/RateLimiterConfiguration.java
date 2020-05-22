package com.interview.java.designpatterns.ratelimiter.config;


import com.interview.java.designpatterns.ratelimiter.model.UserApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;

@Component
public class RateLimiterConfiguration extends HandlerInterceptorAdapter {

    public static final Logger log = LoggerFactory.getLogger(RateLimiterConfiguration.class);

    @Value("${rate.limit.enabled}")
    private boolean enabled;

    public static final int DEFAULT_PERMIT = 1;

    private Map<UserApiModel, Optional<Semaphore>> limiters = new ConcurrentHashMap<>();

    private static Map<UserApiModel,Integer> limiterConnects = new HashMap<>();

    static {
        UserApiModel model1 = new UserApiModel("User1","/api/v1/developers");
        UserApiModel model2 = new UserApiModel("User2","/api/v1/developers");
        UserApiModel model3 = new UserApiModel("User1","/api/v1/organizations");
        UserApiModel model4 = new UserApiModel("User2","/api/v1/organizations");
        limiterConnects.put(model1,2);
        limiterConnects.put(model2,2);
        limiterConnects.put(model3,2);
        limiterConnects.put(model4,2);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!enabled) {
            return true;
        }
        //Get request url's from servlet request
        String requestUrl = request.getRequestURI();
        //Get Username from Servlet Request
        String user = request.getHeader("User");

        if(null == user)
            user = "";

        Predicate<UserApiModel> predicate = getPredicate(user, requestUrl);
        Optional<Integer> permits = limiterConnects.entrySet().stream().filter(e -> predicate.test(e.getKey())).map(x -> x.getValue()).findFirst();

        //get key
        Optional<UserApiModel> userApiDetails = limiterConnects.entrySet().stream().filter(e -> predicate.test(e.getKey())).map(x -> x.getKey()).findFirst();


        Semaphore rateLimiter = getRateLimiter(userApiDetails.isPresent() ? userApiDetails.get(): new UserApiModel(user,requestUrl),permits.isPresent() ? permits.get() : DEFAULT_PERMIT);

        boolean allowRequest = rateLimiter.tryAcquire();

        if (!allowRequest) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return allowRequest;
    }

    private Predicate<UserApiModel> getPredicate(String userName, String api){
        return userApiModel -> userApiModel.getApi().equals(api) && userApiModel.getUsername().equals(userName);
    }

    private Semaphore getRateLimiter(UserApiModel userApiDetail, int permits) {
        if (limiters.containsKey(userApiDetail)) {
            return limiters.get(userApiDetail).get();
        } else {
            synchronized(userApiDetail.getClass()) {
                // double-checked locking to avoid multiple-reinitializations
                if (limiters.containsKey(userApiDetail)) {
                    return limiters.get(userApiDetail).get();
                }
                Semaphore rateLimitPermit = new Semaphore(permits);

                limiters.put(userApiDetail, Optional.ofNullable(rateLimitPermit));
                limiterConnects.put(userApiDetail,permits);
                return rateLimitPermit;
            }
        }
    }

    @PreDestroy
    public void destroy() {
        // loop and finalize all limiters
        log.info("Request completed:: ");
    }


}
