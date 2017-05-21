/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.lift.impl;
 
import com.logu.lift.LiftBeanLocal;
import com.logu.lift.LiftFacadeSvcLocal;
import com.logu.lift.LiftSummaryBeanLocal;
import com.logu.lift.model.Lift;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author brettalcox
 */
@Stateless
public class LiftFacadeSvc implements LiftFacadeSvcLocal {
    
    @EJB
    LiftBeanLocal liftBean;
    
    @EJB
    LiftSummaryBeanLocal liftSummaryBean;

    @Override
    public List<Lift> getLiftsByUser(String user) {
        return liftBean.getLiftsByUser(user);
    }

    @Override
    public List<Lift> getLiftById(Long lift_id) {
        return liftBean.getLiftById(lift_id);
    }

    @Override
    public String createLift(Lift lift) {
        return liftBean.createLift(lift);
    }

    @Override
    public String updateLift(Lift lift, Long lift_id) {
        return liftBean.updateLift(lift, lift_id);
    }

    @Override
    public String deleteLift(Long lift_id) {
        return liftBean.deleteLift(lift_id);
    }
    
}
