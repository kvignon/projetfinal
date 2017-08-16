package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Classe;
import schoolboard.metier.model.EmploiDuTemps;


@Repository
@Transactional
public class EmploiTempsDaoJpa implements EmploiTempsDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public EmploiTempsDaoJpa() {
		super();
	}

	public EmploiTempsDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


	public List<EmploiDuTemps> findAll() {
		Query query = em.createQuery("from EmploiDuTemps");
		return query.getResultList();
	}

	public EmploiDuTemps find(Long id) {
		return em.find(EmploiDuTemps.class, id);
	}

	public void create(EmploiDuTemps obj) {
		em.persist(obj);

	}

	public EmploiDuTemps update(EmploiDuTemps obj) {
		return em.merge(obj);
	}

	public void delete(EmploiDuTemps obj) {
		em.remove(em.merge(obj));

	}

	public void deleteById(Long id) {
		em.remove(em.find(EmploiDuTemps.class, id));
		
	}

}
