package comptoirs.model.dao;

import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StatisticsDao {
	@PersistenceContext(unitName = "skisisDB")
	private EntityManager em;

	public List unitesVenduesParCategorie() {
		Query query = em.createNamedQuery("Categorie.unitesVendues");
		List results = query.getResultList();
		return results;
	}
        
        public List chiffreAffaireCategorieParDate(Date debut, Date fin){
            Query query = em.createNamedQuery("Categorie.chiffreAffaire");
            List results = query.getResultList();
            return results;
        }
        
        public List chiffreAffairePaysParDate(Date debut, Date fin){
            Query query = em.createNamedQuery("Categorie.chiffreAffaire");
            List results = query.getResultList();
            return results;
        }
        
        public List chiffreAffaireClientParDate(Date debut, Date fin){
            Query query = em.createNamedQuery("Categorie.chiffreAffaire");
            List results = query.getResultList();
            return results;
        }
}
