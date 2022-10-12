package model;

public class Restaurante {
	private int id;
	private double preco;
	private int ProdutoID;
	private int RestauranteID;
	private String urlLogo;

	
	/*
	 * Constructor
	 */
	public Restaurante(int id, double preco, int ProdutoID, 
			int RestauranteID, String urlLogo) {
		//this.setID(RestauranteDAO.generatorID());
		
		this.setID(id);
		this.setPreco(preco);
		this.setProdutoID(ProdutoID);
		this.setRestauranteID(RestauranteID);
		this.setUrlLogo(urlLogo);
	}
	
	public Restaurante(int id, double preco, int ProdutoID, 
			int RestauranteID, String urlLogo) {
		
		this.setID(id);
		this.setPreco(preco);
		this.setProdutoID(ProdutoID);
		this.setRestauranteID(RestauranteID);
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
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public double getPreco() {
		return this.description;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public int getProdutoID() {
		return this.ProdutoID;
	}
	public void setProdutoID(int ProdutoID) {
		this.ProdutoID = ProdutoID;
	}
	public int getRestauranteID() {
		return this.RestauranteID;
	}
	public void setRestauranteID(int RestauranteID) {
		this.RestauranteID = RestauranteID;
	}
	public String getUrlLogo() {
		return this.urlLogo;
	}
	public void setUrlLogo(String url) {
		this.urlLogo = url;

		
	// End get, setters
}
