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
		
		public  Product(int PdCode,String PdName,String Category,int Price,String Maker,int Stock,String Expiration,String ExpirationDate) {
			this.PdCode = PdCode;
			
			
		}
		
}
