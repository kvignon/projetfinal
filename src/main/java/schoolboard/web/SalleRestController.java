package schoolboard.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import schoolboard.dao.SalleDao;
import schoolboard.model.Salle;



@RestController
public class SalleRestController {
	
	@Autowired
	SalleDao salleDao;
	
	@RequestMapping(value = "/salle", method = RequestMethod.GET)
	public ResponseEntity<List<Salle>> list() {
		List<Salle> liste = salleDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Salle>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Salle>>(liste, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/salle", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Salle salle, UriComponentsBuilder uCB) {
		salleDao.create(salle);
		URI uri = uCB.path("/classe/{id}").buildAndExpand(salle.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/salle/{id}", method = RequestMethod.GET)
	public ResponseEntity<Salle> find(@PathVariable("id") Long id) {
		Salle salle = salleDao.find(id);
		if (salle == null) {
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Salle>(salle, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/salle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Salle salle = salleDao.find(id);
		if (salle == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			salleDao.delete(salle);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/salle", method = RequestMethod.PUT)
	public ResponseEntity<Salle> update(@RequestBody Salle salle) {
		Salle tmp = salleDao.find(salle.getId());
		if (tmp == null) {
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setCapacite(salle.getCapacite());
			tmp.setEmp(salle.getEmp());
			tmp.setMatiereExclu(salle.getMatiereExclu());
			tmp.setNomSalle(salle.getNomSalle());
			
			

			salleDao.update(tmp);
			return new ResponseEntity<Salle>(tmp, HttpStatus.OK);
		}
	}

}
