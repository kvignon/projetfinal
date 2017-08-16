package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.model.Adresse;
import schoolboard.metier.model.Classe;
import schoolboard.dao.ClasseDao;



@Repository
@Transactional
public class ClasseDaoJpa implements ClasseDao {

	@PersistenceContext
	private EntityManager em;
	
	public ClasseDaoJpa() {
		super();
	}

	public ClasseDaoJpa(EntityManager em) {
		super();
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	public List<Classe> findAll() {
		Query query = em.createQuery("from Classe");
		return query.getResultList();
	}

	
	public Classe find(Long id) {
		return em.find(Classe.class, id);
	}

	
	public void create(Classe obj) {
		em.persist(obj);
	}

	
	public Classe update(Classe obj) {
		return em.merge(obj);
	}

	
	public void delete(Classe obj) {
		em.remove(em.merge(obj));
	}
	
	

	public void deleteById(Long id) {
		em.remove(em.find(Classe.class, id));
		
	}


}


