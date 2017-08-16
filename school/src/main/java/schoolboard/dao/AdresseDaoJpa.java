package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Adresse;



@Repository
@Transactional
public class AdresseDaoJpa implements AdresseDao {

	
	@PersistenceContext
	private EntityManager em = null;
	
	public AdresseDaoJpa() {
		super();
	}

	public AdresseDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Adresse> findAll() {
		Query query = em.createQuery("from Adresse");
		return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	public Adresse find(Long id) {
		return em.find(Adresse.class, id);
	}

	
	public void create(Adresse obj) {
		em.persist(obj);
	}

	
	public Adresse update(Adresse obj) {
		return em.merge(obj);
	}

	
	public void delete(Adresse obj) {
		em.remove(em.merge(obj));
	}
	
	

	public void deleteById(Long id) {
		em.remove(em.find(Adresse.class, id));
		
	}


}

