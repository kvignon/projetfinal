package schoolboard.metier.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;



@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String rue;
	
	@Version
	private int version;
	
	
	
	
	@OneToOne
	@JoinColumn(name="id_Utilisateur_adresse", referencedColumnName="id")
	private Utilisateur user;
	
	
	@OneToOne
	@JoinColumn(name="id_Etablissement_adresse", referencedColumnName="id")
	private Etablissement etablissement;
	
	
	
	
	
	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "code_postal")
	private int codePostal;
	
	@Column
	private String ville;
	
	@Column
	private String pays;

	public Adresse() {
	}

	
	
	
	public Adresse(String rue, int version, Utilisateur user, Etablissement etablissement, int codePostal, String ville,
			String pays) {
		super();
		this.rue = rue;
		this.version = version;
		this.user = user;
		this.etablissement = etablissement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}


	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


}
