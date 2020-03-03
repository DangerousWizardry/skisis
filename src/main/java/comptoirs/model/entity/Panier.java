/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

/**
 *
 * @author victo
 */
@SessionScoped
@Named("Panier")
public class Panier implements Serializable{
    private List<LignePanier> lignesPanier;

    public Panier(){
        super();
        this.lignesPanier = new LinkedList<LignePanier>();
    }
    public void addLigne(LignePanier ligne) {
        lignesPanier.add(ligne);
    }

    @Override
    public String toString() {
        String res ="";
        for(LignePanier l : lignesPanier){
            res += "Produit :" + l.getProduit().getNom();
        }
        return res;
    }

    public List<LignePanier> getLignesPanier() {
        return lignesPanier;
    }

    public void setLignesPanier(List<LignePanier> lignesPanier) {
        this.lignesPanier = lignesPanier;
    }
    
    
}
