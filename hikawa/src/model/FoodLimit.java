package model;

public class FoodLimit {

	private char FoodLimitCode; //商品コード
	private char LimitDate; //商品名
	private char LimitDisplay; //商品名

	public FoodLimit() {

	}

	public FoodLimit(char FoodLimitCode, char LimitDate, char LimitDisplay) {
		this.FoodLimitCode = FoodLimitCode;
		this.LimitDate = LimitDate;
		this.LimitDisplay = LimitDisplay;
	}

	public void setFoodLimitCode(char FoodLimitCode) {
		this.FoodLimitCode = FoodLimitCode;
	}

	public char getFoodLimitCode() {
		return FoodLimitCode;
	}

	public void setLimitDate(char LimitDate) {
		this.LimitDate = LimitDate;
	}

	public char getLimitDate() {
		return LimitDate;
	}

	public void setLimitDisplay(char LimitDisplay) {
		this.LimitDisplay = LimitDisplay;
	}

	public char getLimitDisplay() {
		return LimitDisplay;
	}
}
