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

import schoolboard.dao.ClasseDao;
import schoolboard.model.Classe;
import schoolboard.model.Professeur;



@RestController
public class ClasseRestController {
	
	@Autowired
	private ClasseDao classeDao;
	
	@RequestMapping(value = "/classe", method = RequestMethod.GET)
	public ResponseEntity<List<Classe>> list() {
		List<Classe> liste = classeDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Classe>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Classe>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/classe", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Classe classe, UriComponentsBuilder uCB) {
		classeDao.create(classe);
		URI uri = uCB.path("/classe/{id}").buildAndExpand(classe.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/classe/{id}", method = RequestMethod.GET)
	public ResponseEntity<Classe> find(@PathVariable("id") Long id) {
		Classe classe = classeDao.find(id);
		if (classe == null) {
			return new ResponseEntity<Classe>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Classe>(classe, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/classe/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Classe classe = classeDao.find(id);
		if (classe == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			classeDao.delete(classe);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/classe", method = RequestMethod.PUT)
	public ResponseEntity<Classe> update(@RequestBody Classe classe) {
		Classe tmp = classeDao.find(classe.getId());
		if (tmp == null) {
			return new ResponseEntity<Classe>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setClasse(classe.getClasse());

			classeDao.update(tmp);
			return new ResponseEntity<Classe>(tmp, HttpStatus.OK);
		}
	}


}
