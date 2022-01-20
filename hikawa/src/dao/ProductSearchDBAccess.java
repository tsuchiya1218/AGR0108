/*
 * DBから商品を検索するクラス
 */

package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Product;


public class ProductSearchDBAccess{
	private Connection con;
	//DBAccess db = new DBAccess();
	//ResultSet rs = null;
	//PreparedStatement ps = null;
	public ArrayList<Product> productSerchByName(String productName) throws Exception{
		DBAccess db = new DBAccess();
		con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			ps =con.prepareStatement("SELECT ProductCode, ProductName, Price, ");
			//SQLメモ(SELECT * FROM product INNER JOIN category ON product.CategoryID = category.CategoryID;)
		}catch{
	}
}

