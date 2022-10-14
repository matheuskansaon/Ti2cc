package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Oferta;

public class OfertaDAO extends DAO{
	public OfertaDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	
	
	public boolean insert(Oferta oferta) {
		boolean status = false;
		try {
			String sql = "INSERT INTO offer (id, finaldate, discount, product_id) "
		               + "VALUES ('" + oferta.getId() + "', " + oferta.getFinaldate() + ", "
		               + oferta.getDiscount() + ", " + oferta.getProduct_id() + ");";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Oferta get(int id) {
		Oferta oferta = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id + ";";
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 oferta = new Oferta(rs.getInt("id"), rs.getString("finaldate"), 
	        			 			   rs.getInt("discount"), 
	                				   rs.getInt("product_id"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return oferta;
	}
	

	
	}	
	


