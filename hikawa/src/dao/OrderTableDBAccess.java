/*
 * 発注表に追加
 */

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderTableDBAccess {

	//発注表に商品を追加するメソッド
	//引数pCodeは商品コード
	public void addOrderTable(String pCode) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		try {
			con = db.createConnection();
			String pName = serchPName(pCode);//商品名
			int Quantity = 0;//個数
			//INSER文
			ps = con.prepareStatement("INSERT INTO ordertable(ProductCode,ProductName,OrderStock) VALUES("
					+ pCode +" , "+ pName +" , " + Quantity + " )");
			//SQL実行
			ps.executeUpdate();
			//コミット
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
			//ロールバック
			con.rollback();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			//データベース切断
			db.closeConnection(con);
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
		String sql = "SELECT ProductName FROM product "
				+ "WHERE ProductCode = \"" + pCode + "\"";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			//SQL実行
			rs = ps.executeQuery();
			
			//DBから抽出した商品名をpNameに入れる
			while(rs.next()) {
				pName = rs.getString("ProductName");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			//データベースクローズ
			db.closeConnection(con);
		}
		return pName;
	}
	
	//発注表の個数を更新する
	public void updateQuantity(String pCode, int quantity) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		//個数を更新するSQL文
		String sql = "UPDATE ordertable SET OrderStock = " + quantity + " WHERE ProductCode = " + pCode;
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			//SQL実行
			ps.executeQuery();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			if(ps != null) {
				ps.close();
			}
		}
		try {
			db.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
