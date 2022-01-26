package model;

public class Sales {

	private int SalesCode; //商品コード
	private int wTotol; //商品名
	private int mTotal; //商品名
	private int yTotal; //商品名
	private String Week; //商品名
	
	public Sales() {
	}

	public Sales(int SalesCode, int wTotol, int mTotal, int yTotal, String Week) {
		this.SalesCode = SalesCode;
		this.wTotol = wTotol;
		this.mTotal = mTotal;
		this.yTotal = yTotal;
		this.Week   = Week;
	}

	public void setSalesCode(int SalesCode) {
		this.SalesCode = SalesCode;
	}

	public int SalesCode() {
		return SalesCode;
	}

	public void setwTotol(int wTotol) {
		this.wTotol = wTotol;
	}

	public int getwTotol() {
		return wTotol;
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
}
