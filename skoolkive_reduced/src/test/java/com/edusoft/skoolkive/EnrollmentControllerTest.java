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

        Assert.assertEquals("Enrolled!!!", response.getBody());
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

    @Test
    public void testEnrollStudentNoCoursesSupplied() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2],\n" +
                        "  \"class_id\": 1\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    public void testEnrollStudentNoStudentsSupplied() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"courses\": [1],\n" +
                        "  \"class_id\": 1\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    public void testEnrollStudentNotExistingStudent() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2,3,6],\n" +
                        "  \"courses\": [1,2,3,4,5],\n" +
                        "  \"class_id\": 1\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertEquals("Enrolled!!!", response.getBody());
        Assert.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testEnrollStudentNotExistingCourses() throws Exception {
        HttpEntity<Object> enroll = getHttpEntity(
                "{\n" +
                        "  \"students\": [1,2],\n" +
                        "  \"courses\": [1,2,3,4,5,6,7,8,9],\n" +
                        "  \"class_id\": 1\n" +
                        "}");

        ResponseEntity<String> response = template.postForEntity(
                "/api/enroll", enroll, String.class);

        Assert.assertEquals("Enrolled!!!", response.getBody());
        Assert.assertEquals(200, response.getStatusCode().value());
    }


    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

}
