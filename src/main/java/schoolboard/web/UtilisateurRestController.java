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

import schoolboard.dao.UtilisateurDao;
import schoolboard.model.Login;
import schoolboard.model.Utilisateur;


@RestController
public class UtilisateurRestController {
	
	
	@Autowired
	private UtilisateurDao userDao;
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
	public ResponseEntity<List<Utilisateur>> list() {
		List<Utilisateur> liste = userDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Utilisateur>>(liste, HttpStatus.OK);
		}
	}
	
	
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Utilisateur user, UriComponentsBuilder uCB) {
		userDao.create(user);
		URI uri = uCB.path("/utilisateur/{id}").buildAndExpand(user.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	public ResponseEntity<Utilisateur> find(@PathVariable("id") Long id) {
		Utilisateur user = userDao.find(id);
		if (user == null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Utilisateur user = userDao.find(id);
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userDao.delete(user);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
	public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur user) {
		Utilisateur tmp = userDao.find(user.getId());
		if (tmp == null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setAdresse(user.getAdresse());
			tmp.setCivilite(user.getCivilite());
			tmp.setEmail(user.getEmail());
			tmp.setEtablissement(user.getEtablissement());
			tmp.setLogin(user.getLogin());
			tmp.setNom(user.getNom());
			tmp.setNumeroTel(user.getNumeroTel());
			tmp.setPrenom(user.getPrenom());
			
			userDao.update(tmp);
			return new ResponseEntity<Utilisateur>(tmp, HttpStatus.OK);
		}
	}

}
