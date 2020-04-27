package com.interview.java.designpatterns.stackoverflow.controller;

import com.interview.java.designpatterns.AbstractTest;
import com.interview.java.designpatterns.stackoverflow.model.Question;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackControllerIntegrationTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    public HttpHeaders headers = new HttpHeaders();

    @Test
    public void find_login_ok() throws Exception {

        final String baseUrl = new StringBuilder().append("http://localhost:").append(randomServerPort).append("/api/stack/get/allquestions").toString();

        String expected = "{id:1,name:\"A Guide to the Bodhisattva Way of Life\",author:\"Santideva\",price:15.41}";

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Question[]> responseEntity = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET, entity, Question[].class);

       // Question[] resultQuestion = super.mapFromJson(responseEntity.getBody().toString(),Question[].class);

        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //JSONAssert.assertEquals(expected, response.getBody(), false);

    }

}
