package schoolboard.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.dao.MatiereUtilisateurDao;
import schoolboard.metier.model.MatiereUtilisateur;

@Transactional
@Repository
public class MatiereUtilisateurDaoJpa implements MatiereUtilisateurDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Override
	public MatiereUtilisateur find(Long id) {
		return em.find(MatiereUtilisateur.class, id);
	}

	@Override
	public List<MatiereUtilisateur> findAll() {
		Query query = em.createQuery("from MatiereUtilisateur av");
		return query.getResultList();
	}

	@Override
	public void create(MatiereUtilisateur matiereUtilisateur) {
		em.persist(matiereUtilisateur);

	}

	@Override
	public MatiereUtilisateur update(MatiereUtilisateur matiereUtilisateur) {
		return em.merge(matiereUtilisateur);
	}

	@Override
	public void delete(MatiereUtilisateur matiereUtilisateur) {
		em.remove(matiereUtilisateur);

	}

	@Override
	public void delete(Long id) {
		MatiereUtilisateur matiereUtilisateur = find(id);
		em.remove(matiereUtilisateur);

	}

}
