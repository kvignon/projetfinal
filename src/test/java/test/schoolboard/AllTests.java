package test.schoolboard;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import schoolboard.dao.LoginDao;
import schoolboard.model.Login;

@RunWith(Suite.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class AllTests {
	
	//@Autowired
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
