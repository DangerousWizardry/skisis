/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

/**
 *
 * @author victo
 */
public class LignePanier {
    private Produit produit;
    private short quantite;

    public LignePanier(Produit p, short quantite) {
        this.produit = p;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit p) {
        this.produit = p;
    }

    public short getQuantite() {
        return quantite;
    }

    public void setQuantite(short quantite) {
        this.quantite = quantite;
    }
    
}
