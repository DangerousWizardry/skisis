/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.LigneFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 *
 * @author cleme
 */
@Controller
@Path("ligne")
/*@View("")*/
public class LigneController {
    
        @Inject // Le DAO généré par netBeans
	LigneFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("ligne", dao.findAll());
	}
    
}
