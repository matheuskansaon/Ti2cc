package model;

public class Oferta {
	private int idOffer;
	private String finaldate;
	private int discount;
	
	/*
	 * Constructor
	 */
	public Oferta(String name, String login, String password, String address, String urlLogo) {
		//this.setID(RestauranteDAO.generatorID());
		this.setFinaldate(finaldate);
		this.setDiscount(discount);
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
	public String getFinaldate() {
		return this.finaldate;
	}
	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}
	public int getDiscount() {
		return this.discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	// End get, setters
}
