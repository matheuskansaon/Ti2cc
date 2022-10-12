package model;

public class Restaurante {
	private int id;
	private String name;
	private String login;
	private String password;
	private String description;
	private String address;
	private String urlLogo;
	
	/*
	 * Constructor
	 */
	public Restaurante(String name, String login, String password, 
			String description, String address, String urlLogo) {
		//this.setID(RestauranteDAO.generatorID());
		
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
		this.setAddress(address);
		this.setUrlLogo(urlLogo);
	}
	
	public Restaurante(int id, String name, String login, String password, 
			String description, String address, String urlLogo) {	
		
		this.setId(id);
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
		this.setAddress(address);
		this.setUrlLogo(urlLogo);
	}
	// End Constructor
	
	
	/*
	 * Methods gets and setters
	 */
	
	
	/* ID
		public int getID() { return this.ID; }
		public void setID(int id) {
			this.ID = id;
		}
	*/
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrlLogo() {
		return this.urlLogo;
	}
	public void setUrlLogo(String url) {
		this.urlLogo = url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
		
	// End get, setters
}
