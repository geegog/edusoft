/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "students")
public class Student extends PersistentBase {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateT;
    private Set<Enrollment> enrollment = new HashSet<>(0);
    private Set<Attendance> attendance = new HashSet<>(0);
    private Set<Remark> remark = new HashSet<>(0);
    private Set<Assessment> assessment = new HashSet<>(0);

    public Student () {

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Column(length = 100)
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Column(length = 100)
    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Column(unique = true)
    public String getEmail(){
        return email;
    }

    public void setDateT(Date dateT){
        this.dateT = dateT;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateT(){
        return dateT;
    }

    @OneToMany(mappedBy="student")
    public Set<Enrollment> getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Set<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }

    @OneToMany(mappedBy="student")
    public Set<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(Set<Attendance> attendance) {
        this.attendance = attendance;
    }

    @OneToMany(mappedBy="student")
    public Set<Assessment> getAssessment() {
        return assessment;
    }

    public void setAssessment(Set<Assessment> assessment) {
        this.assessment = assessment;
    }

    @OneToMany(mappedBy="student")
    public Set<Remark> getRemark() {
        return remark;
    }

    public void setRemark(Set<Remark> remark) {
        this.remark = remark;
    }

}
