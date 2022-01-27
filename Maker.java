package model;

public class Maker {

	private char MakerID; //メーカーID
	private String MakerName; //メーカー名

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
