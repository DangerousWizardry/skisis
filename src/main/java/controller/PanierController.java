/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.Produit;
import comptoirs.model.entity.User;
import java.net.URI;
import java.util.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Controller
@Path("/panier")
@View("panier.jsp")
public class PanierController {
	@Inject
	Models model;
	
	@Inject
	Panier panier;
        
        @Inject
        ProduitFacade produit;
        
        @Inject
        User user;
              
	@GET
	public void show() {
            model.put("panier", panier);
	}
        
        @POST
        public void choix(@FormParam("action") String action, @FormParam("produit") Integer produitNumero, @FormParam("quantite") short nombre, @FormParam("produit_delete") Integer produitSupNumero){
            switch(action) {
                case "Modifier la quantité":
                  modifierQte(produitNumero, nombre);
                  break;
                case "Supprimer du panier":
                  supprimerProduit(produitSupNumero);
                  break;
                case "Valider le panier":
                  validerPanier();
                  break;
            }
        }
        
        @POST
        private void modifierQte(Integer produitNumero,short nombre){
            Produit p = produit.findByReference(produitNumero);
            if(p.getUnitesEnStock() >= nombre){
                for (LignePanier ligne : panier.getLignesPanier()) {
                    if (ligne.getProduit().getReference().equals(p.getReference())) {
                        ligne.setQuantite((short)(ligne.getQuantite() + nombre));
                    }
                } 
            }
            model.put("panier", panier);
        }
        
        @POST
        private void supprimerProduit(Integer produitSupNumero){
            Produit p = produit.findByReference(produitSupNumero);
            for (LignePanier ligne : panier.getLignesPanier()) {
                if (ligne.getProduit().getReference().equals(p.getReference())) {
                    panier.getLignesPanier().remove(ligne);
                }
            }
            model.put("panier", panier);
        }

        @POST
        private void validerPanier(){
            Response.seeOther(URI.create("/skisis/app/validPanier")).build();
        }
        
}
