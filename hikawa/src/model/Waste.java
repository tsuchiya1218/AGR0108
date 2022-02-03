package model;

public class Waste {
	private String WasteCode; //廃棄コード
	private String WastePdCode; //商品コード
	private String WastePdName;//商品名
	private int WasteQuantity; //廃棄個数
	private int Limit;

	public Waste() {

	}

	public Waste(String WasteCode, String WastePdCode, String WastePdName, int WasteQuantity, int Limit) {
		this.WasteCode = WasteCode;
		this.WastePdCode = WastePdCode;
		this.WastePdName = WastePdName;
		this.WasteQuantity = WasteQuantity;
		this.Limit = Limit;
	}

	public void setWasteCode(String WasteCode) {
		this.WasteCode = WasteCode;
	}

	public String getWasteCode() {
		return WasteCode;
	}

	public void setWastePdCode(String WastePdCode) {
		this.WastePdCode = WastePdCode;
	}

	public String getWastePdCode() {
		return WastePdCode;
	}

	public void setWastePdName(String WastePdName) {
		this.WastePdName = WastePdName;
	}

	public String getWastePdName() {
		return WastePdName;
	}

	public void setWasteQuantity(int WasteQuantity) {
		this.WasteQuantity = WasteQuantity;
	}

	public int getWasteQuantity() {
		return WasteQuantity;
	}

	public void setLimit(int Limit) {
		this.Limit = Limit;
	}

	public int getLimit() {
		return Limit;
	}

}
