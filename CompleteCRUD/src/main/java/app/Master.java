package app;
import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

import dao.ProdutoDAO;
import dao.RestauranteDAO;
import model.Produto;
import model.Restaurante;


public class Master {

	public static void main(String[] args) {
		
		port(6789);
		staticFiles.location("/");
		 Gson gson = new Gson();
		 
		 
		 
		 // Métodos para listar restaurantes e produtos na página inicial
		
		get("/restaurantes", (req, res) -> {
			String search = req.queryParamOrDefault("search", "");
			RestauranteDAO dao = new RestauranteDAO();
			List<Restaurante> restaurantes = dao.get(search);			
			res.type("application/json");
			return restaurantes;
		}, gson::toJson);
		
			
		get("/produtos", (req, res) -> {
			String search = req.queryParamOrDefault("search", "");
			ProdutoDAO dao = new ProdutoDAO();
			List<Produto> produtos = dao.get(search);			
			res.type("application/json");
			return produtos;
		}, gson::toJson);
		
		
			
	}

}
