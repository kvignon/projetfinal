package test.schoolboard;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import schoolboard.dao.FormationDao;
import schoolboard.dao.MatiereDao;
import schoolboard.model.Difficulte;
import schoolboard.model.Matiere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJUnitSpring {
	
	@Autowired
	private MatiereDao matiereDao;
	
	@Autowired
	private FormationDao formationDao;

	@Test
	public void testMatiere() {
		Matiere jpa = new Matiere("JPA", Difficulte.FACILE);

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
