package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Classe;
import schoolboard.metier.model.Professeur;


@Repository
@Transactional
public class ProfesseurDaoJpa implements ProfesseurDao {

	
	
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Professeur> findAll() {
		Query query = em.createQuery("from Professeur");
		return query.getResultList();
	}

	public Professeur find(Long id) {
		return em.find(Professeur.class, id);
	}

	public void create(Professeur obj) {
		em.persist(obj);

	}

	public Professeur update(Professeur obj) {
		return em.merge(obj);
	}

	public void delete(Professeur obj) {
		em.remove(em.merge(obj));

	}

	public void deleteById(Long id) {
		em.remove(em.find(Professeur.class, id));
		
	}

}
