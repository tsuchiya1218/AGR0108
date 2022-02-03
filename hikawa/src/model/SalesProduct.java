package model;

//売上商品履歴

public class SalesProduct {

	private String SPCode; //売上商品コード
	private String PdCode; //商品コード
	private String SPName; //売上商品名	
	private int SPQuantity; //売上個数
	private String SPDate; //売上商品日付

	public SalesProduct() {
	}

	public SalesProduct(String SPCode, String PdCode, String SPName,
			int SPQuantity, String SPDate) {
		this.SPCode = SPCode;
		this.PdCode = PdCode;
		this.SPName = SPName;
		this.SPQuantity = SPQuantity;
		this.SPDate = SPDate;
	}

	public void setSPCode(String SPCode) {
		this.SPCode = SPCode;
	}

	public String getSPCode() {
		return SPCode;
	}

	public void setPdCode(String PdCode) {
		this.PdCode = PdCode;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setSPName(String SPName) {
		this.SPName = SPName;
	}

	public String getSPName() {
		return SPName;
	}

	public void setQuantity(int SPQuantity) {
		this.SPQuantity = SPQuantity;
	}

	public int getSPQuantity() {
		return SPQuantity;
	}

	public void setSPDate(String SPDate) {
		this.SPDate = SPDate;
	}

	public String getSPDate() {
		return SPDate;
	}

}
