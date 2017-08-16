package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Classe;
import schoolboard.metier.model.Etablissement;


@Repository
@Transactional
public class EtablissementDaoJpa implements EtablissementDao {
	
	@PersistenceContext
	private EntityManager em = null;
	
	public EtablissementDaoJpa() {
		super();
	}

	public EtablissementDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	public List<Etablissement> findAll() {
		Query query = em.createQuery("from Etablissement");
		return query.getResultList();
	}

	
	public Etablissement find(Long id) {
		return em.find(Etablissement.class, id);
	}

	
	public void create(Etablissement obj) {
		em.persist(obj);
	}

	
	public Etablissement update(Etablissement obj) {
		return em.merge(obj);
	}

	
	public void delete(Etablissement obj) {
		em.remove(em.merge(obj));
	}

	public void deleteById(Long id) {
		em.remove(em.find(Etablissement.class, id));
		
	}

}

