package com.edusoft.skoolkive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.edusoft.skoolkive.pojo.EnrollmentDto;

import javax.servlet.http.HttpSession;

/**
 * @author onuche
 */

@RestController
public class EnrollmentController {

    @PostMapping("api/enroll")
    public ResponseEntity<String> enrollmentStudents(@RequestBody EnrollmentDto form) {
        try {
            //testEnrollStudentNoClassSupplied
            if (form.getClass_id() == null) return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Enrolled!!!");
    }

}
