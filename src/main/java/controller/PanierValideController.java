/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Controller
@Path("panier/validation")
@View("panierValide.jsp")
public class PanierValideController {
    
	@Inject
	Models model;
	
	@Inject
	ClientFacade clientDao;	
	
	@Inject
	CommandeFacade commandeDao;
		
	@Inject
	
	LigneFacade ligneDao;
	
	@Inject
	Panier panier;
        
    @Inject
    User user;
	
	@Inject
	Models models;
	
	@GET
	public Response show() throws IOException {
            if (!user.isLoggedIn()) {
                return Response.seeOther(URI.create("/skisis/app/panier")).build();
            }
			Client profile = clientDao.find(user.getCode());
			models.put("client", profile);
            return Response.ok().build();
        }
        
        @POST
        public Response validation(@FormParam("destinataire") String destinataire, @FormParam("adresse") String adresse, @FormParam("codePostal") String codePostal, @FormParam("ville") String ville, @FormParam("region") String region, @FormParam("pays") String pays){
			Commande commande = new Commande();
			Client client = clientDao.find(user.getCode());
            commande.setClient(client);
            commande.setDestinataire(destinataire);
            commande.setAdresseLivraison(adresse);
            commande.setCodePostalLivrais(codePostal);
            commande.setVilleLivraison(ville);
            commande.setRegionLivraison(region);
            commande.setPaysLivraison(pays);
            commande.setSaisieLe(new Date());
			commande.setRemise(BigDecimal.ZERO);
			commandeDao.create(commande);
			LinkedList<Ligne> lignes = new LinkedList<Ligne>();
			for (LignePanier ligne : panier.getLignesPanier()) {
                Ligne nouvLigne = new Ligne(commande.getNumero(), ligne.getProduit().getReference());
                nouvLigne.setQuantite(ligne.getQuantite());
				ligneDao.create(nouvLigne);
				lignes.add(nouvLigne);
            }
			commande.setLigneCollection(lignes);
			commandeDao.edit(commande);
			return Response.seeOther(URI.create("/skisis/app/profil")).build();
        }
      
}
