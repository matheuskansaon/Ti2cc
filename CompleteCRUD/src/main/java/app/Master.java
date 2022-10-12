package app;
import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

import dao.OfertaDAO;
import dao.ProdutoDAO;
import dao.ProdutoNomeDAO;
import dao.RestauranteDAO;
import model.Oferta;
import model.Produto;
import model.ProdutoNome;
import model.Restaurante;


public class Master {

	public static void main(String[] args) {
		
		port(6789);
		staticFiles.location("/");
		 Gson gson = new Gson();
		
		get("/restaurantes", (req, res) -> {
			RestauranteDAO dao = new RestauranteDAO();
			List<Restaurante> restaurantes = dao.get();
			
			res.type("application/json");
			return restaurantes;
		}, gson::toJson);
		
			
		get("/produtos", (req, res) -> {
			ProdutoDAO dao = new ProdutoDAO();
			List<Produto> produtos = dao.get();
			
			res.type("application/json");
			return produtos;
		}, gson::toJson);
		
		get("/produtos_name", (req, res) -> {
			ProdutoNomeDAO dao = new ProdutoNomeDAO();
			List<ProdutoNome> produtosNome = dao.get();
			
			res.type("application/json");
			return produtosNome;
		}, gson::toJson);
		
		get("/oferta", (req, res) -> {
			OfertaDAO dao = new OfertaDAO();
			List<Oferta> ofertas = dao.get();
			
			res.type("application/json");
			return ofertas;
		}, gson::toJson);
			
	}

}
