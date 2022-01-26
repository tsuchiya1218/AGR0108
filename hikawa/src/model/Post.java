package model;

public class Post {

	private int postCode; //商品コード
	private String postName; //商品名

	public Post() {

	}

	public Post(int postCode, String postName) {
		this.postCode = postCode;
		this.postName = postName;
	}

	public void setpostCode(int postCode) {
		this.postCode = postCode;
	}

	public int getMakerID() {
		return postCode;
	}

	public void setpostName(String postName) {
		this.postName = postName;
	}

	public String getpostName() {
		return postName;
	}
}
