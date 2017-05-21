/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logu;

import com.logu.lift.LiftFacadeSvcLocal;
import com.logu.lift.model.Lift;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author brettalcox
 */
@Path("/data")
@RequestScoped
public class LiftResource {

    @Context
    private UriInfo context;
    
    @EJB
    private LiftFacadeSvcLocal liftBean;

    /**
     * Creates a new instance of DataResource
     */
    public LiftResource() {
    }

    @Path("/lifts/user/{user}.json")
    @GET
    @Produces("application/json")
    public List<Lift> getLiftsByUser(@PathParam("user") String user) {
        return liftBean.getLiftsByUser(user);
    }
    
    @Path("/lifts/lift_id/{lift_id}.json")
    @GET
    @Produces("application/json")
    public List<Lift> getLiftById(@PathParam("lift_id") Long lift_id) {
        return liftBean.getLiftById(lift_id);
    }
    
    @Path("/lifts/lift.json")
    @POST
    @Consumes("application/json")
    public Response createLift(Lift lift) {
        return Response.ok(liftBean.createLift(lift), MediaType.TEXT_PLAIN).build();
    }
    
    @Path("/lifts/lift_id/{lift_id}.json")
    @PUT
    @Consumes("application/json")
    public Response updateLift(@PathParam("lift_id") Long lift_id, Lift lift) {
        return Response.ok(liftBean.updateLift(lift, lift_id), MediaType.TEXT_PLAIN).build();
    }
    
    @Path("/lifts/lift_id/{lift_id}.json")
    @DELETE
    @Consumes("application/json")
    public Response deleteLift(@PathParam("lift_id") Long lift_id) {
        return Response.ok(liftBean.deleteLift(lift_id), MediaType.TEXT_PLAIN).build();
    }
}
