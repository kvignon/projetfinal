package schoolboard.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.dao.UtilisateurDao;
import schoolboard.metier.dao.MatiereUtilisateurDao;
import schoolboard.metier.model.MatiereUtilisateur;
import schoolboard.metier.model.Utilisateur;


@Transactional
@Repository
public class UtilisateurDaoJpa implements UtilisateurDao {

	@PersistenceContext // annotation jpa qui injecte automatiquement l'entity
						// manager
	private EntityManager em;

	@Autowired
	private MatiereUtilisateurDao matiereUtilisateurDao;

	@Override
	public Utilisateur find(Long id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		Query query = em.createQuery("from utilisateur c left outer join fetch c.login");
		return query.getResultList();
	}

	@Override
	public void create(Utilisateur utilisateur) {
		em.persist(utilisateur);
	}

	// un objet récupéré de la base est déjà managé donc les modif se font
	// automatiquement pas besoin d'update
	// on utilise update pour merger objet
	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		return em.merge(utilisateur);

	}

	@Override
	public void delete(Utilisateur utilisateur) {
		for (MatiereUtilisateur resa : utilisateur.getMatieres()) {
			matiereUtilisateurDao.delete(resa);
		}
		em.remove(utilisateur.getLogin());
		em.remove(utilisateur);

	}

	@Override
	public void delete(Long id) {
		Utilisateur utilisateur = find(id);
		for (MatiereUtilisateur resa : utilisateur.getMatieres()) {
			matiereUtilisateurDao.delete(resa);
		}
		em.remove(utilisateur.getLogin());
		em.remove(utilisateur);

	}

}
