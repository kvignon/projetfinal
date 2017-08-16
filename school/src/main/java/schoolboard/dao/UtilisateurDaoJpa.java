package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Salle;
import schoolboard.metier.model.Utilisateur;
import schoolboard.dao.UtilisateurDao;



@Repository
@Transactional
public class UtilisateurDaoJpa implements UtilisateurDao {

	
	
	public UtilisateurDaoJpa() {
		super();
	}


	public UtilisateurDaoJpa(EntityManager entityManagerFactory) {
		super();
		this.entityManagerFactory = entityManagerFactory;
	}

	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	
	
	public EntityManager getEm() {
		return entityManagerFactory;
	}

	
	public void setEm(EntityManager em) {
		this.entityManagerFactory = em;
	}


	public List<Utilisateur> findAll() {
		Query query = entityManagerFactory.createQuery("from Utilisateur");
		return query.getResultList();
	}

	
	public Utilisateur find(Long id) {
		return entityManagerFactory.find(Utilisateur.class, id);
	}

	
	public void create(Utilisateur obj) {
		entityManagerFactory.persist(obj);
	}

	
	public Utilisateur update(Utilisateur obj) {
		return entityManagerFactory.merge(obj);
	}

	
	public void delete(Utilisateur obj) {
		entityManagerFactory.remove(entityManagerFactory.merge(obj));
	}


	public void deleteById(Long id) {
		entityManagerFactory.remove(entityManagerFactory.find(Utilisateur.class, id));
		
	}

}

