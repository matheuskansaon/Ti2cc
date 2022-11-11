package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Produto;
import model.Restaurante;

public class ProdutoDAO extends DAO{
	public ProdutoDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public List<Produto> get(String search) {
		
		List<Produto> produtos = new ArrayList<Produto>();
		

		try {
			
			String sql = "SELECT \r\n"
					+ "product.id as \"product_id\",\r\n"
					+ "product.image as \"product_image\", \r\n"
					+ "product.price as \"product_price\", \r\n"
					+ "product.product_id as \"productName_id\",\r\n"
					+ "product.restaurant_id as \"productRestaurant_id\",\r\n"
					+ "product.count_clicks as \"productCountClicks\",\r\n"
					+ "product_name.name as \"product_name\" , \r\n"
					+ "product_name.id as \"productName_id\" , \r\n"
					+ "restaurant.id as \"restaurant_id\",\r\n"
					+ "restaurant.name as \"restaurant_name\", \r\n"
					+ "restaurant.login as \"restaurant_login\",\r\n"
					+ "restaurant.password as \"restaurant_password\",\r\n"
					+ "restaurant.description as \"restaurant_description\",\r\n"
					+ "restaurant.address as \"restaurant_address\",\r\n"
					+ "restaurant.logo as \"restaurant_logo\"\r\n"
					+ "FROM product\r\n"
					+ "JOIN product_name ON product_name.id = product.product_id\r\n"
					+ "JOIN restaurant ON restaurant.id = product.restaurant_id\r\n"
					+ "WHERE product_name.name like ? or restaurant.name like ?"
					+ "ORDER BY product.count_clicks ASC";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, "%" + search + "%");
			st.setString(2, "%" + search + "%");
			ResultSet rs = st.executeQuery();	           
	        while(rs.next()) {	
	        	
	        	Produto p = new Produto(rs.getInt("product_id"), rs.getString("product_image"), rs.getDouble("product_price"), 
										rs.getInt("productName_id"),  rs.getInt("productRestaurant_id"), new Restaurante(rs.getInt("restaurant_id"), rs.getString("restaurant_name"), 
												rs.getString("restaurant_login"), rs.getString("restaurant_password"), rs.getString("restaurant_description"), 
												rs.getString("restaurant_address"), rs.getString("restaurant_logo")), rs.getString("product_name"), rs.getInt("productCountClicks"));
	        			                
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	public List<Produto> getByRestauranteId(int restId) {
		
		List<Produto> produtos = new ArrayList<Produto>();	

		try {
			
			String sql = "SELECT \r\n"
					+ "product.id as \"product_id\",\r\n"
					+ "product.image as \"product_image\", \r\n"
					+ "product.price as \"product_price\", \r\n"
					+ "product.product_id as \"productName_id\",\r\n"
					+ "product.restaurant_id as \"productRestaurant_id\",\r\n"
					+ "product.count_clicks as \"productCountClicks\",\r\n"
					+ "product_name.name as \"product_name\" , \r\n"
					+ "product_name.id as \"productName_id\" , \r\n"
					+ "restaurant.id as \"restaurant_id\",\r\n"
					+ "restaurant.name as \"restaurant_name\", \r\n"
					+ "restaurant.login as \"restaurant_login\",\r\n"
					+ "restaurant.password as \"restaurant_password\",\r\n"
					+ "restaurant.description as \"restaurant_description\",\r\n"
					+ "restaurant.address as \"restaurant_address\",\r\n"
					+ "restaurant.logo as \"restaurant_logo\"\r\n"
					+ "FROM product\r\n"
					+ "JOIN product_name ON product_name.id = product.product_id\r\n"
					+ "JOIN restaurant ON restaurant.id = product.restaurant_id\r\n"
					+ "WHERE product.restaurant_id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setInt(1, restId);
			ResultSet rs = st.executeQuery();	           
	        while(rs.next()) {	
	        	
	        	Produto p = new Produto(rs.getInt("product_id"), rs.getString("product_image"), rs.getDouble("product_price"), 
										rs.getInt("productName_id"),  rs.getInt("productRestaurant_id"), new Restaurante(rs.getInt("restaurant_id"), rs.getString("restaurant_name"), 
												rs.getString("restaurant_login"), rs.getString("restaurant_password"), rs.getString("restaurant_description"), 
												rs.getString("restaurant_address"), rs.getString("restaurant_logo")), rs.getString("product_name"), rs.getInt("productCountClicks"));
	        			                
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	
		
	public int insert(Produto produto) {
		boolean status = false;
		int lastId = 0;
		try {
			String sql = "INSERT INTO product (image, price, product_id, restaurant_id, count_clicks) "
		               + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, produto.getImage());
			st.setDouble(2, produto.getPrice());
			st.setInt(3, produto.getProduct_id());
			st.setInt(4, produto.getRestaurant_id());
			st.setInt(5, produto.getCount_clicks());
			
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
			    lastId = rs.getInt("id");
			}
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return lastId;
	}
	
	
	public Produto get(int id) {
		Produto produto = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM product WHERE id="+id + ";"; // aqui colocar order by visualizações
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 produto = new Produto(rs.getInt("id"), rs.getString("image"), rs.getDouble("price"), 
	        			 			   rs.getInt("product_id"), 
	                				   rs.getInt("restaurant_id")
	                				   );
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		
		try {
			String sql = "DELETE FROM product WHERE id=?";
			PreparedStatement st = conexao.prepareStatement(sql);	
			st.setInt(1, id);
			st.executeQuery();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return status;
		
	}
	
	public boolean incrementCountClick(int id) {
		boolean status = false;
		
		try {
			String sql = "select count_clicks from product where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);	
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int countClick = rs.getInt("count_clicks");
				System.out.println("Count clicks do produto: " + id + "e igual a: " + countClick);
				setCountClick(id, countClick + 1);
			}

	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return status;		
	}
	
	public boolean setCountClick(int id, int countClicks) {
		boolean status = false;
		
		try {
			String sql = "update product set count_clicks = ? where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);	
			st.setInt(1, countClicks);
			st.setInt(2, id);
			st.executeQuery();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return status;		
	}
	
	
	/*
	public boolean update(Produto produto, int id) {
		boolean status = false;
		try {
			String sql = "UPDATE product SET id, image, price, product_id, restaurante_id, "
		               + "VALUES ('" + produto.getId() + "', " + produto.getImage() + ", "
		               + produto.getPrice() + ", " + produto.getProduct_id() + ", "
		               + produto.getRestaurant_id();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	*/
	
	
}

