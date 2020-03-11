/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.dao.StatisticsDao;
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
@Path("admin")
@View("dashboard.jsp")
public class AdminStatsController {
	@Inject
	CategorieFacade categorieDao;

	@Inject
	ProduitFacade produitDao;
	
	@Inject
	StatisticsDao statisticsDao;
	
	@Inject
	Models models;
	
	@GET
	public void show() {
		models.put("firstAndLastOrderDate", statisticsDao.getFirstAndLastOrderDate());
		models.put("produits", produitDao.findAll());
		models.put("categories", categorieDao.findAll());
	}

}
