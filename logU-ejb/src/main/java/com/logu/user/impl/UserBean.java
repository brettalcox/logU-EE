/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu.user.impl;

import com.logu.AbstractBean;
import com.logu.user.UserBeanLocal;
import com.logu.user.model.User;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author brettalcox
 */
@Stateless
public class UserBean extends AbstractBean implements UserBeanLocal {
    
    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = getEntityManager().createNamedQuery("User.findById", User.class).setParameter("id", id);
        User result = query.getSingleResult();
        
        return result;
    }
    
    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByUsername", User.class).setParameter("username", username);
        User result = query.getSingleResult();
        
        return result;
    }
}
