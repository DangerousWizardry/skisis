/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.Produit;
import comptoirs.model.entity.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
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
	ProduitFacade produitDao;
	
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
                return Response.seeOther(URI.create("/skisis/app/panier?isNotLoggedIn")).build();
            }
			Client profile = clientDao.find(user.getCode());
			models.put("client", profile);
            return Response.ok().build();
        }
        
        @POST
        public Response validation(@FormParam("destinataire") String destinataire, @FormParam("adresse") String adresse, @FormParam("codePostal") String codePostal, @FormParam("ville") String ville, @FormParam("region") String region, @FormParam("pays") String pays){
			
			try {
				UserTransaction ts = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
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
				//Début de la transaction
				ts.begin();
				LinkedList<Ligne> lignes = new LinkedList<Ligne>();
				for (LignePanier ligne : panier.getLignesPanier()) {
					Ligne nouvLigne = new Ligne(commande.getNumero(), ligne.getProduit().getReference());
					nouvLigne.setQuantite(ligne.getQuantite());
					ligneDao.create(nouvLigne);
					lignes.add(nouvLigne);
					//décrémentation du stock produit
					Produit produit = produitDao.findByReference(ligne.getProduit().getReference());
					produit.setUnitesCommandees((short) (produit.getUnitesCommandees()+ligne.getQuantite()));
					produit.setUnitesEnStock((short) (produit.getUnitesEnStock()-ligne.getQuantite()));
				}
				commande.setLigneCollection(lignes);
				commandeDao.edit(commande);
				client.getCommandeCollection().add(commande);
				clientDao.edit(client);
				//Fin de la transaction
				ts.commit();
			} catch (HeuristicMixedException ex) {
				Logger.getLogger(PanierValideController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (HeuristicRollbackException ex) {
				Logger.getLogger(PanierValideController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (SecurityException ex) {
				Logger.getLogger(PanierValideController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalStateException ex) {
				Logger.getLogger(PanierValideController.class.getName()).log(Level.SEVERE, null, ex);
			}
			catch(Exception ex){
				Logger.getLogger(PanierValideController.class.getName()).log(Level.SEVERE, null, ex);
			}
			panier.clear();
			return Response.seeOther(URI.create("/skisis/app/profil")).build();
        }
      
}
