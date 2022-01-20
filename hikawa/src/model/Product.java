package model;

/**
 * クラス名：	Product
 * 概要：	商品情報
//aaaaa
 */

public class Product extends Object {
	private char ProductCode; //商品コード
	private String ProductName; //商品名
	private int Price; //値段
	private char FoodLimitCode; //食品期限
	private char MakerID; //メーカーID
	private int CategoryID; //カテゴリID

	public Product() {

	}

	public Product(char ProductCode, String ProductName, int Price, char FoodLimitCode,
			char MakerID, int CategoryID) {
		this.ProductCode = ProductCode;
		this.ProductName = ProductName;
		this.Price = Price;
		this.FoodLimitCode = FoodLimitCode;
		this.MakerID = MakerID;
		this.CategoryID = CategoryID;
	}

	public void setProductCode(char ProductCode) {
		this.ProductCode = ProductCode;
	}

	public char getPdCode() {
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

	public void setFoodLimitCode(char FoodLimitCode) {
		this.FoodLimitCode = FoodLimitCode;
	}

	public char getFoodLimitCode() {
		return FoodLimitCode;
	}

	public void setMakerID(char MakerID) {
		this.MakerID = MakerID;
	}

	public char getMakerID() {
		return MakerID;
	}

	public void setCategoryID(int CategoryID) {
		this.CategoryID = CategoryID;
	}

	public int getCategoryID() {
		return CategoryID;
	}
}
