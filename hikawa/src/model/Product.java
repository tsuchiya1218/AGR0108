package model;

/**
 * クラス名：	Product
 * 概要：	商品情報
//aaaaa
 */

public class Product extends Object {
	private String PdCode; //商品コード
	private String PdName; //商品名
	private int Category; //カテゴリ
	private int Price; //値段
	private String MakerName; //メーカー名
	private int Stock; //在庫量
	private int Expiration; //食品期限

	public Product() {
	}

	public Product(String PdCode, String PdName, int Category, int Price, String MakerName,
			int Stock, int Expiration) {
		this.PdCode = PdCode;
		this.PdName = PdName;
		this.Category = Category;
		this.Price = Price;
		this.MakerName = MakerName;
		this.Stock = Stock;
		this.Expiration = Expiration;
	}

	public void setPdCode(String PdCode) {
		this.PdCode = PdCode;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setPdName(String PdName) {
		this.PdName = PdName;
	}

	public String getPdName() {
		return PdName;
	}

	public void setCategory(int Category) {
		this.Category = Category;
	}

	public int getCategory() {
		return Category;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public int getPrice() {
		return Price;
	}

	public void setMakerName(String MakerName) {
		this.MakerName = MakerName;
	}

	public String getMakerName() {
		return MakerName;
	}

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}

	public void setExpiration(int Expiration) {
		this.Expiration = Expiration;
	}

	public int getExpiration() {
		return Expiration;
	}

}
