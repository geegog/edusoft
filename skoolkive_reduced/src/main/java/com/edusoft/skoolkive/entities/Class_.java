/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "Class_", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "arm"})})
public class Class_ extends PersistentBase {

    private String name;
    private String arm;

    public Class_() {

    }

    public void setName(String name){
        this.name = name;
    }

    @Column(length = 50)
    public String getName(){
        return name;
    }

    public void setArm(String arm){
        this.arm = arm;
    }

    @Column(length = 50)
    public String getArm(){
        return arm;
    }

}
