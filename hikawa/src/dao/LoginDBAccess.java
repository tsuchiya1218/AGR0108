/*
 * DBAccessでデータベースに接続し、
 * ユーザーがログイン画面で入力したStaffIDからDBのパスワード検索し、
 * DBのパスワードとユーザーが入力したパスワードを照合するクラス
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDBAccess {
	
	
	public String getDBPass(int StaffID) throws Exception {
		DBAccess db = new DBAccess();		
		ResultSet rs = null;
		PreparedStatement ps = null;
		String DBPass = null;
		try {
			//DB接続
			Connection con = db.createConnection();
			//SQLでDBからパスワードを検索
			ps = con.prepareStatement("SELECT password FROM staff WHERE StaffID = ?");
			ps.setInt(1, StaffID);
			rs = ps.executeQuery();
			
			//DBPassにDBで検索したパスワードを入れる
			while(rs.next()) {
				if (rs.getString("password") != null) {
					DBPass = rs.getString("password");
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			db.closeConnection(db.con);
		}
		return DBPass;
	}
	public boolean login(int input_StaffID, String input_password) throws Exception {
		//input_StaffID及びinput_passwordはユーザーがログイン画面で入力した値
		//↓DBのパスワードと入力されたパスワードが同じか
		if (getDBPass(input_StaffID) == null) { //DBにパスワードが存在しない(NULL)の場合
			return false;
		}else if( getDBPass(input_StaffID).equals(input_password)){
			return true;
		}else {
			return false;
		}
	}
	

}
