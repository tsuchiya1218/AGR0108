package model;

public class OrderHistory {

	private String OdDate; //発注日
	private String OdCode; //発注コード
	private String PdCode; //商品コード
	private String OdName; //発注商品名
	private int OdQuantity; //発注量
	private String DeliDate; //納品予定日
	private String FoodLimit; //食品期限コード
	private String Status;
	private String Quantity;

	public OrderHistory(String OdDate, String OdCode, String PdCode, String OdName, int OdQuantity, String DeliDate) {
		this.OdDate = OdDate;
		this.OdCode = OdCode;
		this.PdCode = PdCode;
		this.OdName = OdName;
		this.OdQuantity = OdQuantity;
		this.DeliDate = DeliDate;
	}
	
	public OrderHistory(String OdDate, String pCode, String OdName, int Quantity, String deliDate, String Status) {
		this.OdDate = OdDate;
		this.PdCode = pCode;
		this.OdName = OdName;
		this.OdQuantity = Quantity;
		this.DeliDate = deliDate;
		this.Status = Status;
	}

	public String getOdDate() {
		return OdDate;
	}

	public void setOdDate(String odDate) {
		OdDate = odDate;
	}

	public String getOdCode() {
		return OdCode;
	}

	public void setOdCode(String odCode) {
		OdCode = odCode;
	}

	public String getPdCode() {
		return PdCode;
	}

	public void setPdCode(String pdCode) {
		PdCode = pdCode;
	}

	public String getOdName() {
		return OdName;
	}

	public void setOdName(String odName) {
		OdName = odName;
	}

	public int getOdQuantity() {
		return OdQuantity;
	}

	public void setOdQuantity(int odQuantity) {
		OdQuantity = odQuantity;
	}

	public String getDeliDate() {
		return DeliDate;
	}

	public void setDeliDate(String deliDate) {
		DeliDate = deliDate;
	}

	public String getFoodLimit() {
		return FoodLimit;
	}

	public void setFoodLimit(String foodLimit) {
		FoodLimit = foodLimit;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
		
	
}