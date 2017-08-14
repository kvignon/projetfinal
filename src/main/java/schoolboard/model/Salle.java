package schoolboard.metier.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "room")
public class Salle {

	private Long id;
	private EmploiDuTemps edt;
	private int capacite;
	private int version;
	private MatiereExclues matiereExclues;
	private String nomSalle;

	public Salle(Long id, int capacite, int version, MatiereExclues matiereExclues) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.version = version;
		this.matiereExclues = matiereExclues;
	}
	

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	public EmploiDuTemps getEdt() {
		return edt;
	}

	public void setEdt(EmploiDuTemps edt) {
		this.edt = edt;
	}

	@Column(name="capacity")
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

	@Column(name="Matiere_Exclues")
	@Enumerated(EnumType.STRING)
	public MatiereExclues getMatiereExclues() {
		return matiereExclues;
	}
	
	public void setMatiereExclues(MatiereExclues matiereExclues) {
		this.matiereExclues = matiereExclues;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	
	
}
