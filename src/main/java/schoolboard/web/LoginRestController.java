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
//import com.fasterxml.jackson.databind.MapperFeature;

import schoolboard.dao.LoginDao;
import schoolboard.model.Login;
import schoolboard.model.Matiere;
import schoolboard.model.Utilisateur;


@RestController
public class LoginRestController {
	
	@Autowired
	private LoginDao logDao;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<List<Login>> list() {
		List<Login> liste = logDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Login>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Login>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Login login, UriComponentsBuilder uCB) {
		logDao.create(login);
		URI uri = uCB.path("/login/{id}").buildAndExpand(login.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
	public ResponseEntity<Login> find(@PathVariable("id") Long id) {
		Login log = logDao.find(id);
		if (log == null) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Login>(log, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/login/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Login log = logDao.find(id);
		if (log == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			logDao.delete(log);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.PUT)
	public ResponseEntity<Login> update(@RequestBody Login log) {
		Login tmp = logDao.find(log.getId());
		if (tmp == null) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setLogin(log.getLogin());
			tmp.setMotDePasse(log.getMotDePasse());
			tmp.setAdmin(log.isAdmin());
			tmp.setUser(log.getUser());
			logDao.update(tmp);
			return new ResponseEntity<Login>(tmp, HttpStatus.OK);
		}
	}

}
