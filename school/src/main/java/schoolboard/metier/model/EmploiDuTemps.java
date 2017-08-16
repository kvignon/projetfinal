package schoolboard.metier.model;

import java.sql.Time;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Emploidutemps")
public class EmploiDuTemps {
	

	@EmbeddedId
	protected EmploiTempsPk emploiTempsPk;
	
	@Column(name="DateDuCours")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="HeureDeDebutCours")
	@Temporal(TemporalType.TIME)
	private Date heureDeb;
	
	@Column(name="HeureDeFinCours")
	@Temporal(TemporalType.TIME)
	private Date heureFin;

	@JoinColumn(name="id_professeur", referencedColumnName="id", insertable = false, updatable = false)
	@ManyToOne(optional=false)
	private Professeur professeur;
	
	
	@JoinColumn(name="id_classe", referencedColumnName="id", insertable = false, updatable = false)
	@ManyToOne(optional=false)
	private Classe classe;
	
	
	@JoinColumn(name="id_salle", referencedColumnName="id", insertable = false, updatable = false)
	@ManyToOne(optional=false)
	private Salle salle;
	
	
	@JoinColumn(name="id_matiere", referencedColumnName="id", insertable = false, updatable = false)
	@ManyToOne(optional=false)
	private Matiere matiere;
	
	
	
	public EmploiDuTemps(EmploiTempsPk emploiTempsPk) {
		super();
		this.emploiTempsPk = emploiTempsPk;
	}
	
	

	public EmploiDuTemps(Date date, Date heureDeb, Date heureFin, Professeur professeur, Classe classe, Salle salle,
			Matiere matiere) {
		super();
		this.date = date;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.professeur = professeur;
		this.classe = classe;
		this.salle = salle;
		this.matiere = matiere;
	}
	
	



	public EmploiDuTemps() {
		super();
	}



	public EmploiTempsPk getEmploiTempsPk() {
		return emploiTempsPk;
	}



	public void setEmploiTempsPk(EmploiTempsPk emploiTempsPk) {
		this.emploiTempsPk = emploiTempsPk;
	}



	public Professeur getProfesseur() {
		return professeur;
	}



	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	public Salle getSalle() {
		return salle;
	}



	public void setSalle(Salle salle) {
		this.salle = salle;
	}



	public Matiere getMatiere() {
		return matiere;
	}



	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	public Date getDate() {
		return date;
	}
	

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Date heudedeb) {
		this.heureDeb = heudedeb;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}



	
	
	


}
