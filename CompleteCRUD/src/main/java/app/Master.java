package app;
import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

import dao.RestauranteDAO;
import model.Restaurante;


public class Master {

	public static void main(String[] args) {
		
		port(6789);
		staticFiles.location("/");
		 Gson gson = new Gson();
		
		get("/restaurantes", (req, res) -> {
			RestauranteDAO dao = new RestauranteDAO();
			List<Restaurante> restaurantes = dao.get();
			System.out.println(restaurantes.get(0).getDescription());
			res.type("application/json");
			return restaurantes;
		}, gson::toJson);
		
			
		
		
			
	}

}
