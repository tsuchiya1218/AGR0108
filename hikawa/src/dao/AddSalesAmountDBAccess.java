package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddSalesAmountDBAccess {
	PreparedStatement ps = null;
	String week = null;
	String date = null ;
	int amount = 0;
	DBAccess db = new DBAccess();
	Connection con = null;
	
	//売り上げを入力し売上表に追加する
	public void addSalesAmount() {
		try {
			con = db.createConnection();
			//INSERT INTO テーブル名 (列名1, 列名2,...) VALUES (値1, 値2,...);
			ps = con.prepareStatement("INSERT INTO salesdetails (Week,SalesAmount,SalesDate) VALUES(?,?,?)");
			ps.setString(1, week);
			ps.setInt(2, amount);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
