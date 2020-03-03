/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProduitFacade() {
		super(Produit.class);
	}
        
        public Produit findByReference(Integer ref){
            List<Produit> liste = em.createNamedQuery("Produit.findByReference").setParameter("reference", ref).getResultList();
            if(!liste.isEmpty())
                return (Produit) liste.get(0);
            return null;
        }
        	
}
