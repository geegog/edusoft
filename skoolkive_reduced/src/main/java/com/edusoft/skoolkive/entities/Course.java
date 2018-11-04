/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusoft.skoolkive.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author onuche
 */
@Entity
@Table(name = "Course")
public class Course extends PersistentBase {

    private String name;

    public Course () {

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
