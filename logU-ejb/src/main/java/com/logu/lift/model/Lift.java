/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.lift.model;

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
@Table(name="workout", schema="log")
@NamedQueries({
    @NamedQuery(name="Lift.findByUser", query="SELECT o from Lift o WHERE o.user = :user"),
    @NamedQuery(name="Lift.findByLiftId", query="SELECT o from Lift o WHERE o.id = :lift_id")
})
public class Lift implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    private Long id;
    
    @Column(name="USER")
    @JsonProperty
    private String user;
    
    @Column(name="DATE")
    @JsonProperty
    private String date;
    
    @Column(name="LIFT")
    @JsonProperty
    private String lift;
    
    @Column(name="SETS")
    @JsonProperty
    private Long sets;
    
    @Column(name="REPS")
    @JsonProperty
    private Long reps;
    
    @Column(name="WEIGHT")
    @JsonProperty
    private Long weight;
    
    @Column(name="UNIT")
    @JsonProperty
    private int unit;
    
    @Column(name="INTENSITY")
    @JsonProperty
    private int intensity;
    
    @Column(name="NOTES")
    @JsonProperty
    private String notes;
        
    public Lift() {}
    
    public Lift(String user, String date, String lift, Long sets, Long reps, Long weight, int unit, int intensity, String notes) {
        this.user = user;
        this.date = date;
        this.lift = lift;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.unit = unit;
        this.intensity = intensity;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUser() { return user; }
    public String getDate() { return date; }
    public String getLift() { return lift; }
    public Long getSets() { return sets; }
    public Long getReps() { return reps; }
    public Long getWeight() { return weight; }
    public int getUnit() { return unit; }
    public int getIntensity() { return intensity; }
    public String getNotes() { return notes; }

    
    public void setLift(String lift) {
        this.lift = lift;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setSets(Long sets) {
        this.sets = sets;
    }
    
    public void setReps(Long reps) {
        this.reps = reps;
    }
    
    public void setWeight(Long weight) {
        this.weight = weight;
    }
    
    public void setUnit(int unit) {
        this.unit = unit;
    }
    
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lift)) {
            return false;
        }
        Lift other = (Lift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logu.Lift[ id=" + id + " ]";
    }
    
}
