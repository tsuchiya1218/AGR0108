package model;

public class Login {

	private int EmpNum; //従業員番号
	private String Pass; //パスワード

	public Login() {

	}

	public Login(int EmpNum, String Pass) {
		this.EmpNum = EmpNum;
		this.Pass = Pass;
	}

	public void setEmpNum(char EmpNum) {
		this.EmpNum = EmpNum;
	}

	public int getEmpNum() {
		return EmpNum;
	}

	public void setLimitDate(String Pass) {
		this.Pass = Pass;
	}

	public String getPass() {
		return Pass;
	}
}
