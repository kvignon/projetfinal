package test.schoolboard;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import schoolboard.dao.LoginDao;
import schoolboard.model.Login;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJUnit {
	
	private static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass
	public static void close() {
		context.close();
	}

	@Test
	public void testLogin() {
		LoginDao loginDao = context.getBean(LoginDao.class);
		
		Login virginie = new Login();
		
		virginie.setNom("Virginie");
		virginie.setMotDePasse("vi");
		virginie.setAdmin(true);
		
		loginDao.create(virginie);

		Login jpaFind = loginDao.find(virginie.getId());
		
		/*Assert.assertEquals("virginie", jpaFind.getNom());
		Assert.assertEquals("vir", jpaFind.getMotDePasse());
		Assert.assertEquals(true, jpaFind.getAdmin());*/
		
		/*jpaFind.setNom("JPA/HIBERNATE");
		jpaFind.setDifficulte(Difficulte.IMPOSSIBLE);
		
		Matiere jpaUpdate = matiereDao.update(jpaFind);
		
		jpaFind = matiereDao.find(jpaUpdate.getId());
		
		Assert.assertEquals("JPA/HIBERNATE", jpaFind.getNom());
		Assert.assertEquals(Difficulte.IMPOSSIBLE, jpaFind.getDifficulte());
		
		List<Matiere> matieres = matiereDao.findAll();
		
		matiereDao.delete(jpaFind);

		jpaFind = matiereDao.find(jpaFind.getId());
		
		Assert.assertNull(jpaFind);
		
		List<Matiere> matieresPostDelete = matiereDao.findAll();
		
		Assert.assertEquals(1, matieres.size() - matieresPostDelete.size());*/
	}


}
