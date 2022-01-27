package model;

public class Staff {
	private int StaffID; //従業員番号
	private String PassWord; //パスワード
	private int PostCode; //役職番号

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
