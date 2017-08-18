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

import schoolboard.dao.ProfesseurDao;
import schoolboard.model.Matiere;
import schoolboard.model.Professeur;

@RestController
public class ProfesseurRestContoller {
	
	@Autowired
	private ProfesseurDao profDao;
	
	
	@RequestMapping(value = "/professeur", method = RequestMethod.GET)
	public ResponseEntity<List<Professeur>> list() {
		List<Professeur> liste = profDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Professeur>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Professeur>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/professeur", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Professeur prof, UriComponentsBuilder uCB) {
		profDao.create(prof);
		URI uri = uCB.path("/professeur/{id}").buildAndExpand(prof.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/professeur/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professeur> find(@PathVariable("id") Long id) {
		Professeur prof = profDao.find(id);
		if (prof == null) {
			return new ResponseEntity<Professeur>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Professeur>(prof, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/professeur/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Professeur prof = profDao.find(id);
		if (prof == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			profDao.delete(prof);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/matiere", method = RequestMethod.PUT)
	public ResponseEntity<Professeur> update(@RequestBody Professeur prof) {
		Professeur tmp = profDao.find(prof.getId());
		if (tmp == null) {
			return new ResponseEntity<Professeur>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setAdresse(prof.getAdresse());
			tmp.setCivilite(prof.getCivilite());
			tmp.setClasse(prof.getClasse());
			tmp.setDateDeNaissance(prof.getDateDeNaissance());
			tmp.setEmp(prof.getEmp());
			tmp.setEnseigne(prof.getEnseigne());
			tmp.setNom(prof.getNom());
			tmp.setPrenom(prof.getPrenom());
			
			
			profDao.update(tmp);
			return new ResponseEntity<Professeur>(tmp, HttpStatus.OK);
		}
	}

}
