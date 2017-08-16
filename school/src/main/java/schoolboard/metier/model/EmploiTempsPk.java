package schoolboard.metier.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class EmploiTempsPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -546020936854178453L;
	
	@Basic(optional= false)
	@Column(name="id_classe")
	private Long idClasse;
	
	@Basic(optional= false)
	@Column(name="id_matiere")
	private Long idMatiere;
	
	@Basic(optional= false)
	@Column(name="id_professeur")
	private Long idProfesseur;
	
	@Basic(optional= false)
	@Column(name="id_salle")
	private Long idSalle;

	public EmploiTempsPk(Long idClasse, Long idMatiere, Long idProfesseur, Long idSalle) {
		super();
		this.idClasse = idClasse;
		this.idMatiere = idMatiere;
		this.idProfesseur = idProfesseur;
		this.idSalle = idSalle;
	}

	public EmploiTempsPk() {
		super();
	}

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public Long getIdProfesseur() {
		return idProfesseur;
	}

	public void setIdProfesseur(Long idProfesseur) {
		this.idProfesseur = idProfesseur;
	}

	public Long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}
	
	
	
	

}
