package model;

public class WasteTable {
	private String ProductCode;//商品コード
	private String pName;//商品名
	private String lDate;//食品期限
	private int Stock; //在庫量

	public WasteTable(String ProductCode, String pName, int Stock, String lDate) {
		this.ProductCode = ProductCode;
		this.pName = pName;
		this.lDate = lDate;
		this.Stock = Stock;
	}


	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getlDate() {
		return lDate;
	}

	public void setlDate(String lDate) {
		this.lDate = lDate;
	}


	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}
}
