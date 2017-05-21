/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.lift;

import com.logu.lift.model.Lift;
import java.util.List;

/**
 *
 * @author brettalcox
 */
public interface LiftFacadeSvcLocal {
    List<Lift> getLiftsByUser(String user);
    
    List<Lift> getLiftById(Long lift_id);
    
    String createLift(Lift lift);
    
    String updateLift(Lift lift, Long lift_id);

    String deleteLift(Long lift_id);
}
