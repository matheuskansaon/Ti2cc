package dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Produto;

public class ProdutoDAO extends DAO{
	public ProdutoDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Produto produto) {
		boolean status = false;
		try {
			String sql = "INSERT INTO Produto (id, preco, ProdutoID, RestauranteID, "
					   + "logo"
		               + "VALUES ('" + produto.getID() + "', " + produto.getPreco() + ", "
		               + produto.getProdutoID() + ", " + produto.getRestauranteID() + ", "
		               + produto.getUrlLogo();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Produto get(int id) {
		Produto produto = null;
		
		try {
			Statement st = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id="+id;
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);	
	        if(rs.next()){            
	        	 produto = new Produto(rs.getInt("id"), rs.getDouble("preco"), 
	        			 			   rs.getInt("ProdutoID"), 
	                				   rs.getInt("RestauranteID"),
	                				   rs.getString("logo"));
	        }
	        ((java.sql.Statement) st).close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	

	// RECUPERA LISTA DE PRODUTO
	public List<Produto> get() {
		List<Produto> produto = new ArrayList<Produto>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM product" ;
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	produto r = new Produto(rs.getInt("id"), rs.getDouble("preco"), 
	        			 			   rs.getInt("ProdutoID"), 
	                				   rs.getInt("RestauranteID"),
	                				   rs.getString("logo"))
	        			                ;
	            produto.add(r);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
}
