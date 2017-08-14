package schoolboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.dao.MatiereClientDao;
import schoolboard.model.MatiereClient;

@Transactional
@Repository
public class MatiereClientDaoJpa implements MatiereClientDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Override
	public MatiereClient find(Long id) {
		return em.find(MatiereClient.class, id);
	}

	@Override
	public List<MatiereClient> findAll() {
		Query query = em.createQuery("from MatiereClient av");
		return query.getResultList();
	}

	@Override
	public void create(MatiereClient villeAeroport) {
		em.persist(villeAeroport);

	}

	@Override
	public MatiereClient update(MatiereClient villeAeroport) {
		return em.merge(villeAeroport);
	}

	@Override
	public void delete(MatiereClient villeAeroport) {
		em.remove(villeAeroport);

	}

	@Override
	public void delete(Long id) {
		MatiereClient villeAeroport = find(id);
		em.remove(villeAeroport);

	}

}
