package model;

public class Sales {

	private int SalesCode; //売上コード
	private int wTotal; //週合計
	private int mTotal; //月合計
	private int yTotal; //年合計
	private String Week; //週
	private int Day; //日付
	private int Sale; //売上金額
	
	public Sales() {
	}

	public Sales(int SalesCode, int wTotal, int mTotal, int yTotal, String Week,int Day, int Sale ) {
		this.SalesCode = SalesCode;
		this.wTotal = wTotal;
		this.mTotal = mTotal;
		this.yTotal = yTotal;
		this.Week   = Week;
		this.Day = Day;
		this.Sale   = Sale;
	}

	public void setSalesCode(int SalesCode) {
		this.SalesCode = SalesCode;
	}

	public int SalesCode() {
		return SalesCode;
	}

	public void setwTotal(int wTotal) {
		this.wTotal = wTotal;
	}

	public int getwTotal() {
		return wTotal;
	}

	public void setmTotal(int mTotal) {
		this.mTotal = mTotal;
	}

	public int getmTotal() {
		return mTotal;
	}
	public void setyTotal(int yTotal) {
		this.yTotal = yTotal;
	}

	public int getyTotal() {
		return yTotal;
	}
	
	public void setWeek(String Week) {
		this.Week = Week;
	}

	public String getWeek() {
		return Week;
	}
	
	public void setDay(int Day) {
		this.Day = Day;
	}

	public int getDay() {
		return Day;
	}
	public void setSale(int Sale) {
		this.Sale = Sale;
	}

	public int getSale() {
		return Sale;
	}
}
