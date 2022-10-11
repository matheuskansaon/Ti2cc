package dao;

public class RestauranteDAO extends DAO{
	public RestauranteDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
}
