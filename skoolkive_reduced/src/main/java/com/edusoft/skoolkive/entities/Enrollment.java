/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "Enrollment", uniqueConstraints = {@UniqueConstraint(columnNames = {"course", "student", "class_"})})
public class Enrollment extends PersistentBase {

    private Course course;
    private Date dateT;
    private Student student;
    private Class_ class_;

    public Enrollment () {

    }

    public void setCourse(Course course){
        this.course = course;
    }

    @ManyToOne
    @JoinColumn (name = "course")
    public Course getCourse(){
        return course;
    }

    public void setDateT(Date dateT){
        this.dateT = dateT;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateT(){
        return dateT;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    @ManyToOne
    @JoinColumn (name = "student")
    public Student getStudent(){
        return student;
    }

    public void setClass_(Class_ class_){
        this.class_ = class_;
    }

    @ManyToOne
    @JoinColumn (name = "class_")
    public Class_ getClass_(){
        return class_;
    }

}
