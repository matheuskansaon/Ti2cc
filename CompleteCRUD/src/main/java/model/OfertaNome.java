package model;

public class OfertaNome {
	private int id;
	private String name;
	
	/*
	 * Constructor
	 */
	public OfertaNome(int id, String nome) {
		this.setId(id);
		this.setName(name);
	}
	
	public OfertaNome(int id, String name, String login, String password, 
			String description, String address, String urlLogo) {
		
		this.setId(id);
		this.setName(name);
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
  public String getID() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	// End get, setters
}
