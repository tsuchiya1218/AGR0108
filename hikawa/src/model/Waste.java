package model;

public class Waste {
	private String WasteCode; //廃棄コード
	private int WasteQuantity; //廃棄個数
	private String PuroductCode; //商品コード
	private String ProductName;
	private int Limit;

	public Waste() {

	}

	public Waste(String WasteCode, int WasteQuantity, String PuroductCode,String ProductName,int Limit) {
		this.WasteCode = WasteCode;
		this.WasteQuantity = WasteQuantity;
		this.PuroductCode = PuroductCode;
		this.ProductName = ProductName;
		this.Limit = Limit;
	}

	public void setWasteCode(String WasteCode) {
		this.WasteCode = WasteCode;
	}

	public String getWasteCode() {
		return WasteCode;
	}

	public void setWasteQuantity(int WasteQuantity) {
		this.WasteQuantity = WasteQuantity;
	}

	public int getWasteQuantity() {
		return WasteQuantity;
	}

	public void setPuroductCode(String PuroductCode) {
		this.PuroductCode = PuroductCode;
	}

	public String getPuroductCode() {
		return PuroductCode;
	}
	
	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public String getProductName() {
		return ProductName;
	}
	
	public void setLimit(int Limit) {
		this.Limit = Limit;
	}

	public int getLimit() {
		return Limit;
	}

}
