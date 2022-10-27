package service;

import java.util.List;


import dao.RestauranteDAO;
import model.Restaurante;
import spark.Request;
import spark.Response;

public class RestauranteService {
	
	
	public Object getRestaurante(Request req, Response res){
		String search = req.queryParamOrDefault("search", "");
		RestauranteDAO dao = new RestauranteDAO();
		List<Restaurante> restaurantes = dao.get(search);			
		res.type("applicat	ion/json");
		return restaurantes;
	}
	
	
	
	
}