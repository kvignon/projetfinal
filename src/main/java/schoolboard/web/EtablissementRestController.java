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

import schoolboard.dao.EtablissementDao;
import schoolboard.metier.model.Classe;
import schoolboard.metier.model.Etablissement;


@RestController
public class EtablissementRestController {
	
	@Autowired
	private EtablissementDao etablissementDao;
	
	@RequestMapping(value = "/etablissement", method = RequestMethod.GET)
	public ResponseEntity<List<Etablissement>> list() {
		List<Etablissement> liste = etablissementDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Etablissement>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Etablissement>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/etablissement", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Etablissement etablissement, UriComponentsBuilder uCB) {
		etablissementDao.create(etablissement);
		URI uri = uCB.path("/etablissement/{id}").buildAndExpand(etablissement.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/etablissement/{id}", method = RequestMethod.GET)
	public ResponseEntity<Etablissement> find(@PathVariable("id") Long id) {
		Etablissement etablissement = etablissementDao.find(id);
		if (etablissement == null) {
			return new ResponseEntity<Etablissement>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Etablissement>(etablissement, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/etablissement/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Etablissement etablissement = etablissementDao.find(id);
		if (etablissement == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			etablissementDao.delete(etablissement);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/etablissement", method = RequestMethod.PUT)
	public ResponseEntity<Etablissement> update(@RequestBody Etablissement etablissement) {
		Etablissement tmp = etablissementDao.find(etablissement.getId());
		if (tmp == null) {
			return new ResponseEntity<Etablissement>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setNom(etablissement.getNom());
			tmp.setAdresse(etablissement.getAdresse());
			tmp.setLogo(etablissement.getLogo());
			tmp.setTelephone(etablissement.getTelephone());
			tmp.setUser(etablissement.getUser());
			tmp.setTypeEtab(etablissement.getTypeEtab());
			

			etablissementDao.update(tmp);
			return new ResponseEntity<Etablissement>(tmp, HttpStatus.OK);
		}
	}

}
