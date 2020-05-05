/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Produit;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> {

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CommandeFacade() {
		super(Commande.class);
	}
	
	public List<Commande> findByClientCode(String code){
		//Force clear the cache in order to get up-to-date value
		em.getEntityManagerFactory().getCache().evictAll();
		  List<Commande> liste = em.createNamedQuery("Commande.findByClient").setParameter("code", code).getResultList();
            if(!liste.isEmpty())
                return liste;
            return null;
	}
	
}
