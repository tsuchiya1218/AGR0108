/*
 * DBから商品を検索するクラス
 *
 * 
 * */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ProductTable;


public class ProductSearchDBAccess{
	private Connection con;
	public ArrayList<ProductTable> productSerchByName(String productName) throws Exception{
		DBAccess db = new DBAccess();
		con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<ProductTable> list = new ArrayList<ProductTable>();
		try {
			/*
			表示項目(商品コード、商品名、カテゴリ、値段、メーカー名、在庫量、食品期限) 
			*/
			ps =con.prepareStatement("SELECT `Status`, ProductCode, ProductName, CategoryName, Price, MakerName, Stock, LimitDate " 
				+ "FROM product " 
				+ "INNER JOIN category ON product.CategoryID = category.CategoryID "
				+ "INNER JOIN maker ON maker.MakerID = product.MakerID " 
				+ "INNER JOIN foodlimit ON product.FoodLimitCode = foodlimit.FoodLimitCode " 
				+ "INNER JOIN orders ON orders.FoodLimitCo+de = foodlimit.FoodLimitCode "
				+ "INNER JOIN producttable ON orders.OrderCode = orders.OrderCode "
				+ "WHERE ProductName = ?");
			ps.setString(1,productName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductTable(rs.getString("Status"),rs.getString("ProductCode"),rs.getString("ProductName"),
						rs.getString("CategoryName"),rs.getInt("Price"),rs.getString("makerName"),rs.getInt("Stock"),
						rs.getString("LimitDate")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			db.closeConnection(con);
		}
		return list;
	}
	
	
}

