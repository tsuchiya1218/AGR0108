package model;

public class FoodLimit {

	private char FoodLimitCode; //食品期限コード
	private char LimitDate; //食品期限日
	private char LimitDisplay; //期限表示　消費か賞味か

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
