/*
 * DBAccessでデータベースに接続し、
 * ユーザーがログイン画面で入力したStaffIDからDBのパスワード検索し、
 * DBのパスワードとユーザーが入力したパスワードを照合するクラス
 */

import model.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

package dao;

public class LoginDBAccess {
	
	DBAccess db = new DBAccess();		
	ResultSet rs = null;
	PreparedStatement ps = null;
	public String getDBPass(int StaffID) {
		try {
			//DB接続
			db.createConection();
			//SQLでDBからパスワードを検索
			ps = db.prepareStatement("SELECT password FROM staff WHERE StaffID = ?");
			ps.setString(1, StaffID);
			rs = ps.executeQuery();
			
			String DBPass = null;
			//DBPassにDBで検索したパスワードを入れる
			while(rs.next()) {
				if (rs.getString("password") != null) {
					DBPass = rs.getString("password");
				}
			}
			
		}
		return DBPass;
	}
	public boolean login(int input_StaffID, String input_password) {
		//input_StaffID及びinput_passwordはユーザーがログイン画面で入力した値
		//↓DBのパスワードと入力されたパスワードが同じか
		if (getDBPass(input_StaffID).equals(input_password)) {
			return true;
		}else {
			return false;
		}
	}
	

}
