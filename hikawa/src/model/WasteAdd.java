package model;

public class WasteAdd {

	private String PdCode; //商品コード
	private String PdName;//商品名
	private int WasteQuantity; //個数
	private int Limit;//食品期限

	public WasteAdd() {

	}

	public WasteAdd(String PdCode, String PdName, int WasteQuantity, int Limit) {

		this.PdCode = PdCode;
		this.PdName = PdName;
		this.WasteQuantity = WasteQuantity;
		this.Limit = Limit;
	}

	public void setWasteCode(String PdCode) {
		this.PdCode = PdCode;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setPuroductCode(String PdName) {
		this.PdName = PdName;
	}

	public String getPdName() {
		return PdName;
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
