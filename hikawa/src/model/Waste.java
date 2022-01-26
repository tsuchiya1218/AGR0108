package model;

public class Waste {
	private String WasteCode; //商品コード
	private int WasteQuantity; //商品名
	private String PuroductCode; //商品名

	public Waste() {

	}

	public Waste(String WasteCode, int WasteQuantity, String PuroductCode) {
		this.WasteCode = WasteCode;
		this.WasteQuantity = WasteQuantity;
		this.PuroductCode = PuroductCode;
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

}
