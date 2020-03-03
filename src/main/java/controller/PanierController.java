/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.Panier;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Admin
 */
	@Controller
@Path("/panier")
@View("panier.jsp")
public class PanierController {
	@Inject
	Models model;
	
        @Inject
        Panier panier;
        
	@GET
	public void show() {
            model.put("panier", panier);
	}

}
