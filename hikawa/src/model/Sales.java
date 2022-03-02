package model;

public class Sales {
	private String Date; //週
	private int Amount; //週合計

	public Sales() {

	}

	public Sales(String Date, int Amount) {
		this.Date = Date;
		this.Amount = Amount;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public String getDate() {
		return Date;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public int getAmount() {
		return Amount;
	}
}
