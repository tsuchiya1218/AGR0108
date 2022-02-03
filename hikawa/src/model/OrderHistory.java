package model;

public class OrderHistory {

	private int OdDate; //発注日
	private String OdCode; //発注コード
	private String PdCode; //商品コード
	private String OdName; //発注商品名
	private int OdQuantity; //発注量
	private int DeliDate; //納品予定日
	private int FoodLimit; //食品期限コード

	public OrderHistory() {
	}

	public OrderHistory(int OdDate, String OdCode, String PdCode,
			String OdName, int OdQuantity, int DeliDate, int FoodLimit) {
		this.OdDate = OdDate;
		this.OdCode = OdCode;
		this.PdCode = PdCode;
		this.OdName = OdName;
		this.OdQuantity = OdQuantity;
		this.DeliDate = DeliDate;
		this.FoodLimit = FoodLimit;
	}

	public void setOdDate(int OdDate) {
		this.OdDate = OdDate;
	}

	public int getOdDate() {
		return OdDate;
	}

	public void setOdCode(String OdCode) {
		this.OdCode = OdCode;
	}

	public String getOdCode() {
		return OdCode;
	}

	public void setPdCode(String PdCode) {
		this.PdCode = PdCode;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setOdName(String OdName) {
		this.OdName = OdName;
	}

	public String getOdName() {
		return OdName;
	}

	public void setOdQuantity(int OdQuantity) {
		this.OdQuantity = OdQuantity;
	}

	public int getOdQuantity() {
		return OdQuantity;
	}

	public void setDeliDate(int DeliDate) {
		this.DeliDate = DeliDate;
	}

	public int getDeliDate() {
		return DeliDate;
	}

	public void setFoodLimit(int FoodLimit) {
		this.FoodLimit = FoodLimit;
	}

	public int getFoodLimit() {
		return FoodLimit;
	}

}
