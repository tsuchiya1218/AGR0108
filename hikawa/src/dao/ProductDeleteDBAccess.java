package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDeleteDBAccess {
	String pCode = null;

	public ProductDeleteDBAccess() {

	}

	public ProductDeleteDBAccess(String pCode) {
		//引数(商品コード)
		this.pCode = pCode;
	}

	//商品を削除する
	public void ProductDelete() throws Exception {
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;

		try {
			con = db.createConnection();
			String sql = "UPDATE product SET Invailed = 1 WHERE ProductCode =  '" + pCode + "'";

			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				db.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//商品コードから商品名を検索し返すメソッド
	public String serchPName(String pCode) throws Exception {
		String pName = null;//商品名
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		//SQL文
		String sql = "SELECT ProductName FROM product WHERE ProductCode LIKE '%" + pCode + "%' AND Invailed = 0";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			//SQL実行
			rs = ps.executeQuery();

			//DBから抽出した商品名をpNameに入れる
			while (rs.next()) {
				pName = rs.getString("ProductName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//データベースクローズ
			db.closeConnection(con);
		}
		return pName;
	}

}
