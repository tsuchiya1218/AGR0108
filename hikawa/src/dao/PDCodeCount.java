package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PDCodeCount {
	public static int getPCodeCount(String tableName, String pCode) {
		/*
		 * 引数(検索するテーブル名,商品コード)
		 * テーブル名はデータベースのテーブル名(product,orders等)
		 * 商品コードは1部でも可(01_001など)
		 */
		
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		int cnt = 0;
		String sql = "SELECT COUNT(*) AS cnt FROM " + tableName +"WHERE ProductCode LIKE '%" + pCode + "%'";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" getPCodeCount()のエラーです");
		}
		return cnt;	
	}
}
	
