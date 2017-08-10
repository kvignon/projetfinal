package schoolboard.model;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "room")
public class Salle {

	private SallePK id;
	private int capacite;
	private int version;

	public Salle() {
	}

	public Salle(int etage, String nom) {
		this.id = new SallePK(etage, nom);
	}

	@EmbeddedId
	public SallePK getId() {
		return id;
	}

	public void setId(SallePK id) {
		this.id = id;
	}

	@Basic(fetch = FetchType.LAZY)
	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
