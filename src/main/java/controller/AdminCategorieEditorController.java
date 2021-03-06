package controller;

import comptoirs.model.dao.CategorieFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.User;
import form.CategorieForm;
import java.net.URI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

@Controller
@Path("categorieEditor")
@View("_oldEditCategory.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class AdminCategorieEditorController {

	@Inject
	CategorieFacade dao;

	@Inject
	Models models;

	@Inject
	User user;
	
	@GET
	public Response show() {
		if(!user.isLoggedIn() || !user.isAdmin()){
			return Response.seeOther(URI.create("/skisis/app/auth")).build();
		}
		models.put("categories", dao.findAll());
		return Response.ok().build();
	}

	@POST
	@ValidateOnExecution(type = ExecutableType.ALL)
	public void create(
		@FormParam("description") String description,
		@FormParam("libelle") String libelle) {
		// On crée la nouvelle catégorie
		Categorie nouvelle = new Categorie();
		nouvelle.setLibelle(libelle);
		nouvelle.setDescription(description);
		// On l'enregistre dans la base
		try {
			dao.create(nouvelle);
		} catch (EJBException e) {
			// Erreur possible : il existe déjà une catégorie avec ce libellé
			Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
			// On pourrait examiner l'exception pour vérifier sa cause exacte
			models.put("databaseErrorMessage", "La catégorie '" + libelle + "' existe déjà");
		}
		models.put("categories", dao.findAll());
	}
}
