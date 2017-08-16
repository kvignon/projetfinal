package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Matiere {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nom;
	
	@Version
	private int version;
	
	@Column
	private String couleur;
	
	@ManyToMany(mappedBy="Enseigne")
	private List<Professeur> professeur;
	
	
	@OneToMany(mappedBy="matiere")
	private List<EmploiDuTemps> emp;
	
	
	
	
	public List<Professeur> getProfesseur() {
		return professeur;
	}

	public void setProfesseur(List<Professeur> professeur) {
		this.professeur = professeur;
	}

	public List<EmploiDuTemps> getEmp() {
		return emp;
	}

	public void setEmp(List<EmploiDuTemps> emp) {
		this.emp = emp;
	}


	public Matiere(String nom, int version, String couleur, List<Professeur> professeur, List<EmploiDuTemps> emp) {
		super();
		this.nom = nom;
		this.version = version;
		this.couleur = couleur;
		this.professeur = professeur;
		this.emp = emp;
	}

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	

	
	
}
