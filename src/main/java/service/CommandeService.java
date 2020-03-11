/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import comptoirs.model.dao.StatisticsDao;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */

@Path("commandeRealisee")
public class CommandeService {
		@Inject
	StatisticsDao dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getRequest() {
		return dao.getFirstAndLastOrderDate();
	}
}
