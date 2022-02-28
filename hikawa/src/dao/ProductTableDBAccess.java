package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductTable;

public class ProductTableDBAccess {
	Connection con;
	//ProductTable型のArrayList listを生成
	//最後にこのlistを返す
	public ArrayList<ProductTable> list = new ArrayList<ProductTable>();
	
	//商品表に表示するデータをデータベースから読み込む
	public ArrayList<ProductTable> getProductTable() throws Exception{
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();

		try {
			con = db.createConnection();
			
			String sql = "SELECT Status, ProductCode, ProductName, CategoryName, SellPrice, MakerName, Stock, LimitDate " 
					+ "FROM product " 
					+ "INNER JOIN maker ON product.MakerID = maker.MakerID "
					+ "INNER JOIN orderhistory ON product.OrderHistoryCode = orderhistory.OrderHistoryCode "
					+ "INNER JOIN category ON product.CategoryID = category.CategoryID "
					+ "INNER JOIN foodlimit ON product.FoodLimitCode = foodlimit.FoodLimitCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductTable(rs.getString("Status"),rs.getString("ProductCode"),rs.getString("ProductName"),
						rs.getString("CategoryName"),rs.getInt("SellPrice"),rs.getString("MakerName"),rs.getInt("Stock"),
						rs.getString("LimitDate")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("データベース接続のエラーです。");
		}catch (Exception e) {
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

