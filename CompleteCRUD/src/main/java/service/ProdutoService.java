package service;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;

public class ProdutoService {
	
	Gson gson = new Gson();
	
	class ProductBody{
		private String ProductName;
		private String ProductPrice;
		private String ProductImage;
		private String ProductInitialDate;
		private String ProductFinalDate;
		private String ProductDiscount;
		
		public ProductBody(String productName, String productPrice, String productImage, String productInitialDate,
				String productFinalDate, String productDiscount) {
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

		public String getProductPrice() {
			return ProductPrice;
		}

		public void setProductPrice(String productPrice) {
			ProductPrice = productPrice;
		}

		public String getProductImage() {
			return ProductImage;
		}

		public void setProductImage(String productImage) {
			ProductImage = productImage;
		}

		public String getProductInitialDate() {
			return ProductInitialDate;
		}

		public void setProductInitialDate(String productInitialDate) {
			ProductInitialDate = productInitialDate;
		}

		public String getProductFinalDate() {
			return ProductFinalDate;
		}

		public void setProductFinalDate(String productFinalDate) {
			ProductFinalDate = productFinalDate;
		}

		public String getProductDiscount() {
			return ProductDiscount;
		}

		public void setProductDiscount(String productDiscount) {
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
		System.out.println(productBody.getProductName());
		return res;
		
	}
	
	public Object delete(Request req, Response res) {
		
		return res;
		
	}
	
	
}