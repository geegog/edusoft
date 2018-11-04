package com.edusoft.skoolkive;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnrollmentControllerTest {

    @Autowired
    private TestRestTemplate template;


    @Before
    public void setUp() {
    }

    @Test
    public void testEnrollStudentSuccessful() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2],\n" +
                        "  \"courses\": [1,2,3,4,5],\n" +
                        "  \"class_id\": 1\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertEquals(response.getBody(), "Enrolled!!!");
        Assert.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testEnrollStudentNoClassSupplied() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2],\n" +
                        "  \"courses\": [1,2,3,4,5]\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(400, response.getStatusCode().value());
    }


    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

}
