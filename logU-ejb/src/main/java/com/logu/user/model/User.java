/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author brettalcox
 */
@Entity
@Table(name="users", schema="log")
@NamedQueries({
    @NamedQuery(name="User.findById", query="SELECT o from User o WHERE o.id = :id"),
    @NamedQuery(name="User.findByUsername", query="SELECT o from User o WHERE o.username = :username")
})
public class User implements Serializable {
        private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    private Long id;
    
    @Column(name="USERNAME")
    @JsonProperty
    private String username;
    
    @Column(name="UNIT")
    @JsonProperty
    private int unit;
    
    @Column(name="BODYWEIGHT")
    @JsonProperty
    private int bodyweight;
    
    @Column(name="GENDER")
    @JsonProperty
    private char gender;
    
    public User() {};
    
    public User(String username, int unit, int bodyweight, char gender) {
        this.username = username;
        this.unit = unit;
        this.bodyweight = bodyweight;
        this.gender = gender;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setUnit(int unit) {
        this.unit = unit;
    }
    
    public void setBodyweight(int bodyweight) {
        this.bodyweight = bodyweight;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public Long getId() { return id; };
    
    public String getUsername() { return username; }
    
    public int getUnit() { return unit; }
    
    public int getBodyweight() { return bodyweight; }
    
    public char getGender() { return gender; }
}
