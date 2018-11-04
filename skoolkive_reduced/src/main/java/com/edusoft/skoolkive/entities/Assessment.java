/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import javax.persistence.*;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "Assessment", uniqueConstraints = {@UniqueConstraint(columnNames = {"student", "class_"})})
public class Assessment extends PersistentBase {

    private String trait;
    private String rating;
    private String type;
    private Class_ class_;
    private Student student;

    public Assessment () {

    }

    public void setTrait(String trait){
        this.trait = trait;
    }

    @Column(length = 50)
    public String getTrait(){
        return trait;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getRating(){
        return rating;
    }

    public void setType(String type){
        this.type = type;
    }

    @Column(length = 50)
    public String getType(){
        return type;
    }

    public void setClass_(Class_ class_){
        this.class_ = class_;
    }

    @ManyToOne
    @JoinColumn (name = "class_")
    public Class_ getClass_(){
        return class_;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    @ManyToOne
    @JoinColumn (name = "student")
    public Student getStudent(){
        return student;
    }

}
