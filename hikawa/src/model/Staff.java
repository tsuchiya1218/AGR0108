package model;

public class Staff {
	private int StaffID; //商品コード
	private String PassWord; //商品名
	private int PostCode; //商品名

	public Staff() {

	}

	public Staff(int StaffID, String PassWord, int PostCode) {
		this.StaffID = StaffID;
		this.PassWord = PassWord;
		this.PostCode = PostCode;
	}

	public void setStaffID(int StaffID) {
		this.StaffID = StaffID;
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setPassWord(String PassWord) {
		this.PassWord = PassWord;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPostCode(int PostCode) {
		this.PostCode = PostCode;
	}

	public int getPostCode() {
		return PostCode;
	}

}
