/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CategorieFacade;
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
@Path("")
@View("index.jsp")
public class IndexController {
	@Inject
	CategorieFacade cFacade;
	
	@Inject
	Models model;
	
	@GET
	public void show() {
		model.put("categories", cFacade.findAll());
	}

}
