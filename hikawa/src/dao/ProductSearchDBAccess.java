/*
 * DBから商品を検索するクラス
 * 未完成・後回し
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DisplayProductTable;


public class ProductSearchDBAccess{
	private Connection con;
	//DBAccess db = new DBAccess();
	//ResultSet rs = null;
	//PreparedStatement ps = null;
	public ArrayList<DisplayProductTable> productSerchByName(String productName) throws Exception{
		DBAccess db = new DBAccess();
		con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<DisplayProductTable> list = new ArrayList<DisplayProductTable>();
		try {
			/*
			表示項目(商品コード、商品名、カテゴリ、値段、メーカー名、在庫量、食品期限) 
			*/
			ps =con.prepareStatement("SELECT ProductCode, ProductName, CategoryName, Price, MakerName, Stock, LimitDate"
				+ "FROM producttable INNER JOIN product ON product.ProductCode = producttable.ProductCode "
				+ "INNER JOIN category ON product.CategoryID = category.CategoryID "
				+ "INNER JOIN maker ON product.MakerID = maker.makerID"
				+ "INNER JOIN foodlimit ON product.FoodLimitCode = foodlimit.FoodLimitCode"
				+ "WHERE ProductName = ?");
			ps.setString(1,productName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new DisplayProductTable(rs.getString("ProductCode"),rs.getString("ProductName"),
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

