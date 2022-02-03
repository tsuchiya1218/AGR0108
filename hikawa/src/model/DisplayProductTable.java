package model;

/**
 * クラス名：	Product
 * 概要：	商品情報
//aaaaa
 */

public class DisplayProductTable extends Object {
	private String ProductCode; //商品コード
	private String ProductName; //商品名
	private String CategoryName; //カテゴリ名
	private int price; //値段
	private String MakerName; //メーカー名
	private int Stock ; //在庫量
	private String LimitDate; //食品期限
	

	public DisplayProductTable() {

	}
	
	public DisplayProductTable(String productCode, String productName, String categoryName, int price, String makerName,
			int stock, String limitDate) {
		super();
		ProductCode = productCode;
		ProductName = productName;
		CategoryName = categoryName;
		this.price = price;
		MakerName = makerName;
		Stock = stock;
		LimitDate = limitDate;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMakerName() {
		return MakerName;
	}

	public void setMakerName(String makerName) {
		MakerName = makerName;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public String getLimitDate() {
		return LimitDate;
	}

	public void setLimitDate(String limitDate) {
		LimitDate = limitDate;
	}



}