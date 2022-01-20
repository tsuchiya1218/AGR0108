package model;

public class Maker {

	private char MakerID; //商品コード
	private String MakerName; //商品名

	public Maker() {

	}

	public Maker(char MakerID, String MakerName) {
		this.MakerID = MakerID;
		this.MakerName = MakerName;
	}

	public void setMakerID(char MakerID) {
		this.MakerID = MakerID;
	}

	public char getMakerID() {
		return MakerID;
	}

	public void setMakerName(String MakerName) {
		this.MakerName = MakerName;
	}

	public String getMakerName() {
		return MakerName;
	}
}
