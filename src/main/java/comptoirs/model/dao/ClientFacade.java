/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastidee
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

	@PersistenceContext(unitName = "skisisDB")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ClientFacade() {
		super(Client.class);
	}
	
}
