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
			 sql = "UPDATE orders SET OrderQuantity = " + getQuantity(newCode) + " WHERE PoductCode = '" + newCode +"'";
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
		/*Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		PreparedStatement ps2 = null;
		DBAccess db = new DBAccess();
		try {
			//商品がすでに発注表に存在する場合、発注表の個数を変更する
			if(checkSameProduct(pCode)) {
				int Quantity = 0;
				con = db.createConnection();
				String sql1 = "SELECT OrderStock FROM ordertable WHERE ProductCode = '" + pCode + "'";
				ps1 = con.prepareStatement(sql1);
				rs1 = ps1.executeQuery();
				while(rs1.next()) {
					Quantity = rs1.getInt("OrderStock");
				}
				
				Quantity = Quantity + 1;
				
				String sql2 = "UPDATE ordertable SET OrderStock = " + Quantity + " WHERE ProductCode = '" +pCode +"'" ;
				ps2 = con.prepareStatement(sql2);
				ps2.executeUpdate();
				con.commit();
			//商品が発注表にない場合
			}else {
				try {
					con = db.createConnection();
					String pName = null;
					pName = serchPName(pCode);//商品名
					if(pName != null) {
						int Quantity = 1;//個数
						//INSER文
						ps1 = con.prepareStatement("INSERT INTO ordertable(ProductCode,ProductName,OrderStock) VALUES("
								+"'"+ pCode +"' , '"+ pName +"' , '" + Quantity + "' )");
						//SQL実行
						ps1.executeUpdate();
						//コミット
						con.commit();
					}else {
						System.out.println("存在しない商品コードが入力されました");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					//ロールバック
					con.rollback();
				}finally {
					if(ps1 != null) {
						try {
							ps1.close();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
					//データベース切断
					db.closeConnection(con);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
	//ordersから個数を出す
	public int getQuantity(String newCode) {
		int quantity = 0;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		String sql = "SELECT OrderQuantity FROM orders WHERE ProductCode = " + newCode;
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
		return quantity;
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
	
	//すでに発注表に商品があるかチェックする。
	//すでに商品がある場合trueを返す。
	public boolean checkSameProduct(String pCode) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBAccess db = new DBAccess();
		int cnt = 0;
		String SQL = "SELECT COUNT(*) AS cnt FROM ordertable WHERE ProductCode = '" + pCode +"'" ;
		try {
			con = db.createConnection();
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		}catch (Exception e) {
			// TODO: handle exception
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
		if(cnt > 0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	//発注表の同一商品コードがあるか
	
	
	
	//発注表を抽出しlistで返す
	public ArrayList<Order> getOrderTable() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
		//SQL文
		String sql = "SELECT * FROM ordertable";
		
		try {
			con = db.createConnection();
			//SQL実行
			ps = con.prepareStatement(sql);
			//実行結果をrsに
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(rs.getString("ProductCode"),rs.getString("ProductName"),rs.getInt("OrderStock")));
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
		String sql = "DELETE FROM ordertable";
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
