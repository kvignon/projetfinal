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

import schoolboard.dao.MatiereDao;
import schoolboard.model.EmploiDuTemps;
import schoolboard.model.Matiere;
import schoolboard.model.Professeur;

@RestController
public class MatiereRestController {

	@Autowired
	private MatiereDao matiereDao;

	@RequestMapping(value = "/matiere", method = RequestMethod.GET)
	public ResponseEntity<List<Matiere>> list() {
		List<Matiere> liste = matiereDao.findAll();
		if (liste == null) {
			return new ResponseEntity<List<Matiere>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Matiere>>(liste, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/matiere", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Matiere matiere, UriComponentsBuilder uCB) {
		matiereDao.create(matiere);
		URI uri = uCB.path("/matiere/{id}").buildAndExpand(matiere.getId()).toUri();
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/matiere/{id}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> find(@PathVariable("id") Long id) {
		Matiere matiere = matiereDao.find(id);
		if (matiere == null) {
			return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Matiere>(matiere, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/matiere/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Matiere matiere = matiereDao.find(id);
		if (matiere == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			matiereDao.delete(matiere);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/matiere", method = RequestMethod.PUT)
	public ResponseEntity<Matiere> update(@RequestBody Matiere matiere) {
		Matiere tmp = matiereDao.find(matiere.getId());
		if (tmp == null) {
			return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
		} else {
			
			tmp.setNom(matiere.getNom());
			tmp.setCouleur(matiere.getCouleur());
			tmp.setProfesseur(matiere.getProfesseur());
			tmp.setEmp(matiere.getEmp());
			
			matiereDao.update(tmp);
			return new ResponseEntity<Matiere>(tmp, HttpStatus.OK);
		}
	}
}
