package model;

public class Order {
	private int OrderDate; //発注日
	private String OrderCode; //発注コード
	private String ProductCode; //商品コード
	private String OrderName; //発注商品名
	private int OrderQuantity; //発注量
	private int DeliveryDate; //配達日
	private int FoodLimit; //食品期限コード

	public Order() {
	}
	
	public Order(int OrderDate ,String OrderCode ,String ProductCode,
			String OrderName ,int OrderQuantity ,int DeliveryDate ,int FoodLimit) {
		this.OrderCode = OrderCode;
		this.OrderDate = OrderDate;
		this.ProductCode = ProductCode;
		this.OrderName = OrderName;
		this.OrderQuantity = OrderQuantity;
		this.DeliveryDate = DeliveryDate;
		this.FoodLimit = FoodLimit;
	}
	public void setOrderDate(int OrderDate) {
		this.OrderDate = OrderDate;
	}

	public int getOrderDate() {
		return OrderDate;
	}
	
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}

	public String getOrderCode() {
		return OrderCode;
	}
	
	public void setProductCode(String ProductCode) {
		this.ProductCode = ProductCode;
	}

	public String getProductCode() {
		return ProductCode;
	}
	
	public void setOrderName(String OrderName) {
		this.OrderName = OrderName;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderQuantity(int OrderQuantity) {
		this.OrderQuantity = OrderQuantity;
	}

	public int getOrderQuantity() {
		return OrderQuantity;
	}

	public void setDeliveryDate(int DeliveryDate) {
		this.DeliveryDate = DeliveryDate;
	}

	public int getDeliveryDate() {
		return DeliveryDate;
	}

	

	public void setFoodLimit(int FoodLimit) {
		this.FoodLimit = FoodLimit;
	}

	public int getFoodLimit() {
		return FoodLimit;
	}

}
