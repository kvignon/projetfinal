package schoolboard.metier.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Salle_de_cours")
public class Salle {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="capacity")
	private int capacite;
	
	@Version
	private int version;
	
	@Column(name="Nom_Salle")
	private String nomSalle;
	
	@Column(name="Matiere_exclues")
	@Enumerated(EnumType.STRING)
	private MatiereExclues matiereExclu;
	
	@OneToMany(mappedBy="salle")
	private List<EmploiDuTemps> emp;

	

	public List<EmploiDuTemps> getEmp() {
		return emp;
	}





	public void setEmp(List<EmploiDuTemps> emp) {
		this.emp = emp;
	}





	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}








	public Salle(int capacite, int version, String nomSalle, MatiereExclues matiereExclu, List<EmploiDuTemps> emp) {
		super();
		this.capacite = capacite;
		this.version = version;
		this.nomSalle = nomSalle;
		this.matiereExclu = matiereExclu;
		this.emp = emp;
	}





	public MatiereExclues getMatiereExclu() {
		return matiereExclu;
	}





	public void setMatiereExclu(MatiereExclues matiereExclu) {
		this.matiereExclu = matiereExclu;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	



	
	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	
	
}
