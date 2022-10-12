package model;

public class Oferta {
	private int idOffer;
	private String finaldate;
	private int discount;
	private int product_id;
	
	/*
	 * Constructor
	 */
	public Oferta(String finaldate, int discount) {
		//this.setID(RestauranteDAO.generatorID());
		this.setFinaldate(finaldate);
		this.setDiscount(discount);
	}
	// End Constructor
	
	
	/*
	 * Methods gets and setters
	 */
	
	
	
	public int getID() {
		return this.idOffer; 
		}
		/* ID
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
	
	public int getProductId() {
		return this.product_id;
	}
	public void setProduct_id(int productId) {
		this.product_id = product_id;
	}
	
	// End get, setters
}
