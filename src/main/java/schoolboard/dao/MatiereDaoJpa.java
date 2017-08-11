package vol.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vol.metier.dao.MatiereDao;
import vol.metier.model.Matiere;



@Repository
@Transactional
public class MatiereDaoJpa implements MatiereDao {

	@PersistenceContext
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// méthode .createEntityManager()
	private EntityManager em;

	@Override
	public List<Matiere> findAll() {
		Query query = em.createQuery("from Matiere");
		return query.getResultList();
	}

	@Override
	public Matiere find(Long id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public void create(Matiere obj) {
		em.persist(obj);
	}

	@Override
	public Matiere update(Matiere obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Matiere obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
