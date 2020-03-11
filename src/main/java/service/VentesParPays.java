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

@Path("caparpays")
public class VentesParPays {

	@Inject
	StatisticsDao dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List CAParPays(@QueryParam("from") Long timestampFrom,@QueryParam("to") Long timestampTo) {
		if(timestampFrom!=null && timestampTo!=null)
			return dao.caParPays(new Date(timestampFrom), new Date(timestampTo));
		return dao.caParPays();
	}
}
