package SchoolBoard.school;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import schoolboard.dao.AdresseDao;
import schoolboard.dao.ClasseDao;
import schoolboard.dao.EmploiTempsDao;

import schoolboard.dao.EtablissementDao;
import schoolboard.dao.MatiereDao;
import schoolboard.dao.ProfesseurDao;
import schoolboard.dao.SalleDao;
import schoolboard.dao.UtilisateurDao;
import schoolboard.metier.model.Adresse;
import schoolboard.metier.model.Classe;
import schoolboard.metier.model.EmploiDuTemps;
import schoolboard.metier.model.EmploiTempsPk;
import schoolboard.metier.model.Etablissement;
import schoolboard.metier.model.Matiere;
import schoolboard.metier.model.Professeur;
import schoolboard.metier.model.Salle;
import schoolboard.metier.model.Utilisateur;


/**
 * Unit test for simple App.
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest
{
	
	@Autowired
	private AdresseDao adresseDao;
	
	@Autowired
	private ClasseDao classeDao;
	@Autowired
	private MatiereDao matiereDao;
	
	@Autowired
	private UtilisateurDao userDao;
	
	@Autowired
	private EtablissementDao etabDao;
	
	@Autowired
	private ProfesseurDao profDao;
	
	@Autowired
	private SalleDao salleDao;
	
	@Autowired
	private EmploiTempsDao empDao;
	
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public AppTest() {
	}


    /**
     * Rigourous Test :-)
     */
	@Test
    public void testApp()
    {
    	  Adresse adrClient = new Adresse();
  		adrClient.setRue("rue de la guerre");
  		adrClient.setCodePostal(75009);
  		adrClient.setPays("France");
  		adrClient.setVille("Paris");
  		
  		Classe classe = new Classe();
  		classe.setClasse("CM2");
  		
  		Utilisateur user = new Utilisateur();
  		user.setNom("Kassa");
  		user.setEmail("alo@gmail.com");
  		user.setAdresse(adrClient);
  		
  		
  		List<Utilisateur> userList = new ArrayList();
  		userList.add(user);
  		
  		Etablissement etab = new Etablissement();
  		etab.setNom("victor");
  		etab.setTelephone(1452l);
  		etab.setUser(userList);
  		user.setEtablissement(etab);
  		etab.setAdresse(adrClient);
  		
  		Matiere matiere = new Matiere();
  		Matiere matiere2 = new Matiere();
  		matiere.setNom("math");
  		matiere.setCouleur("rouge");
  		List<Matiere> listMat = new ArrayList();
  		listMat.add(matiere);
  		
  		
  	
  		
  		
  		Professeur prof = new Professeur();
  		prof.setNom("bois");
  		prof.setPrenom("dodo");
  		List<Professeur> listProf = new ArrayList();
  		listProf.add(prof);
  		
  		prof.setEnseigne(listMat);
  		matiere.setProfesseur(listProf);
  		
  		Salle salle = new Salle();
  		salle.setCapacite(30);
  		salle.setNomSalle("Salle01");
  		
  		
  		EmploiDuTemps emp = new EmploiDuTemps();
  		Date dateJour = new Date(4l);
  		Date date2 = new Date(45);
  		Instant instant = Instant.now();
		Date heudedeb = Date.from(instant);
  		Date heudefin = Date.from(instant);
  		emp.setHeureDeb(heudedeb);
  		emp.setHeureFin(heudefin);
  		emp.setDate(dateJour);
  		emp.setMatiere(matiere);
  		emp.setProfesseur(prof);
  		emp.setSalle(salle);
  		
		
  		
  		
  		
  		
  		
  		adresseDao.create(adrClient);
  		etabDao.create(etab);
  		userDao.create(user);
  		classeDao.create(classe);
  		salleDao.create(salle);
  		
  		matiereDao.create(matiere);
  		//matiereDao.create(matiere2);
  		//matiereDao.delete(matiere2);
  		profDao.create(prof);
  		matiere.setNom("physique");
  		matiereDao.update(matiere);
  		
  		EmploiTempsPk pk = new EmploiTempsPk(classe.getId(), matiere.getId(), prof.getId(), salle.getId());
  		emp.setEmploiTempsPk(pk);
  		empDao.create(emp);
  		
  		
  		
  		Utilisateur UserFind = userDao.find(1l);
  		Utilisateur userFindForAll;
  		List<Utilisateur> UserFindAll = userDao.findAll();
  		userFindForAll = UserFindAll.get(0);
  		System.out.println(userFindForAll.getNom());
  		Assert.assertEquals("Kassa",UserFind.getNom());
  		Assert.assertEquals("alo@gmail.com",UserFind.getEmail());
  		
  		//Assert.assertEquals("agmail.com",UserFind.getEmail());
  		
  		
  		
    }
}
