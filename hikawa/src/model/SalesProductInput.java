package model;

public class SalesProductInput {
	private String SPName; //商品名

	public SalesProductInput() {
	}

	public SalesProductInput(String SPName) {
		this.SPName = SPName;
	}

	public void setSalesPdName(String SPName) {
		this.SPName = SPName;
	}

	public String getSPName() {
		return SPName;
	}
}
