package model;

/**
 * クラス名：	Product
 * 概要：	商品情報
//aaaaa
 */

public class Product extends Object{
		private int PdCode; //商品コード
		private String PdName; //商品名
		private String Category; //カテゴリー
		private int Price; //値段
		private String Maker; //メーカー
		private int Stock; //在庫量
		private String Expiration; //期限カテゴリー
		private int ExpirationDate; //食品期日
		
		
		public Product() {
			
		}
		
		public  Product(int PdCode,String PdName,String Category,int Price,String Maker,
				          int Stock,String Expiration,int ExpirationDate) {
			this.PdCode = PdCode;
			this.PdName = PdName;
			this.Category = Category;
			this.Price = Price;
			this.Maker = Maker;
			this.Stock = Stock;
			this.Expiration = Expiration ;
			this.ExpirationDate = ExpirationDate;
		}
		
		
		public void setCustId(int PdCode) {
			this.PdCode = PdCode;
		}
		
		public  int getPdCode() {	
			return PdCode ;
		}
		
		public void setPdName(String PdName) {
			this.PdName = PdName;
		}
		
		public  String getPdName() {	
			return PdName ;
		}
		
		public void setCategory(String Category) {
			this.Category = Category ;
		}
		
		public  String getCategory() {	
			return Category ;
		}
		
		public void setPrice(int Price) {
			this.Price = Price ;
		}
		
		public  int getPrice() {	
			return Price ;
		}
		
		public void setMaker(String Maker) {
			this.Maker = Maker ;
		}
		
		public  String getMaker() {	
			return Maker ;
		}
		
		public void setStock(int Stock) {
			this.Stock = Stock ;
		}
		
		public  int getStock() {	
			return Stock ;
		}
		
		public void setExpiration(String Expiration) {
			this.Expiration = Expiration ;
		}
		
		public  String getExpiration() {	
			return Expiration ;
		}
		
		public void setExpirationDate(int ExpirationDate) {
			this.ExpirationDate = ExpirationDate ;
		}
		
		public  int getExpirationDate() {	
			return ExpirationDate ;
		}
}