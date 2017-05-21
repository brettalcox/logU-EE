/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu;

import com.logu.user.UserBeanLocal;
import com.logu.user.model.User;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author brettalcox
 */
@Path("/data")
@RequestScoped
public class UserResource {
    
    @Context
    private UriInfo context;
    
    @EJB
    private UserBeanLocal userBean;
    
    public UserResource() {
    }
    
    @Path("/users/id/{id}.json")
    @GET
    @Produces("application/json")
    public User getUserById(@PathParam("id") Long id) {
        return userBean.getUserById(id);
    }
    
    @Path("/users/username/{username}.json")
    @GET
    @Produces("application/json")
    public User getUserByUsername(@PathParam("username") String username) {
        return userBean.getUserByUsername(username);
    }
}
