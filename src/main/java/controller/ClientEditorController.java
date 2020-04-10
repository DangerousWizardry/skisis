package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.User;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
	Models models;
        
        @Inject
	User user;

	@GET
	public void show() {
		models.put("user", user);
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
                
		user.setSociete(societe);
                user.setContact(contact);
		user.setFonction(fonction);
                user.setAdresse(adresse);
                user.setVille(ville);
                user.setRegion(region);
                user.setCodePostal(code_postal);
                user.setPays(pays);
                user.setTelephone(telephone);
                user.setFax(fax);
                                
                dao.edit(user);

                models.put("user", user);
                                
	}
}
