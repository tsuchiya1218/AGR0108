package model;

public class ProductTable {
	private int ProductTableID; //商品表ID
	private int Stock; //在庫量
	private int Price; //仕入れ価格
	private String OrderCode; //発注コード

	public ProductTable() {
	}

	public ProductTable(int ProductTableID, int Stock, int Price, String OrderCode) {
		this.ProductTableID = ProductTableID;
		this.Stock = Stock;
		this.Price = Price;
		this.OrderCode = OrderCode;
	}

	public void setProductTableID(int ProductTableID) {
		this.ProductTableID = ProductTableID;
	}

	public int getProductTableID() {
		return ProductTableID;
	}

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public int getPrice() {
		return Price;
	}
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}

	public String getOrderCode() {
		return OrderCode;
	}
}
