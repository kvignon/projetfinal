package schoolboard.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import schoolboard.metier.dao.HoraireDao;
import schoolboard.metier.model.Horaire;


public class HoraireDaoJpa implements HoraireDao {
	
	
private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Horaire> findAll() {
		Query query = em.createQuery("from Horaire");
		return query.getResultList();
	}

	@Override
	public Horaire find(Long id) {
		return em.find(Horaire.class, id);
	}

	@Override
	public void create(Horaire obj) {
		em.persist(obj);
	}

	@Override
	public Horaire update(Horaire obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Horaire obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

