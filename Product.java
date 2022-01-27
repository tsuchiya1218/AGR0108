package model;

/**
 * クラス名：	Product
 * 概要：	商品情報
//aaaaa
 */

public class Product extends Object {
	private String ProductCode; //商品コード
	private String ProductName; //商品名
	private int Price; //値段
	private int Expiration; //食品期限
	private String MakerID; //メーカーID
	private int CategoryID; //カテゴリID
	private int Stock ; //在庫量

	public Product() {

	}

	public Product(String ProductCode, String ProductName, int Price, int Expiration,
			String MakerID, int CategoryID,int Stock) {
		this.ProductCode = ProductCode;
		this.ProductName = ProductName;
		this.Price = Price;
		this.Expiration = Expiration;
		this.MakerID = MakerID;
		this.CategoryID = CategoryID;
		this.Stock = Stock;
	}

	public void setProductCode(String ProductCode) {
		this.ProductCode = ProductCode;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public int getPrice() {
		return Price;
	}

	public void setExpiration(int Expiration) {
		this.Expiration = Expiration;
	}

	public int getExpiration() {
		return Expiration;
	}

	public void setMakerID(String MakerID) {
		this.MakerID = MakerID;
	}

	public String getMakerID() {
		return MakerID;
	}

	public void setCategoryID(int CategoryID) {
		this.CategoryID = CategoryID;
	}

	public int getCategoryID() {
		return CategoryID;
	}
	
	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}
}
