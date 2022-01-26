package model;

public class SalesProduct {

	private String SPCode; //商品コード
	private int Quantity; //商品名
	private String SPDate; //商品名
	private String ProductCode; //商品名

	public SalesProduct() {
	}

	public SalesProduct(String SPCode, int Quantity, String SPDate, String ProductCode) {
		this.SPCode = SPCode;
		this.Quantity = Quantity;
		this.SPDate = SPDate;
		this.ProductCode = ProductCode;
	}

	public void setSPCode(String SPCode) {
		this.SPCode = SPCode;
	}

	public String getSPCode() {
		return SPCode;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public int getStock() {
		return Quantity;
	}

	public void setSPDate(String SPDate) {
		this.SPDate = SPDate;
	}

	public String getSPDate() {
		return SPDate;
	}
	public void setProductCode(String ProductCode) {
		this.ProductCode = ProductCode;
	}

	public String getProductCode() {
		return ProductCode;
	}
}
