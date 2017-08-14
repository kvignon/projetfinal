package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.dao.AdresseDao;
import schoolboard.model.Adresse;


@Repository
@Transactional
public class AdresseDaoJpa implements AdresseDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Adresse> findAll() {
		Query query = em.createQuery("from Adresse");
		return query.getResultList();
	}

	@Override
	public Adresse find(Long id) {
		return em.find(Adresse.class, id);
	}

	@Override
	public void create(Adresse obj) {
		em.persist(obj);
	}

	@Override
	public Adresse update(Adresse obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Adresse obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
