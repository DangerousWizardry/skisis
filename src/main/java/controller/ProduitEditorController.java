package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ProduitFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Produit;
import java.math.BigDecimal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.mvc.View;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;

@Controller
@Path("produitEditor")
@View("produitEditor.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class ProduitEditorController {

	@Inject
	CategorieFacade categorieDao;

	@Inject
	ProduitFacade produitDao;
	
	@Inject
	Models models;

	@GET
	public void show() {
		models.put("produits", produitDao.findAll());
		models.put("categories", categorieDao.findAll());
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.ALL)
	public void create(
		@FormParam("nom") String nom,
		@FormParam("prixUnitaire") int prixUnitaire,
		@FormParam("code") int codeCategorie) {
		// On crée la nouvelle catégorie
		Produit produit = new Produit();
		produit.setNom(nom);
		produit.setPrixUnitaire(BigDecimal.valueOf(prixUnitaire));
		produit.setCategorie(categorieDao.find(codeCategorie));
		// On l'enregistre dans la base
		try {
			produitDao.create(produit);
		} catch (EJBException e) {
			// Erreur possible : il existe déjà une catégorie avec ce libellé
			Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
			// On pourrait examiner l'exception pour vérifier sa cause exacte
			models.put("databaseErrorMessage", "Le produit '" + nom + "' existe déjà");
		}
		models.put("produits", produitDao.findAll());
	}
}
