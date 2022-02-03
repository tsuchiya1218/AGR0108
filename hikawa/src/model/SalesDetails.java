package model;

public class SalesDetails {

	private int SalesDate; //売上日付

	private int SalesAmount; //売上金額

	public SalesDetails() {

	}

	public SalesDetails(int SalesDate, int SalesAmount) {
		this.SalesDate = SalesDate;
		this.SalesAmount = SalesAmount;

	}

	public void setSalesDate(int SalesDate) {
		this.SalesDate = SalesDate;
	}

	public int getSalesDate() {
		return SalesDate;
	}

	public void setSalesAmount(int SalesAmount) {
		this.SalesAmount = SalesAmount;
	}

	public int getSalesAmount() {
		return SalesAmount;
	}

}
