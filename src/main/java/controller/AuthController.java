/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.User;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Admin
 */
@Controller
@Path("auth")
@View("auth.jsp")
public class AuthController {

	@Inject
	ClientFacade clientDAO;

	@Inject
	Models models;
	
	@Inject
	User user;
	
	@GET
	public void show(){
		System.out.println(user.isLoggedIn());
		if(user.isLoggedIn()){
			models.put("session", user);
		}
	}
	 @POST
  public void login(@FormParam("user") String contact,@FormParam("password") String password) {
	  try {
			Client c = (Client) clientDAO.getByContact(contact); 
			 System.out.println(c.getCode());
			if(c.getCode().equals(password)){
				user.setCode(c.getCode());
			}
			else{
				models.put("error", "Mot de passe incorrect");
			}
			models.put("session", user);
		 } 
	  catch (Exception e) {
		  models.put("error", "Utilisateur Inconnu");
	  }
	  
  }
}
