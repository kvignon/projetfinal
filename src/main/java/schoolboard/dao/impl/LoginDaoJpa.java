package schoolboard.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import schoolboard.metier.dao.LoginDao;
import schoolboard.metier.model.Login;



@Repository
@Transactional
public class LoginDaoJpa implements LoginDao {

	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Login> findAll() {
		Query query = em.createQuery("from Login");
		return query.getResultList();
	}

	@Override
	public Login find(Long id) {
		return em.find(Login.class, id);
	}

	@Override
	public void create(Login obj) {
		em.persist(obj);
	}

	@Override
	public Login update(Login obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Login obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login find(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login checkLogin(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}


