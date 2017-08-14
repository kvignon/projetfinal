package schoolboard.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import schoolboard.metier.dao.SalleDao;
import schoolboard.metier.model.Salle;




public class SalleDaoJpa implements SalleDao {
	
	
	private EntityManager em;
	
	@Override
	public List<Salle> findAll() {
		Query query = em.createQuery("from Salle");
		return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Salle find(Long id) {
		return em.find(Salle.class, id);
	}

	@Override
	public void create(Salle obj) {
		em.persist(obj);
	}

	@Override
	public Salle update(Salle obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

