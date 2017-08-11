package test.schoolboard;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import schoolboard.dao.LoginDao;
import schoolboard.model.Login;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJUnitSpring {
	public class AllTests {
		
		@Autowired
		private LoginDao loginDao;

		
		public void testLogin(){
			
			Login virginie = new Login ();
			
			loginDao.create(virginie);
			
			Login jpaFind = loginDao.find(virginie.getId());
			
			Assert.assertEquals("virginie", jpaFind.getNom());
			Assert.assertEquals("vir", jpaFind.getMotDePasse());
			Assert.assertEquals(true, jpaFind.getAdmin());
			
		}
		

	
		
		
	}

	
}
