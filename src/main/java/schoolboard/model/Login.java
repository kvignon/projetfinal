package schoolboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Login")
public class Login {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String motDePasse;
	private Boolean admin;
	private int version;

	
	
	public Login(String nom, String motDePasse, Boolean admin) {
		//super();
		this.nom =nom;
		this.motDePasse = motDePasse;
		this.admin = admin ;


}
	
	@Autowired
	public Login() {
		


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


	public String getMotDePasse() {
		return motDePasse;
	}
	@Column
	public void setLogin(String nom) {
		this.nom = nom;
	}


	public Boolean getAdmin() {
		return admin;
	}
	@Column
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Column
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Version
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}

	
}