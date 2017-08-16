package schoolboard.metier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "classe", length = 50, unique = true)
	private String classe;
	
	@Version
	private int version;
	
	
	@OneToOne
	@JoinColumn(name="id_professeur_principal", referencedColumnName="id")
	private Professeur professeurPrincipal;
	
	@OneToMany(mappedBy="classe")
	private List<EmploiDuTemps> emp;
	

	public Professeur getProfesseurPrincipal() {
		return professeurPrincipal;
	}


	public void setProfesseurPrincipal(Professeur professeurPrincipal) {
		this.professeurPrincipal = professeurPrincipal;
	}


	public List<EmploiDuTemps> getEmp() {
		return emp;
	}


	public void setEmp(List<EmploiDuTemps> emp) {
		this.emp = emp;
	}


	public Classe() {
	}
	
	

	
	public Classe(String classe, int version, Professeur professeurPrincipal, List<EmploiDuTemps> emp) {
		super();
		this.classe = classe;
		this.version = version;
		this.professeurPrincipal = professeurPrincipal;
		this.emp = emp;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	

	
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
