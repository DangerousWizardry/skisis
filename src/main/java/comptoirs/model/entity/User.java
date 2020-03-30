/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@SessionScoped
@Named("Utilisateur")
public class User extends Client implements Serializable{
	private boolean isAdmin = false;
	public boolean isLoggedIn(){
		return code != null;
	}
	public boolean isAdmin(){
		return isAdmin;
	}
	public void setAdminRights(){
		this.isAdmin = true;
	}
}
