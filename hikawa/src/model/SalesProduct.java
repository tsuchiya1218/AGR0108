package model;

public class SalesProduct {

	private String SPCode; //売上商品コード
	private int Quantity; //売上個数
	private String SPDate; //売上商品日付
	private String ProductCode; //商品コード
	private String SPName; //売上商品名	

	public SalesProduct() {
	}

	public SalesProduct(String SPCode, int Quantity, String SPDate, String ProductCode,String SPName) {
		this.SPCode = SPCode;
		this.Quantity = Quantity;
		this.SPDate = SPDate;
		this.ProductCode = ProductCode;
		this.SPName = SPName;
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

	public int getQuantity() {
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
	
	public void setSPName(String SPName) {
		this.SPName = SPName;
	}

	public String getSPName() {
		return SPName;
	}
}
