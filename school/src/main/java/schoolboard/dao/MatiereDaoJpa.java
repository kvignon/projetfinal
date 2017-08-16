package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Classe;
import schoolboard.metier.model.Matiere;


@Repository
@Transactional
public class MatiereDaoJpa implements MatiereDao {

	
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// m�thode .createEntityManager()
	
	@PersistenceContext
	private EntityManager em;

	public MatiereDaoJpa() {
		super();
	}

	public MatiereDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	public List<Matiere> findAll() {
		Query query = em.createQuery("from Matiere");
		return query.getResultList();
	}

	
	public Matiere find(Long id) {
		return em.find(Matiere.class, id);
	}

	
	public void create(Matiere obj) {
		em.persist(obj);
	}

	
	public Matiere update(Matiere obj) {
		return em.merge(obj);
	}

	
	public void delete(Matiere obj) {
		em.remove(em.merge(obj));
	}

	public void deleteById(Long id) {
		em.remove(em.find(Matiere.class, id));
		
	}

}
