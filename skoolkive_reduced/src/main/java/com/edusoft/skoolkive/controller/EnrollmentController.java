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
    public ResponseEntity<String> enrollmentStudents(@RequestBody EnrollmentDto form, HttpSession session) {
        session.setAttribute("administrator_id_session",1);
        try {
            if (session.getAttribute("administrator_id_session") != null) {

                if (form.getClass_id() == null) return ResponseEntity.badRequest().build();

            } else if (session.getAttribute("administrator_id_session") == null) {

                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Enrolled!!!");
    }

}
