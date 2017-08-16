package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.model.Matiere;

@Repository
@Transactional
public class MatiereDaoJpa implements MatiereDao {

	@PersistenceContext
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// m�thode .createEntityManager()
	private EntityManager em;

	@Override
	public List<Matiere> findAll() {
		//Query query = em.createQuery("from Matiere m left join fetch m.formations f left join fetch f.formateur");
		Query query = em.createQuery("from Matiere m ");
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

}
