package schoolboard.metier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Classe")
public class Classe {

	private Long id;
	private String classe;
	private int version;
	private Utilisateur client;
	private EmploiDuTemps edt;

	public Classe() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Column(name = "classe", length = 50, unique = true)
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	@OneToOne(mappedBy = "classe")
	@JoinColumn(name="id_utilisateur", referencedColumnName="id")
	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@OneToOne
	public EmploiDuTemps getEdt() {
		return edt;
	}

	public void setEdt(EmploiDuTemps edt) {
		this.edt = edt;
	}
	
}
