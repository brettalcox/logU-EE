/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.user;

import com.logu.user.model.User;
import javax.ejb.Local;

/**
 *
 * @author brettalcox
 */
@Local
public interface UserBeanLocal {
    User getUserById(Long id);
    
    User getUserByUsername(String username);
}
