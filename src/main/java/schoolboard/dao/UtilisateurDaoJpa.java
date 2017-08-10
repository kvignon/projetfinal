package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.model.Utilisateur;

@Repository
@Transactional
public class UtilisateurDaoJpa implements UtilisateurDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Utilisateur> findAll() {
		Query query = em.createQuery("from Utilisateur");
		return query.getResultList();
	}

	@Override
	public Utilisateur find(Long id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public void create(Utilisateur obj) {
		em.persist(obj);
	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Utilisateur obj) {
		em.remove(em.merge(obj));
	}

}

