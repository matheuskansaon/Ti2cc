package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import dao.RestauranteDAO;
import model.Restaurante;
import spark.Request;
import spark.Response;
import model.Restaurante;
public class RestauranteService {
	
	
	public Object getRestaurante(Request req, Response res){
		String search = req.queryParamOrDefault("search", "");
		RestauranteDAO dao = new RestauranteDAO();
		List<Restaurante> restaurantes = dao.get(search);			
		res.type("applicat	ion/json");
		return restaurantes;
	}
	
	public Object insert(Request request, Response response) {
		RestauranteDAO restauranteDAO = new RestauranteDAO();
		
		String login = request.queryParams("email");
		String password = request.queryParams("password");
		String name = request.queryParams("name");
		String address = request.queryParams("address");
		String biografy = request.queryParams("biografy");
		String url = request.queryParams("url");
		
		String resp = "";
		
		Restaurante restaurante = new Restaurante(name, login, password, biografy, address, url);
		
		if(restauranteDAO.insert(restaurante) == true) {
            resp = "Restaurante (" + name + ") inserido!";
            response.status(201); // 201 Created
		} else {
			resp = "Restaurante (" + name + ") não inserido!";
			response.status(404); // 404 Not found
		}
		
		// Ask Max
	//	makeForm();
	//	return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">", "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\""+ resp +"\">");
		return null;
	}
	
	
}