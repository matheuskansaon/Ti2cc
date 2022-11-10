package service;

import java.util.Date;
import java.util.List;

import dao.OfertaDAO;
import dao.ProdutoDAO;
import dao.ProdutoNomeDAO;
import model.Oferta;
import model.Produto;
import model.ProdutoNome;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;

public class ProdutoService {
	
	Gson gson = new Gson();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ProdutoNomeDAO produtoNomeDAO = new ProdutoNomeDAO();
	private OfertaDAO ofertaDAO = new OfertaDAO();
	
	class ProductBody{
		private String ProductName;
		private Double ProductPrice;
		private String ProductImage;
		private Date ProductInitialDate;
		private Date ProductFinalDate;
		private int ProductDiscount;
		
		
		public ProductBody(String productName, Double productPrice, String productImage, Date productInitialDate,
				Date productFinalDate, int productDiscount) {
			super();
			ProductName = productName;
			ProductPrice = productPrice;
			ProductImage = productImage;
			ProductInitialDate = productInitialDate;
			ProductFinalDate = productFinalDate;
			ProductDiscount = productDiscount;
		}

		public String getProductName() {
			return ProductName;
		}

		public void setProductName(String productName) {
			ProductName = productName;
		}

		public Double getProductPrice() {
			return ProductPrice;
		}

		public void setProductPrice(Double productPrice) {
			ProductPrice = productPrice;
		}

		public String getProductImage() {
			return ProductImage;
		}

		public void setProductImage(String productImage) {
			ProductImage = productImage;
		}

		public Date getProductInitialDate() {
			return ProductInitialDate;
		}

		public void setProductInitialDate(Date productInitialDate) {
			ProductInitialDate = productInitialDate;
		}

		public Date getProductFinalDate() {
			return ProductFinalDate;
		}

		public void setProductFinalDate(Date productFinalDate) {
			ProductFinalDate = productFinalDate;
		}

		public int getProductDiscount() {
			return ProductDiscount;
		}

		public void setProductDiscount(int productDiscount) {
			ProductDiscount = productDiscount;
		}
		
		
		
		
	}
	
	
	public Object getProdutos(Request req, Response res){
		String search = req.queryParamOrDefault("search", "");
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.get(search);			
		res.type("application/json");
		return produtos;
	}
	
	public Object insert(Request req, Response res) {
		
		String bodyString = req.body();
		ProductBody productBody = gson.fromJson(bodyString, ProductBody.class);
		
		ProdutoNome newProdutoNome = new ProdutoNome(-1,productBody.getProductName());
		
		if(produtoNomeDAO.insert(newProdutoNome) == true) {
           System.out.println("deu certo");
		} else {
			System.out.println("não deu certo");
		}
		
		//Produto newProduto = new Produto(-1, productBody.getProductImage(), productBody.getProductPrice(), 2, 3);
		//Oferta newOferta = new Oferta(-1,productBody.getProductInitialDate(), productBody.getProductFinalDate(), productBody.getProductDiscount(), 2);
		
		
		System.out.println(productBody.getProductName());
		return res;
		
	}
	
	public Object delete(Request req, Response res) {
		
		return res;
		
	}
	
	
}