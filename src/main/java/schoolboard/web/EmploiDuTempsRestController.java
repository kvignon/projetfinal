package schoolboard.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import schoolboard.dao.EmploiTempsDao;
import schoolboard.metier.model.Classe;
import schoolboard.metier.model.EmploiDuTemps;
import schoolboard.metier.model.EmploiTempsPk;



@RestController
public class EmploiDuTempsRestController {
	
	@Autowired
	private EmploiTempsDao empDao;
	
	@RequestMapping(value = "/EmploiDuTemps", method = RequestMethod.GET)
	public ResponseEntity<List<EmploiDuTemps>> list() {
		List<EmploiDuTemps> liste = empDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<EmploiDuTemps>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<EmploiDuTemps>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/EmploiDuTemps", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody EmploiDuTemps emp, UriComponentsBuilder uCB) {
		empDao.create(emp);
		URI uri = uCB.path("/EmploiDuTemps/{id}").buildAndExpand(emp.getEmploiTempsPk()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/EmploiDuTemps/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmploiDuTemps> find(@PathVariable("id") EmploiTempsPk id) {
		EmploiDuTemps emp = empDao.find(id);
		if (emp == null) {
			return new ResponseEntity<EmploiDuTemps>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EmploiDuTemps>(emp, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/EmploiDuTemps/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") EmploiTempsPk id) {
		EmploiDuTemps emp = empDao.find(id);
		if (emp == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			empDao.delete(emp);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/EmploiDuTemps", method = RequestMethod.PUT)
	public ResponseEntity<EmploiDuTemps> update(@RequestBody EmploiDuTemps emp) {
		EmploiDuTemps tmp = empDao.find(emp.getEmploiTempsPk());
		if (tmp == null) {
			return new ResponseEntity<EmploiDuTemps>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setClasse(emp.getClasse());
			tmp.setMatiere(emp.getMatiere());
			tmp.setProfesseur(emp.getProfesseur());
			tmp.setSalle(emp.getSalle());
			tmp.setDate(emp.getDate());
			tmp.setHeureDeb(emp.getHeureDeb());
			tmp.setHeureFin(emp.getHeureFin());

			empDao.update(tmp);
			return new ResponseEntity<EmploiDuTemps>(tmp, HttpStatus.OK);
		}
	}

}
