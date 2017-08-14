package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Matiere {

	private Long id;
	private String nom;
	private List<MatiereUtilisateur> clients;
	private int version;
	private String couleur;
	private EmploiDuTemps edt;
	
	public Matiere(String nom,String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Nom", length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "matiere")
	public List<MatiereUtilisateur> getClients() {
		return clients;
	}

	public void setClients(List<MatiereUtilisateur> clients) {
		this.clients = clients;
	}

	@Version
	@Column(name = "Version")
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
	
	@OneToOne
	public EmploiDuTemps getEdt() {
		return edt;
	}

	public void setEdt(EmploiDuTemps edt) {
		this.edt = edt;
	}
	
	
	
}
