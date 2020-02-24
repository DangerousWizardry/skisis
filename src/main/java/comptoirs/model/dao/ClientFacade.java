/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Client;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@SessionScoped
@Named("Client")
public class ClientFacade extends AbstractFacade<Client> implements Serializable{

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;
	
	private Client loggedUser = null;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ClientFacade() {
		super(Client.class);
	}
	
	public Object getByContact(String contact){
		return em.createQuery("SELECT c FROM Client c WHERE c.contact = :contactName").setParameter("contactName", contact).getSingleResult();
	}
	public boolean isLoggedIn(){
		return loggedUser != null;
	}
	public Client getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(Client loggedUser) {
		this.loggedUser = loggedUser;
	}
	public void logoutUser(){
		this.loggedUser = null;
	}
}
