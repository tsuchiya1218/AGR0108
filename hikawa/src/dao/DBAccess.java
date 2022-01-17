package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAccess {
	private Connection con =null;

	public Connection createConnection() throws Exception {
		try {
			//データベース接続
			con = DriverManager.getConnection("jdbc:mysql://10.64.144.5:3306/20jy0125","20jy0125","20jy0125");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
			
	}
	public void closeConnection(Connection con) throws Exception{
		if(con != null) {
			try{
				//データベースクローズ
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

