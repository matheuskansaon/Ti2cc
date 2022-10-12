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
			String sql = "INSERT INTO Oferta (idOffer, finaldate, discount, product_id, "
		               + "VALUES ('" + oferta.getID() + "', " + oferta.getFinaldate() + ", "
		               + oferta.getDiscount() + ", " + restaurante.getProductId();
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
	
	public Oferta get(int id) {
		Oferta oferta = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id;
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 oferta = new Oferta(rs.getInt("id"), rs.getString("data_final"), 
	        			 			   rs.getInt("desconto"), 
	                				   rs.getInt("Produto_id"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return oferta;
	}
	

	// RECUPERA LISTA DE OFERTA
	public List<Oferta> get() {
		List<Oferta> oferta = new ArrayList<Oferta>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM offer" ;
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Oferta r = new Oferta(rs.getInt("id"), rs.getString("data_final"), 
	        			 			   rs.getInt("desconto"), 
	                				   rs.getInt("Produto_id"));
	            oferta.add(r);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return oferta;
	}
}
