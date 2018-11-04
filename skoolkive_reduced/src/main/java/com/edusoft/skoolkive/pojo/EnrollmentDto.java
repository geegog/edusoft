package com.edusoft.skoolkive.pojo;

/**
 *
 * @author onuche
 */

public class EnrollmentDto {

    private Long[] students;
    private Long[] courses;
    private Long class_id;

    public Long[] getStudents() {
        return students;
    }

    public void setStudents(Long[] students) {
        this.students = students;
    }

    public Long[] getCourses() {
        return courses;
    }

    public void setCourses(Long[] courses) {
        this.courses = courses;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }
}
