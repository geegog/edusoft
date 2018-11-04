/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author geegog
 */
@Entity
@Table(name = "Remark", uniqueConstraints = {@UniqueConstraint(columnNames = {"student", "class_"})})
public class Remark extends PersistentBase {

    private String note;
    private Student student;
    private Class_ class_;

    public Remark() {

    }

    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
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
