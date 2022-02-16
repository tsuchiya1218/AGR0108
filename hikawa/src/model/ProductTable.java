package model;

public class ProductTable {
	private int ProductTableID; //商品表ID
	private String Status;//状態
	private String ProductCode;//商品コード
	private String pName;//商品名
	private String cName;//カテゴリ名
	private int Price;//販売価格
	private String mName;//メーカー名
	private String lDate;//食品期限
	private int Stock; //在庫量
	private int purPrice; //仕入れ価格
	private String OrderCode; //発注コード

	public ProductTable() {
	}

	public ProductTable(int ProductTableID, int Stock, int purPrice, String OrderCode) {
		this.ProductTableID = ProductTableID;
		this.Stock = Stock;
		this.purPrice = purPrice;
		this.OrderCode = OrderCode;
	}
	
	public ProductTable(String Status, String ProductCode, String pName, String cName, int Price, String mName, int Stock, String lDate) {
		this.Status = Status;
		this.ProductCode = ProductCode;
		this.pName = pName;
		this.cName = cName;
		this.Price = Price;
		this.mName = mName;
		this.Stock = Stock;
		this.lDate = lDate;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlDate() {
		return lDate;
	}

	public void setlDate(String lDate) {
		this.lDate = lDate;
	}

	public int getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(int purPrice) {
		this.purPrice = purPrice;
	}

	public void setProductTableID(int ProductTableID) {
		this.ProductTableID = ProductTableID;
	}

	public int getProductTableID() {
		return ProductTableID;
	}

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	public int getStock() {
		return Stock;
	}

	public void setPrice(int purPrice) {
		this.purPrice = purPrice;
	}

	public int getPrice() {
		return Price;
	}
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}

	public String getOrderCode() {
		return OrderCode;
	}
}
