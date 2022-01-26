package model;

public class SalesDetails {
	
	private  String Week; //商品コード
	private int SalesAmount; //商品名
	private String SalesDate; //商品名

	public SalesDetails() {

	}

	public SalesDetails(String Week, int SalesAmount, String SalesDate) {
		this.Week = Week;
		this.SalesAmount = SalesAmount;
		this.SalesDate = SalesDate;
	}

	public void setWeek(String Week) {
		this.Week = Week;
	}

	public String getWeek() {
		return Week;
	}

	public void setSalesAmount(int SalesAmount) {
		this.SalesAmount = SalesAmount;
	}

	public int getSalesAmount() {
		return SalesAmount;
	}

	public void setSalesDate(String SalesDate) {
		this.SalesDate = SalesDate;
	}

	public String getSalesDate() {
		return SalesDate;
	}

}
