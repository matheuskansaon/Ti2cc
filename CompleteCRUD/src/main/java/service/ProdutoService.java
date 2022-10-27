package service;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;
import spark.Request;
import spark.Response;

public class ProdutoService {
	
	
	
	
	public Object getProdutos(Request req, Response res){
		String search = req.queryParamOrDefault("search", "");
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.get(search);			
		res.type("application/json");
		return produtos;
	}
	
	
}