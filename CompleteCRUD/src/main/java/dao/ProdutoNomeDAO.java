package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.ProdutoNome;

public class ProdutoNomeeDAO extends DAO{
	public ProdutoNome() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(ProdutoNome produtonome) {
		boolean status = false;
		try {
			String sql = "INSERT INTO ProdutoNome (id, name"
		               + "VALUES ('" + produtonome.getId() + "', " + produtonome.getName();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public ProdutoNome get(int id) {
		ProdutoNome produtonome = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id;
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 produtonome = new ProdutoNome(rs.getInt("id"), rs.getString("name"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtonome;
	}
	

	// RECUPERA LISTA DE PRODUTONOME
	public List<ProdutoNome> get() {
		List<ProdutoNome> produtonome = new ArrayList<ProdutoNome>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM ProdutoNome" ;
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	produtonome = new ProdutoNome(rs.getInt("id"), rs.getString("name"));
	        			                ;
	            produtonome.add(r);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtonome;
	}
}
