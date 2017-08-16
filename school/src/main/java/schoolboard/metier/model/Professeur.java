package schoolboard.metier.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
public class Professeur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column(name="Date_de_naissance")
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	
	@OneToOne(mappedBy="professeurPrincipal")
	private Classe classe;
	
	@ManyToMany
	@JoinTable(name="prof_matiere",
	joinColumns= @JoinColumn(name="pl_matiere_id", referencedColumnName="id"), inverseJoinColumns= @JoinColumn(name="pl_prof_id", referencedColumnName="id"))
	private List<Matiere> Enseigne;
	
	@OneToMany(mappedBy="professeur")
	private List<EmploiDuTemps> emp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Matiere> getEnseigne() {
		return Enseigne;
	}

	public void setEnseigne(List<Matiere> enseigne) {
		Enseigne = enseigne;
	}

	public List<EmploiDuTemps> getEmp() {
		return emp;
	}

	public void setEmp(List<EmploiDuTemps> emp) {
		this.emp = emp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
	public Professeur(String nom, String prenom, Date dateDeNaissance, Classe classe, List<Matiere> enseigne,
			List<EmploiDuTemps> emp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.classe = classe;
		Enseigne = enseigne;
		this.emp = emp;
	}

	public Professeur() {
		super();
	}
	
	
	
	

}
