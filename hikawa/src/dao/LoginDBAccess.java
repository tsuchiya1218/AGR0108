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
	
	String DBPass = null;
	public void getDBPass() {
		try {
			//DB接続
			db.createConection();
			//SQLでパスワードを検索
			ps = db.prepareStatement("SELECT password FROM staff WHERE StaffID = ?");
			ps.setString(1, /*入力されたStaffID*/);
			
			rs = ps.executeQuery();
			//DBPassにDBで検索したパスワードを入れる
			DBPass = rs.getString("password"); 
		}
		return DBPass;
	}
	public boolean login() {
		if (getDBPass().equals(/*入力されfdたパスワード*/)) {
			return true;
		}else {
			return false;
		}
	}
	

}
