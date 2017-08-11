package schoolboard.model;

public class Login {
	private Long id;
	private String login;
	private String motDePasse;
	private Boolean admin;
	

	public Login() {
		super();

}


	public Long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}