package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAccess {
	public Connection con =null;
	private String url = "jdbc:mysql://10.64.144.5:3306/20jy0111";
	private String name = "20jy0111";
	private String password = "20jy0111";

	public Connection createConnection() throws Exception {
		try {
			//データベース接続
			con = DriverManager.getConnection(url,name,password);

			//autoコミットオフ
			con.setAutoCommit (false);


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

