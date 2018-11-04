package com.edusoft.skoolkive.controller;

import com.edusoft.skoolkive.entities.Attendance;
import com.edusoft.skoolkive.entities.Class_;
import com.edusoft.skoolkive.entities.Student;
import com.edusoft.skoolkive.enums.Status;
import com.edusoft.skoolkive.pojo.AttendanceDto;
import com.edusoft.skoolkive.repository.AttendanceRepository;
import com.edusoft.skoolkive.repository.ClassRepository;
import com.edusoft.skoolkive.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Mahdad-PC on 11/4/2018.
 */
@RestController
public class AttendanceController {

        @Autowired
        StudentRepository studentRepository;

        @Autowired
        ClassRepository classRepository;

        @Autowired
        AttendanceRepository attendanceRepository;

        @PostMapping("api/take/attendance")
        public ResponseEntity<String> recordAttendance(@RequestBody AttendanceDto form, HttpSession session){
            try {

                String[] status = form.getStatus();
                Long[] student_id = form.getStudents();
                Long classId = form.getClass_id();

                for (int i = 0; i < student_id.length; i++) {

                    Long id = Long.parseLong(String.valueOf(student_id[i]));
                    Student student = studentRepository.findById(id).get();

                    Long class_id = Long.parseLong(String.valueOf(classId));
                    Class_ class_ = classRepository.findById(class_id).get();

                    Attendance attendance = new Attendance();
                    attendance.setStudent(student);
                    attendance.setStatus(Status.valueOf(status[i]));
                    attendance.setClass_(class_);
                    attendance.setDateT(new Date());

                    attendanceRepository.save(attendance);
                }
                return ResponseEntity.ok("Attendance has been recorded successful...");
            } catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }