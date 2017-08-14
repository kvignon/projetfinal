package schoolboard.metier.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Horaire")
public class Horaire {
	
	private Long id;
	private Date heureDeb;
	private Date heureFin;
	private Date date;
	private EmploiDuTemps edt;
	private int version;
	
	public Horaire(Date heureDeb, Date heureFin, Date date) {
		super();
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.date = date;
	}
	
	public Horaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="HH:mm")
	@Column(name="heureDebut")
	public Date getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="HH:mm")
	@Column(name="heureFin")
	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
}
