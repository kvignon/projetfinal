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
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Utilisateur {

	private Long id;
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;
	private Login login;
	private Classe classe;
	private List<MatiereUtilisateur> matieres;
	private Civilite civilite;
	private EmploiDuTemps edt;
		
	@OneToOne
	public Classe getClasse() {
		return classe;
	}
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	public List<MatiereUtilisateur> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<MatiereUtilisateur> matieres) {
		this.matieres = matieres;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	private Adresse adresse;
	private Etablissement etablissement;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etablissement_id")
	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	private int version;

	public Utilisateur() {
	}

	public Utilisateur(String nom) {
		this.nom = nom;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nom", length = 100)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "numerotel", length = 15)
	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	@Column(name = "numerofax", length = 15)
	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	@Column(name = "email", length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "login_id")
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Enumerated(EnumType.STRING)
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	@OneToOne
	public EmploiDuTemps getEdt() {
		return edt;
	}

	public void setEdt(EmploiDuTemps edt) {
		this.edt = edt;
	}
	
}
