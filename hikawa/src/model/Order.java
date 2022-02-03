package model;

public class Order {
	private String PdCode; //商品コード
	private String PdName; //商品名
	private int Stock; //在庫量

	public Order() {
	}
	
	public Order(String PdCode ,String PdName ,int Stock) {
		this.PdCode = PdCode;
		this.PdName = PdName;
		this.Stock = Stock;
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

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}
}
//発注表画面