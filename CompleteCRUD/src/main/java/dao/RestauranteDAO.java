package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Restaurante;

public class RestauranteDAO extends DAO{
	public RestauranteDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	// 
	/*
	 * INSERT into restaurant (id, name, login, password,description, address, logo) VALUES 
	 * ( 3, 'Restaurant', 'Teste123', '123' , 'Res_Teste', 'Rua Teste', 'teste_logo')
	 */
	
	public boolean insert(Restaurante restaurante) {
		boolean status = false;
		try {
			String sql = "INSERT INTO Restaurante (id, name, login, password, "
					   + "description, address, logo"
		               + "VALUES (" + restaurante.getId() + ", '" + restaurante.getName() + "', '"
		               + restaurante.getLogin() + "', '" + restaurante.getPassword() + "', '"
		               + restaurante.getDescription()+ "', " + "'" + restaurante.getAddress() +"', '"
		               + restaurante.getUrlLogo() + "'";
			PreparedStatement st = conexao.prepareStatement(sql);
		    //st.setTimestamp(1, Timestamp.valueOf(restaurante.getDataFabricacao()));
			//st.setDate(2, Date.valueOf(restaurante.getDataValidade()));
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Restaurante get(int id) {
		Restaurante restaurante = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM restaurant WHERE id="+id;
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 restaurante = new Restaurante(rs.getInt("id"), rs.getString("name"), 
	        			 			   rs.getString("login"), 
	                				   rs.getString("password"), 
	                				   rs.getString("description"),
	                				   rs.getString("address"),
	                				   rs.getString("logo"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return restaurante;
	}
	

	// RECUPERA LISTA DE RESTAURANTES
	public List<Restaurante> get(String search) {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		try {
			String sql = "SELECT * FROM restaurant where name like ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, "%" + search + "%");
			ResultSet rs = st.executeQuery();	           
	        while(rs.next()) {	            	
	        	Restaurante r = new Restaurante(rs.getInt("id"), rs.getString("name"), rs.getString("login"), 
										rs.getString("password"),  rs.getString("description"),
										rs.getString("address"), rs.getString("logo"))
	        			                ;
	            restaurantes.add(r);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return restaurantes;
	}
	/*
	 * select id, name, password from restaurant where name like '%Burguer' and password like '%123'
	 */
	public boolean login (String name, String password) {
		boolean meet = false;
		
		try {
			String sql = "SELECT * FROM restaurant where name like '%" + name
				          + "' and password like '%" + password + "'";
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet rs = st.executeQuery();	           
	        if(rs.next()) {	            	
	        	meet = true;
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return meet;
	}
}

