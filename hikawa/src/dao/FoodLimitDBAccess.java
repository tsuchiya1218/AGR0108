package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FoodLimitDBAccess {
	//食品期限を登録する
	public void regFoodLimit(String pCode, String date) throws SQLException {

		//食品期限の作成
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String flCode = createLimitCode();
		String sql = "INSERT INTO foodlimit VALUES('"+ flCode + "','" + date  + "','期限')";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
		
		//作成した食品期限を商品に登録する
		Connection con2 = null;
		PreparedStatement ps2 = null;
		DBAccess db2 = new DBAccess();
		String sql2 = "UPDATE product SET FoodLimitCode = '" + flCode + "' WHERE ProductCode = '" + pCode + "'";
		try {
			con2 = db2.createConnection();
			ps2 = con2.prepareStatement(sql2);
			ps2.executeUpdate();
			con2.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
		
		Connection con3 = null;
		PreparedStatement ps3 = null;
		DBAccess db3 = new DBAccess();
		String sql3 = "UPDATE orderhistory " 
				+ "INNER JOIN product ON orderhistory.OrderHistoryCode = product.OrderHistoryCode "
				+ "SET Status = '" + "確定" + "' WHERE ProductCode = '" + pCode +"'";
		try {
			con3 = db3.createConnection();
			ps3 = con3.prepareStatement(sql3);
			ps3.executeUpdate();
			con3.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
	}
	
	public String createLimitCode() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBAccess db = new DBAccess();
		String sql = "SELECT COUNT(*) AS cnt FROM foodlimit";
		int cnt = 0;
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
				db.closeConnection(con);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		cnt +=1;
		return String.valueOf(cnt);
	}
}
