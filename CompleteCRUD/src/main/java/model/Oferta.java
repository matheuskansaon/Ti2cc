package model;

public class Oferta {
	private int id;
	private String finaldate;
	private int discount;
	private int product_id;
	
	
	public Oferta(int id, String finaldate, int discount, int product_id) {
		super();
		this.id = id;
		this.finaldate = finaldate;
		this.discount = discount;
		this.product_id = product_id;
	}


	public Oferta() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFinaldate() {
		return finaldate;
	}


	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	
	
	
}
