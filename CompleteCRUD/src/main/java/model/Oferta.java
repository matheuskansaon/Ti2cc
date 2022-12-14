package model;

import java.util.Date;

public class Oferta {
	private int id;
	private Date initialDate;
	private Date finalDate;
	private int discount;
	private int product_id;
	
	
	public Oferta(int id,Date initialdate, Date finaldate, int discount, int product_id) {
		super();
		this.id = id;
		this.initialDate = initialdate;
		this.finalDate = finaldate;
		this.discount = discount;
		this.product_id = product_id;
	}
	
	public Oferta(int id,int discount, int product_id) {
		super();
		this.id = id;
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
	
	public Date getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(Date finaldate) {
		this.finalDate = finaldate;
	}


	public Date getFinalDate() {
		return finalDate;
	}


	public void setFinaldate(Date finaldate) {
		this.finalDate = finaldate;
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
