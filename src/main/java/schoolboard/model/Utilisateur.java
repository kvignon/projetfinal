package schoolboard.model;

import java.util.Date;

public class Utilisateur {

	private Long id;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Civilite civilite;
	

	public Long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}



	public Civilite getCivilite() {
		return civilite;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}


	public Utilisateur() {
		super();
}
}