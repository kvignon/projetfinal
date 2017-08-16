package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Classe;
import schoolboard.metier.model.Salle;


@Repository
@Transactional
public class SalleDaoJpa implements SalleDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public SalleDaoJpa() {
		super();
	}

	public SalleDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

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

	
	public Salle find(Long id) {
		return em.find(Salle.class, id);
	}

	
	public void create(Salle obj) {
		em.persist(obj);
	}

	
	public Salle update(Salle obj) {
		return em.merge(obj);
	}

	
	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}

	public void deleteById(Long id) {
		em.remove(em.find(Salle.class, id));
		
	}

}

