package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.User;
import java.net.URI;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.persistence.EntityManager;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
/**
 *
 * @author clemence
 */
@Controller
@Path("profil")
@View("clientEditor.jsp")
public class ClientEditorController {
 
    @Inject
	ClientFacade dao;
	
	@Inject
	CommandeFacade commandeDao;

	@Inject
	Models models;
        
    @Inject
	User user;
	
	@GET
	public Response show() {
		if(!user.isLoggedIn()){
			return Response.seeOther(URI.create("/skisis/app/auth")).build();
		}
		Client profile = dao.find(user.getCode());
		models.put("user", profile);
		models.put("commandes", commandeDao.findByClientCode(user.getCode()));
		return Response.ok().build();
	}
        
       @POST
	@ValidateOnExecution(type = ExecutableType.ALL)
	public void edit(
        @FormParam("societe") String societe,
		@FormParam("contact") String contact,
		@FormParam("fonction") String fonction,
		@FormParam("adresse") String adresse,
		@FormParam("ville") String ville,
		@FormParam("region")String region,
		@FormParam("code_postal") String code_postal,
		@FormParam("pays") String pays,
		@FormParam("telephone") String telephone,
		@FormParam("fax") String fax) {
            
		// Modification des données client
		Client profile = dao.find(user.getCode());
		profile.setSociete(societe);
		profile.setContact(contact);
		profile.setFonction(fonction);
		profile.setAdresse(adresse);
		profile.setVille(ville);
		profile.setRegion(region);
		profile.setCodePostal(code_postal);
		profile.setPays(pays);
		profile.setTelephone(telephone);
		profile.setFax(fax);
		
		dao.edit(profile);
		profile = dao.find(user.getCode());
		models.put("user", profile);
        models.put("commandes", commandeDao.findByClientCode(user.getCode()));
	}
}
