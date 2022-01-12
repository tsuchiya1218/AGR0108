package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAccess {
	//データベース接続
			String url = "";
			String user = "";
			String pass = "";
			DriverManager out;
	
	private Connection con =null;

	public Connection createConnection() throws Exception {
			con = DriverManager.getConnection(url,user,pass);
			return con;
	}
	public void closeConnection(Connection con) throws Exception{
		//データベースクローズ
		con = DriverManager.getConnection(url,user,pass);
	}
}
