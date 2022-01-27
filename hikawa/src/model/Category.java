package model;

public class Category {

	private char CategoryID; //カテゴリID
	private String CategoryName; //カテゴリ名

	public Category() {

	}

	public Category(char CategoryID, String CategoryName) {
		this.CategoryID = CategoryID;
		this.CategoryName = CategoryName;
	}

	public void setCategoryID(char CategoryID) {
		this.CategoryID = CategoryID;
	}

	public char getCategoryID() {
		return CategoryID;
	}

	public void setCategoryName(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public String getCategoryName() {
		return CategoryName;
	}
}