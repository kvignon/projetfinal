package schoolboard.metier.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emploidutemps")
public class EmploiDuTemps {
	

	private Long id;
	private Utilisateur utilisateur;
	private Classe classe;
	private Matiere matiere;
	private Horaire horaire;
	private Salle salle;
	
	
	
	public EmploiDuTemps(Utilisateur utilisateur, Classe classe, Matiere matiere, Horaire horaire,
			Salle salle) {
		super();
		
		this.utilisateur = utilisateur;
		this.classe = classe;
		this.matiere = matiere;
		this.horaire = horaire;
		this.salle = salle;
	}
	
	public EmploiDuTemps() {
		super();
	}
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "edt")	
	@JoinColumn(name="id_utilisateur", referencedColumnName="id")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@OneToOne(mappedBy = "edt")	
	@JoinColumn(name="id_classe", referencedColumnName="id" )
	public Classe getClasse() {
		return classe;
	}	

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	@OneToOne(mappedBy="edt")
	@JoinColumn(name="id_matiere", referencedColumnName="id")
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@OneToOne(mappedBy = "edt")
	@JoinColumn(name="id_horaire", referencedColumnName="id")
	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	@OneToOne(mappedBy = "edt")
	@JoinColumn(name="id_salle", referencedColumnName="id")
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}
