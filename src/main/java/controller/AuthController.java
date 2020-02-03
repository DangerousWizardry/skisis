/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author victoria
 */

@Controller
@Path("client")
@View("login.jsp")
public class AuthController {
    
    @Inject
    ClientFacade dao;
    
    @Inject
    Models models;
    
    @GET
    public void show(){
      
    }
    
    @POST
    public void auth(@FormParam("user") String user,
		@FormParam("password") String password){
        
    }
}
