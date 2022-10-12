package dao;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Restaurante;

public class RestauranteDAO extends DAO{
	public RestauranteDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Restaurante restaurante) {
		boolean status = false;
		try {
			String sql = "INSERT INTO Restaurante (id, name, login, password, "
					   + "description, address, logo"
		               + "VALUES ('" + restaurante.getId() + "', " + restaurante.getName() + ", "
		               + restaurante.getLogin() + ", " + restaurante.getPassword() + ", "
		               + restaurante.getDescription()+ ", " + ", " + restaurante.getAddress() +", "
		               + restaurante.getUrlLogo();
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
			String sql = "SELECT * FROM produto WHERE id="+id;
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
}
