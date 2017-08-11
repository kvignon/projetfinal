package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.model.Salle;

@Repository
@Transactional
public class SalleDaoJpa implements SalleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Salle> findAll() {
		Query query = em.createQuery("from Salle");
		return query.getResultList();
	}

	@Override
	public Salle find(Long id) {
		return em.find(Salle.class, id);
	}

	@Override
	public void create(Salle obj) {
		em.persist(obj);
	}

	@Override
	public Salle update(Salle obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}

	

}
