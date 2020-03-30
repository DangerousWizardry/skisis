package comptoirs.model.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StatisticsDao {
	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	public List getFirstAndLastOrderDate() {
		LinkedList<Long> timeResult = new LinkedList<>();
		Query query = em.createNamedQuery("Commande.findFirstDate");
		timeResult.add(((Date) (query.getResultList().get(0))).getTime());
		query = em.createNamedQuery("Commande.findLastDate");
		timeResult.add(((Date) (query.getResultList().get(0))).getTime());
		return timeResult;
	}
	
	public List caParCategorie() {
		Query query = em.createNamedQuery("Categorie.CAParCategorie");
		List results = query.getResultList();
		return results;
	}

	public List caParCategorie(Date from,Date to) {
		Query query = em.createNamedQuery("Categorie.CAParCategorieParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
	public List caParPays() {
		Query query = em.createNamedQuery("Commande.CAParPays");
		List results = query.getResultList();
		return results;
	}

	public List caParPays(Date from,Date to) {
		Query query = em.createNamedQuery("Commande.CAParPaysParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
	public List caParClient() {
		Query query = em.createNamedQuery("Commande.CAParClient");
		List results = query.getResultList();
		return results;
	}

	public List caParClient(Date from,Date to) {
		Query query = em.createNamedQuery("Commande.CAParClientParTemps");
		query = query.setParameter("from", from);
		query = query.setParameter("to", to);
		List results = query.getResultList();
		return results;
	}	
}
