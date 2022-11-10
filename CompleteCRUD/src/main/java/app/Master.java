package app;

import static spark.Spark.*;

import com.google.gson.Gson;

import service.ProdutoService;
import service.RestauranteService;

public class Master {

	private static ProdutoService produtoService = new ProdutoService();
	private static RestauranteService restauranteService = new RestauranteService();
	
	public static void main(String[] args) {
		
		port(6789);
		staticFiles.location("/");
		 Gson gson = new Gson();
		
		 
		 // Métodos para listar restaurantes e produtos na página inicial
		 
		get("/restaurantes", (req, res) -> restauranteService.getRestaurante(req,res), gson::toJson);		
		get("/produtos", (req, res) -> produtoService.getProdutos(req, res), gson::toJson);	
		post("/produto/insert", (req, res) -> produtoService.insert(req, res));
		//delete("/produto/delete/:id", (req, res) -> produtoService.delete(req, res));
		//post("restaurante/insert", (request, response) -> restauranteService.insert(request, response));
		get("/restaurante/insert", (request, response) -> "Hello Wolrd");
	}

}
