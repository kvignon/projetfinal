package schoolboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
public class Matiere {
	private Long id;
	private String nom;
	// private List<Formation> formations = new ArrayList<>();
	private int version;

	public Matiere() {
		super();
	}

	

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	@Size(min=1, message="{matiere.nom.error}")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

	// @ManyToMany
	// @JoinTable(name="subject_training",
	// joinColumns=@JoinColumn(name="subject_id"),
	// inverseJoinColumns=@JoinColumn(name="training_id"))
	// public List<Formation> getFormations() {
	// return formations;
	// }
	//
	// public void setFormations(List<Formation> formations) {
	// this.formations = formations;
	// }
	//
	// public void addFormation(Formation formation) {
	// this.formations.add(formation);
	// }

}
