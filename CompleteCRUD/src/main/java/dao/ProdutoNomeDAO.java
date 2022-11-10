package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.ProdutoNome;


//import model.ProdutoNome;

public class ProdutoNomeDAO extends DAO{
	
	public ProdutoNomeDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	
	
	
	public int insert(ProdutoNome produtonome) {
		boolean status = false;
		int lastId = 0;
		try {
			String sql = "INSERT INTO product_name (name)"
		               + "VALUES ('" + produtonome.getName() + "');";
			PreparedStatement st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
	
	
	public ProdutoNome get(int id) {
		ProdutoNome produtonome = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM product_name WHERE id="+id + ";";
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
	

	
	
}

