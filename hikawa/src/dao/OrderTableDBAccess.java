/*
 * 発注表に追加
 */

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;

public class OrderTableDBAccess {
	//発注表に商品を追加するメソッド
	//引数pCodeは商品コード
	public void addOrderTable(String pCode) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String sql = null;
		String pCodeOmit = pCode.substring(0, 6);//商品コードの下2桁省いたやつ
		String newCode = pCodeOmit + "01";
		try {
			//発注表にすでに商品がないなら
		 if(PDCodeCount.getPCodeCount("Orders", pCodeOmit) == 0) {
			 sql = "INSERT INTO orders(OrderCode,OrderQuantity,ProductCode) "
					 + "VALUES('" + makeOrderCode() + "'," + 1 + ",'" + newCode +"')";
		 }else {
			 sql = "UPDATE orders SET OrderQuantity = " + getQuantity(newCode) + " WHERE ProductCode = '" + newCode +"'";
		 }
		 con = db.createConnection();
		 ps = con.prepareStatement(sql);
		 ps.executeUpdate();
		 con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
	}
		
	//ordersから個数を出す
	public int getQuantity(String newCode) {
		int quantity = 0;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String sql = "SELECT OrderQuantity FROM orders WHERE ProductCode = '" + newCode + "'";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				quantity = rs.getInt("OrderQuantity");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("getQuantity()のエラー");
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return quantity + 1;
	}
	
	//OderCode生成
	public String makeOrderCode() {
		int orderCode = 1;
		int count = 0;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String sql = "SELECT COUNT(*) AS cnt FROM orders";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		orderCode += count;
		return String.valueOf(orderCode);
	}
	
	
	//商品コードから商品名を検索し返すメソッド
	public String serchPName(String pCode) throws Exception {
		String pName = null;//商品名
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess(); 
		//SQL文
		String sql = "SELECT ProductName FROM product WHERE ProductCode LIKE '%" + pCode +"%'";
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
	
	
	//発注表を抽出しlistで返す
	public ArrayList<Order> getOrders() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
		//SQL文
		String sql = "SELECT orders.ProductCode, ProductName, OrderQuantity FROM orders "
				+ "INNER JOIN product ON product.ProductCode = orders.ProductCode ";
		
		try {
			con = db.createConnection();
			//SQL実行
			ps = con.prepareStatement(sql);
			//実行結果をrsに
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(rs.getString("ProductCode"),rs.getString("ProductName"),rs.getInt("OrderQuantity")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			db.closeConnection(con);
		}
		return list;
	}
	
	//発注表の削除
	public void deleteOrderTable() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String sql = "DELETE FROM orders";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				db.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
