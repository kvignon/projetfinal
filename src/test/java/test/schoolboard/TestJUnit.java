package test.schoolboard;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import schoolboard.dao.MatiereDao;
import schoolboard.model.Matiere;

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
	public void testMatiere() {
		MatiereDao matiereDao = context.getBean(MatiereDao.class);

		Matiere jpa = new Matiere("JPA");

		matiereDao.create(jpa);

		Matiere jpaFind = matiereDao.find(jpa.getId());

		Assert.assertEquals("JPA", jpaFind.getNom());
		Assert.assertEquals(Difficulte.FACILE, jpaFind.getDifficulte());
		
		jpaFind.setNom("JPA/HIBERNATE");
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
		
		Assert.assertEquals(1, matieres.size() - matieresPostDelete.size());
	}

	@Test
	public void testFormation() {
		System.out.println("test formation");
	}
}
