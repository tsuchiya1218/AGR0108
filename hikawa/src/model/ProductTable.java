package model;

public class ProductTable {
	private int ProductTableID; //商品表ID
	private int Stock; //在庫量
	private int purPrice; //仕入れ価格
	private String OrderCode; //発注コード

	public ProductTable() {
	}

	public ProductTable(int ProductTableID, int Stock, int purPrice, String OrderCode) {
		this.ProductTableID = ProductTableID;
		this.Stock = Stock;
		this.purPrice = purPrice;
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

	public void setPrice(int purPrice) {
		this.purPrice = purPrice;
	}

	public int getPrice() {
		return purPrice;
	}
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}

	public String getOrderCode() {
		return OrderCode;
	}
}
