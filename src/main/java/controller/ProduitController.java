package controller;

import comptoirs.model.dao.ProduitFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@Controller
@Path("produits")
@View("showAllProduits.jsp")
public class ProduitController {
	@Inject // Le DAO généré par netBeans
	ProduitFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("produits", dao.findAll());
	}
}
