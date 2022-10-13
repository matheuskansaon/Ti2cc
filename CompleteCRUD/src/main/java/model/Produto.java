package model;

public class Produto{
	
	private int id;
	private String image;
	private double price;
	private int product_id;
	private int restaurant_id;
	private Restaurante restaurante;
	private String name;
	
	public Produto(int id, String image, double price, int product_id, int restaurant_id, Restaurante restaurante,
			String name) {
		super();
		this.id = id;
		this.image = image;
		this.price = price;
		this.product_id = product_id;
		this.restaurant_id = restaurant_id;
		this.restaurante = restaurante;
		this.name = name;
	}


	
	public Produto(int id, String image, double price, int product_id, int restaurant_id) {
		super();
		this.id = id;
		this.image = image;
		this.price = price;
		this.product_id = product_id;
		this.restaurant_id = restaurant_id;
	}



	public Produto() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}



	public Restaurante getRestaurante() {
		return restaurante;
	}



	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}