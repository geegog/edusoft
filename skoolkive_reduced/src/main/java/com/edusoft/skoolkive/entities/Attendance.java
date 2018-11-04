/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import com.edusoft.skoolkive.enums.Status;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "Attendance", uniqueConstraints = {@UniqueConstraint(columnNames = {"student", "dateT"})})
public class Attendance extends PersistentBase {

    private Status status;
    private Date dateT;
    private Student student;
    private Class_ class_;

    public Attendance () {

    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus(){
        return status;
    }

    public void setDateT(Date dateT){
        this.dateT = dateT;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
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
