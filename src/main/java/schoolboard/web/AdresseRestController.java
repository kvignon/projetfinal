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

import schoolboard.dao.AdresseDao;
import schoolboard.model.Adresse;

@RestController
public class AdresseRestController {
	
	@Autowired
	private AdresseDao adresseDao;
	
	@RequestMapping(value = "/adresse", method = RequestMethod.GET)
	public ResponseEntity<List<Adresse>> list() {
		List<Adresse> liste = adresseDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Adresse>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Adresse>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/adresse", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Adresse adresse, UriComponentsBuilder uCB) {
		adresseDao.create(adresse);
		URI uri = uCB.path("/adresse/{id}").buildAndExpand(adresse.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/adresse/{id}", method = RequestMethod.GET)
	public ResponseEntity<Adresse> find(@PathVariable("id") Long id) {
		Adresse adresse = adresseDao.find(id);
		if (adresse == null) {
			return new ResponseEntity<Adresse>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/adresse/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Adresse adresse = adresseDao.find(id);
		if (adresse == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			adresseDao.delete(adresse);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/adresse", method = RequestMethod.PUT)
	public ResponseEntity<Adresse> update(@RequestBody Adresse adresse) {
		Adresse tmp = adresseDao.find(adresse.getId());
		if (tmp == null) {
			return new ResponseEntity<Adresse>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setRue(adresse.getRue()+" "+adresse.getCodePostal()+" "+adresse.getPays());
			adresseDao.update(tmp);
			return new ResponseEntity<Adresse>(tmp, HttpStatus.OK);
		}
	}

}
