/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.StatisticsDao;
import java.sql.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author victoria
 */

@Controller
@Path("Stat")
@View("showAllStatjsp")
public class StatController {
    	@Inject // Le DAO généré par netBeans
	StatisticsDao dao;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("statistiques", dao.unitesVenduesParCategorie());
	}
        
        @GET
        public void chiffreAffaireCategorieParDate(Date debut, Date fin){
            models.put("chiffre d'affaires par artcles", dao.chiffreAffaireCategorieParDate(debut, fin));
        }
        
        @GET
        public void chiffreAffairePaysParDate(Date debut, Date fin){
            models.put("chiffre d'affaires par pays", dao.chiffreAffairePaysParDate(debut, fin));
        }
        
        @GET
        public void chiffreAffaireClientParDate(Date debut, Date fin){
            models.put("chiffre d'affaires par client", dao.chiffreAffaireClientParDate(debut, fin));
        }
}
