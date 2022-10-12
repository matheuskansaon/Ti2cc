package dao;

public class OfferDAO extends DAO{
	public OfferDAO() {
		conectar();
	}

	public void finalize() {
		close();
	}
}
