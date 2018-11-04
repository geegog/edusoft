package com.edusoft.skoolkive.controller;

import com.edusoft.skoolkive.entities.*;
import com.edusoft.skoolkive.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.edusoft.skoolkive.pojo.EnrollmentDto;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author onuche
 */

@RestController
public class EnrollmentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AssessmentRepository assessmentRepository;

    @PostMapping("api/enroll")
    public ResponseEntity<String> enrollmentStudents(@RequestBody EnrollmentDto form) {

            //testEnrollStudentNoClassSupplied
            if (form.getClass_id() == null) return ResponseEntity.badRequest().build();

            //testEnrollStudentNoCoursesSupplied
            if (form.getCourses() == null) return ResponseEntity.badRequest().build();

            //testEnrollStudentNoStudentsSupplied
            if (form.getStudents() == null) return ResponseEntity.badRequest().build();
        try {

            Long[] student_id = form.getStudents();
            Long[] course_id = form.getCourses();
            String[] trait = {"Attentiveness", "Honesty", "Neatness", "Punctuality", "Club/Society", "Drawing and Painting",
                    "Hand Writing", "Sports and Games"};
            String[] type = {"Affective", "Affective", "Affective", "Affective", "Psychomotor", "Psychomotor", "Psychomotor",
                    "Psychomotor"};

            Class_ class_ = classRepository.findById(form.getClass_id()).orElse(null);

            for (int i = 0; i < student_id.length; i++) {

                Student student = studentRepository.findById(student_id[i]).orElse(null);

                for (int j = 0; j < course_id.length; j++) {

                    Enrollment enrollment = new Enrollment();
                    Course course = courseRepository.findById(Long.valueOf(course_id[j])).orElse(null);

                    if (class_ == null) {
                        return ResponseEntity.badRequest().build();
                    }
                    enrollment.setClass_(class_);
                    enrollment.setDateT(new Date());
                    if (student == null) {
                        continue;
                    }
                    enrollment.setStudent(student);
                    if (course == null) {
                        continue;
                    }
                    enrollment.setCourse(course);

                    try {
                        enrollmentRepository.save(enrollment);
                    } catch (Exception e) {
                        //already added
                    }

                }

                for (int x = 0; x < trait.length; x++) {

                    Assessment assessment = new Assessment();
                    assessment.setTrait(trait[x]);
                    assessment.setType(type[x]);
                    assessment.setRating("");
                    assessment.setStudent(student);
                    assessment.setClass_(class_);

                    try {
                        assessmentRepository.save(assessment);
                    } catch (Exception e) {
                        //already added
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Enrolled!!!");
    }

}
