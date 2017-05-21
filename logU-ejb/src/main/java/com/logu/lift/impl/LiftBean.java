/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.lift.impl;

import com.logu.AbstractBean;
import com.logu.lift.LiftBeanLocal;
import com.logu.lift.model.Lift;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author daddy
 */
@Stateless
public class LiftBean extends AbstractBean implements LiftBeanLocal {
    
    @Override
    public List<Lift> getLiftsByUser(String user) {
        TypedQuery<Lift> query = getEntityManager().createNamedQuery("Lift.findByUser", Lift.class).setParameter("user", user);
        List<Lift> results = query.getResultList();
        
        return results;
    }
    
    @Override
    public List<Lift> getLiftById(Long lift_id) {
        TypedQuery<Lift> query = getEntityManager().createNamedQuery("Lift.findByLiftId", Lift.class).setParameter("lift_id", lift_id);
        List<Lift> results = query.getResultList();
        
        return results;
    }
    
    @Override
    public String createLift(Lift lift) {
        if(lift != null) {
            try {
                getEntityManager().persist(lift);
                getEntityManager().flush();
            }
              catch (PersistenceException ex) {
                Logger.getLogger(LiftBean.class.getName()).log(Level.SEVERE, null, ex);
                return "Unable to create lift.";
            }
            return "Lift created.";
        }
        return "Unable to create lift.";
    }

    @Override
    public String updateLift(Lift lift, Long lift_id) {
        Lift updatedLift = getEntityManager().find(Lift.class, lift_id);
        
        if(updatedLift != null) {
            updatedLift.setDate(lift.getDate());
            updatedLift.setLift(lift.getLift());
            updatedLift.setReps(lift.getReps());
            updatedLift.setSets(lift.getSets());
            updatedLift.setWeight(lift.getWeight());
            updatedLift.setUser(lift.getUser());
            updatedLift.setUnit(lift.getUnit());
            updatedLift.setIntensity(lift.getIntensity());
            updatedLift.setNotes(lift.getNotes());

            try {
                getEntityManager().persist(updatedLift);
                getEntityManager().flush();
            }
              catch (PersistenceException ex) {
                Logger.getLogger(LiftBean.class.getName()).log(Level.SEVERE, null, ex);
                return "Unable to update lift.";
            }
            return "Lift updated.";
        }
        return "Unable to update lift.";
    }

    @Override
    public String deleteLift(Long lift_id) {
        Lift liftToDelete = getEntityManager().find(Lift.class, lift_id);
        
        if(liftToDelete != null) {
            try {
                getEntityManager().remove(liftToDelete);
                getEntityManager().flush();
            }
              catch (PersistenceException ex) {
                Logger.getLogger(LiftBean.class.getName()).log(Level.SEVERE, null, ex);
                return "Unable to delete lift.";
            }
            return "Lift deleted.";
        }
        return "Unable to delete lift.";
    }
}
