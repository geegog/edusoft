package com.edusoft.skoolkive;

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

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AttendanceControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() {
    }

    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

    @Test
    public void testAttendanceSuccessful() throws Exception {
        HttpEntity<Object> attendance = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2],\n" +
                        "  \"class_id\": 1,\n" +
                        "  \"status\": [\"LATE\",\"EXCUSED\"]\n"+
                        "}");

        ResponseEntity<String> response =
                template.postForEntity(
                        "/api/take/attendance", attendance, String.class);

        Assert.assertEquals(200, response.getStatusCode().value());
    }
}
