/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.User;
import java.io.IOException;
import java.net.URI;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

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
	public Response show() throws IOException {
		if(user.isLoggedIn() && user.isAdmin()){
			return Response.seeOther(URI.create("/skisis/app/admin")).build();
		}
		else if(user.isLoggedIn()){
			return Response.seeOther(URI.create("/skisis/app/profil")).build();
		}
		return Response.ok().build();
	}
	 @POST
  public Response login(@FormParam("user") String contact,@FormParam("password") String password) {
	  try {
		  if(contact.equals("admin") && password.equals("admin")){
			  user.setCode("ADMIN");
			  user.setAdminRights();
			  return Response.seeOther(URI.create("/skisis/app/admin")).build();
		  }
		  else{
			  Client c = (Client) clientDAO.getByContact(contact); 
			if(c.getCode().equals(password)){
				user.setCode(c.getCode());
				return Response.seeOther(URI.create("/skisis/app/profil")).build();
			}
			else{
				models.put("error", "Mot de passe incorrect");
			}
			models.put("session", user);
		  }
			return Response.ok().build();
		 } 
	  catch (Exception e) {
		  models.put("error", "Utilisateur Inconnu");
	  }
		return Response.ok().build();
	  
  }
}
