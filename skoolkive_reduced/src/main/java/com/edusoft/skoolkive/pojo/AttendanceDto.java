package com.edusoft.skoolkive.pojo;


/**
 * Created by Mahdad-PC on 11/4/2018.
 */
public class AttendanceDto {

    private   Long[] students;
    private   Long class_id;
    private  String[] status;

    public Long[] getStudents() {
        return students;
    }

    public void setStudents(Long[] students) {
        this.students = students;
    }


    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}
