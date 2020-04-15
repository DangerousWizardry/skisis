package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ProduitFacade;
import java.util.List;


import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.LignePanier;
import comptoirs.model.entity.Panier;
import comptoirs.model.entity.Produit;
import comptoirs.model.entity.User;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;


@Controller
@Path("categorieProduits")
@View("showProduitsByCategory.jsp")
public class ProduitParCategorieController {
	@Inject
	CategorieFacade facade;

	@Inject
	Models models;
        
        @Inject
        User user;
        
        @Inject
        Panier panier;
        
        @Inject
        ProduitFacade produit;

	@GET
	public void produitsParCategorie( @QueryParam("code") Integer codeCategorie ) {
		// On cherche la liste des catégories pour l'afficher dans la liste de choix
		final List<Categorie> touteslesCategories = facade.findAll();

		// On cherche la catégorie à partir de son code passé en paramètre
		Categorie categorieChoisie;
		if (codeCategorie != null) // Est-ce qu'on a un paramètre ?
			// On va chercher la catégorie 
			categorieChoisie = facade.find(codeCategorie); // Et si on ne trouve pas ?
		else
			// On prend la première de la liste (encore faut-il qu'il y en ait une !)
			categorieChoisie = touteslesCategories.get(0);

		// On transmet les informations à la vue
		models.put("selected", categorieChoisie);
                models.put("user_session", user);
	}
        
        @POST
        public void ajouter(@FormParam("produit") Integer produitNumero, @FormParam("quantite") short nombre){
            if(panier==null) panier=new Panier();
            Produit p = produit.findByReference(produitNumero);
            if(p!=null){
                if(p.getUnitesEnStock() >= nombre){
                    if (!panier.getLignesPanier().isEmpty() ){
                        int compteur = 0;
                        for (LignePanier ligne : panier.getLignesPanier()) {
                            if (ligne.getProduit().getReference().equals(p.getReference())) {
                                ligne.setQuantite((short)(ligne.getQuantite() + nombre));
                                compteur++;
                            }
                        }
                        if (compteur == 0) {
                            panier.addLigne(new LignePanier(p,nombre));
                        }
                    }else{ 
                        panier.addLigne(new LignePanier(p,nombre));
                    }
                }
            }  
            models.put("panier", panier);
        }
        
}
