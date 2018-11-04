/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edusoft.skoolkive.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 *
 * @author onuche.idoko
 */
@MappedSuperclass
public class PersistentBase implements Serializable{

    private Long id;

    public PersistentBase() {
    }

    @Id
    @GeneratedValue
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}