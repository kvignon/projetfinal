package schoolboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="login")
public class Login {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String motDePasse;
	private Boolean admin;
	
@Autowired
	public Login() {
		
}


	public Long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public Boolean getAdmin() {
		return admin;
	}

	@Column
	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Column
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}