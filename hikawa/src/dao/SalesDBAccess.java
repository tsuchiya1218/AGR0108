package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sales;

public class SalesDBAccess {

	Connection con;
	//ProductTable型のArrayList listを生成
	//最後にこのlistを返す
	public ArrayList<Sales> list = new ArrayList<Sales>();
	
	//売上表に表示するデータをデータベースから読み込む
	public ArrayList<Sales> getSales() throws Exception{
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		
		try {
			con = db.createConnection();
			
			String sql = "SELECT date, amount" 
					+ "FROM sales";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Sales(rs.getString("date"),
									rs.getInt("amount")));
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

	public Object getSaleTable() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
