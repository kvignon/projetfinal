package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Etablissement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom", length = 100)
	private String nom;
	
	@Version
	private int version;
	
	@Column(name="type_Etablissement")
	@Enumerated(EnumType.STRING)
	private TypeEtablissement typeEtab;
	
	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public List<Utilisateur> getUser() {
		return user;
	}



	public void setUser(List<Utilisateur> user) {
		this.user = user;
	}

	@Column
	private Long telephone;
	
	@Column
	private String logo;
	
	
	
	@OneToOne(mappedBy="etablissement")
	private Adresse adresse;
	
	@OneToMany(mappedBy="etablissement")
	private List<Utilisateur> user;
	
	

	public Etablissement() {
	}
	
	

	public Etablissement(String nom, int version, TypeEtablissement typeEtab, Long telephone, String logo,
			Adresse adresse, List<Utilisateur> user) {
		super();
		this.nom = nom;
		this.version = version;
		this.typeEtab = typeEtab;
		this.telephone = telephone;
		this.logo = logo;
		this.adresse = adresse;
		this.user = user;
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


	
	public TypeEtablissement getTypeEtab() {
		return typeEtab;
	}



	public void setTypeEtab(TypeEtablissement typeEtab) {
		this.typeEtab = typeEtab;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}


	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
