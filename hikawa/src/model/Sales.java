package model;

public class Sales {

	private String Day; //週
	private int Amount; //週合計

	public Sales(String Day, int Amount) {
		this.Day = Day;
		this.Amount = Amount;
	}

	public void setWeek(String Day) {
		this.Day = Day;
	}

	public String getDay() {
		return Day;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public int getAMount() {
		return Amount;
	}
}
