package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.dao.EtablissementDao;
import schoolboard.model.Etablissement;


@Repository
@Transactional
public class EtablissementDaoJpa implements EtablissementDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Etablissement> findAll() {
		Query query = em.createQuery("from Etablissement");
		return query.getResultList();
	}

	@Override
	public Etablissement find(Long id) {
		return em.find(Etablissement.class, id);
	}

	@Override
	public void create(Etablissement obj) {
		em.persist(obj);
	}

	@Override
	public Etablissement update(Etablissement obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Etablissement obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

