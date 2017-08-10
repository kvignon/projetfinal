package schoolboard.model;

public class Classe {

	private String nomclasse;
	private Long idNomPp;
	private Long id;

	public Classe() {
		super();
}

	public String getNomclasse() {
		return nomclasse;
	}

	public Long getIdNomPp() {
		return idNomPp;
	}

	public Long getId() {
		return id;
	}

	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}

	public void setIdNomPp(Long idNomPp) {
		this.idNomPp = idNomPp;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}