package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import action.CreateTableData;
import model.OrderHistory;

//発注履歴のデータベースアクセス
public class OrderHistoryDBAccess {
	
	/*
	 * 表示画面項目:発注日、発注コード、商品コード、発注商品(商品名)、個数、納品予定日
	 * DB項目:OrderCode,OrderDate,OrderQuantity,DeliveryDate,Status,FoodLimitCode
	 */
	
	//発注履歴を追加する
	//発注表をを参照し、発注表のデータを含め発注履歴に追加する。
	//発注履歴に残すことが確認出来たら発注表のデータを消す？
	public void addOrderHistory() throws Exception {
		Connection con = null;

		OrderTableDBAccess ot = new OrderTableDBAccess();
		String[][] orderlist = CreateTableData.orderTableToArray(ot.getOrders());
		int listSize = orderlist.length;
		
		//OrderCodeを生成する
		String[] orderCodes = new String[listSize];//発注コード
		//発注日を今日の日付に設定
		LocalDate orderDate = LocalDate.now();//発注日
		
		String[] pCode = new String[listSize];//商品コード
		String[] pName = new String[listSize];//商品名
		String[] quantity = new String[listSize];//個数
		String DeliveryDate = "未定";//納品予定
		String Status = "発注中";
		
		for(int i = 0; i < listSize; i++) {
			orderCodes[i] = createOrderCode(i);
			pCode[i] = orderlist[i][0];
			pName[i] = orderlist[i][1];
			quantity[i] = orderlist[i][2];
			
		}
		
		for(int i = 0; i<listSize; i++) {
			
			String sql = "INSERT INTO orderhistory (OrderHistoryCode,OrderDate,Quantity,DeliveryDate,Status) "
					+ "VALUE('" 
					+ orderCodes[i] +"','" + orderDate+ "'," + quantity[i] + ",'" + DeliveryDate +"','" + Status + "')" ;
			DBAccess db = new DBAccess();
			PreparedStatement ps = null;
			try {
				con = db.createConnection();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				con.commit();
				//商品表に商品を追加する
				addProduct(orderCodes[i], pCode[i], quantity[i]);
			}catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}finally {
				try {
					if(ps != null) {
						ps.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	//発注コードを作成
	public String createOrderCode(int i) {
		Connection con = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		int count = 1;
		String sql = "SELECT COUNT(*) FROM orderhistory";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(*)") + 1 +i;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
				db.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return Integer.toString(count);
	}
	
	//発注履歴の表示
	public ArrayList<OrderHistory> getOrderHistory(){
		ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBAccess db = new DBAccess();
		try {
			con = db.createConnection();
			//発注日、発注コード、商品コード、発注商品(商品名)、個数、納品予定日
			String sql = "SELECT OrderDate, OrderCode, 'orders.ProductCode' , ProductName, OrderQuantity, DeliveryDate "
					+ "FROM orders "
					+ "INNDER JOIN product ON 'orders.ProductCode' = product.ProductCode;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderHistory(rs.getString("OrderDate"),rs.getString("OrderCode"),rs.getString("orders.ProductCode"),
						rs.getString("ProductName"),rs.getInt("OrderQuantity"),rs.getString("DeliveryDate")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
				db.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
		}
		return list;
	}
	
	public void addProduct(String OHCode, String pCode, String quantity) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		
		ResultSet rs = null;
		DBAccess db = new DBAccess();
		
		int cnt = PDCodeCount.getPCodeCount("product", pCode.substring(0, 6)) +1; 
		String newCode = null;
		if (cnt < 10) {
			newCode = pCode.substring(0, 6) + "0" + cnt ;
		}else{
			newCode = pCode.substring(0, 6) + cnt;
		}
		
		String pName = null;
		int SellPrice = 0;
		int PurPrice = 0;
		String mID = null;
		String cID = null;
		
		String sql = "SELECT * FROM product WHERE ProductCode = '" + pCode + "'";
		String sql2 = null;
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				pName = rs.getString("ProductName");
				SellPrice = rs.getInt("SellPrice");
				PurPrice = rs.getInt("PurPrice");
				mID = rs.getString("MakerID");
				cID = rs.getString("CategoryID");
			}
			
			sql2 = "INSERT INTO product "
					+ "(ProductCode, ProductName, SellPrice, Stock, Invailed, PurPrice, FoodLimitCode, MakerID, CategoryID, OrderHistoryCode) "
					+ "VALUES( '" + newCode + "','" + pName + "'," + SellPrice + ",'"
					+ quantity + "'," + 0 + "," + PurPrice + ",'00','" + mID + "','" 
					+ cID + "','" + OHCode + "')" ;
			System.out.println(sql2);
			con2 = db.createConnection();
			ps2 = con2.prepareStatement(sql2);
			ps2.executeUpdate();
			con2.commit();
		} catch (Exception e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
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
	}
}
