package schoolboard.metier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "matiere_client")
public class MatiereUtilisateur {

	private Long id;
	private Matiere matiere;
	private Utilisateur client;
	private int version;

	public MatiereUtilisateur() {
	}

	public MatiereUtilisateur(Matiere matiere, Utilisateur client) {
		super();
		this.matiere = matiere;
		this.client = client;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "matiere_id")
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@ManyToOne
	@JoinColumn(name = "client_id")
	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}

}
