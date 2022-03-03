package model;

public class Order {;
	private String PdCode; //商品コード
	private String pdName; //商品名
	private int Quantity; //在庫量

	public Order() {
	}
	
	public Order(String PdCode ,String pdName ,int Quantity) {
		this.PdCode = PdCode;
		this.pdName = pdName;
		this.Quantity = Quantity;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setPdCode(String pdCode) {
		PdCode = pdCode;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
//発注表画面