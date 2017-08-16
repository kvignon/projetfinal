package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Utilisateur {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String motDePasse;
	
	@Column(name="Numero_de_telephone")
	private String numeroTel;
	
	@Column
	private String email;
	
	@Column
	private boolean admin;
	
	@OneToOne(mappedBy= "user")
	private Adresse adresse;
	
	@JoinColumn(name="id_etablissement", referencedColumnName="id")
	@ManyToOne
	private Etablissement etablissement;
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}




	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




	public Etablissement getEtablissement() {
		return etablissement;
	}




	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}




	public Utilisateur(String nom, String prenom, String motDePasse, String numeroTel, String email, boolean admin,
			Adresse adresse, Etablissement etablissement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.numeroTel = numeroTel;
		this.email = email;
		this.admin = admin;
		this.adresse = adresse;
		this.etablissement = etablissement;
		
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getMotDePasse() {
		return motDePasse;
	}




	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}






	@Version
	private int version;

	public boolean isAdmin() {
		return admin;
	}




	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	@Autowired
	public Utilisateur() {
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

	
	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
