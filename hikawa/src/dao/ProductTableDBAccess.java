package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ProductTable;

public class ProductTableDBAccess {
	Connection con;
	public ArrayList<ProductTable> list = new ArrayList<ProductTable>();
	
	
	public ArrayList<ProductTable> getProductTable() throws Exception{
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();

		try {
			con = db.createConnection();
			
			String sql = "SELECT `status`, ProductCode, ProductName, CategoryName, Price, MakerName, Stock, LimitDate " 
					+ "FROM product " 
					+ "INNER JOIN category ON product.CategoryID = category.CategoryID "
					+ "INNER JOIN maker ON maker.MakerID = product.MakerID " 
					+ "INNER JOIN foodlimit ON product.FoodLimitCode = foodlimit.FoodLimitCode " 
					+ "INNER JOIN orders ON orders.FoodLimitCode = foodlimit.FoodLimitCode "
					+ "INNER JOIN producttable ON orders.OrderCode = orders.OrderCode ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductTable(rs.getString("Status"),rs.getString("ProductCode"),rs.getString("ProductName"),
						rs.getString("CategoryName"),rs.getInt("Price"),rs.getString("makerName"),rs.getInt("Stock"),
						rs.getString("LimitDate")));
			}
		} catch (Exception e) {
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
	
	public static String[][] productTableToArray(ArrayList<ProductTable> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][8];

		for (int i = 0; i < listSize; i++) {
			ProductTable pt = list.get(i);
			tableData[i][0] = pt.getStatus();
			tableData[i][1] = pt.getProductID();
			tableData[i][2] = pt.getProductName();
			tableData[i][3] = pt.getCategory();
			tableData[i][4] = Integer.toString(pt.getPrice());
			tableData[i][5] = pt.getmName();
			tableData[i][6] = Integer.toString(pt.getStock());
			tableData[i][7] = pt.getLimit();
		}
		return tableData;

	}

}

