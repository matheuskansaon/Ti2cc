package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.Oferta;

public class OfertaDAO extends DAO{
	public OfertaDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	
	
	public int insert(Oferta oferta) {
		boolean status = false;
		int lastId = 0;
		try {
			String sql = "INSERT INTO offer (initialdate, finaldate, discount, product_id) "
		               + "VALUES (?, ?, ?, ?);";
			PreparedStatement st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, new java.sql.Date(oferta.getInitialDate().getTime()));
			st.setDate(2, new java.sql.Date(oferta.getFinalDate().getTime()));
			st.setInt(3, oferta.getDiscount());
			st.setInt(4, oferta.getProduct_id());		
		
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
	
	public Oferta get(int id) {
		Oferta oferta = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id + ";";
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 oferta = new Oferta(rs.getInt("id"), rs.getDate("initialDate"), rs.getDate("finalDate"), 
	        			 			   rs.getInt("discount"), 
	                				   rs.getInt("product_id"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return oferta;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		
		try {
			String sql = "DELETE FROM offer WHERE product_id=?";
			PreparedStatement st = conexao.prepareStatement(sql);	
			st.setInt(1, id);
			st.executeQuery();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return status;
		
	}
	
	

	
	}	
	


