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
		String[][] orderlist = CreateTableData.orderTableToArray(ot.getOrderTable());
		int listSize = orderlist.length;
		
		//OrderCodeを生成する
		String[] orderCodes = new String[listSize];//発注コード
		//発注日を今日の日付に設定
		LocalDate orderDate = LocalDate.now();//発注日
		
		String[] pCode = new String[listSize];//商品コード
		String[] pName = new String[listSize];//商品名
		String[] quantity = new String[listSize];//個数
		String DeliveryDate = null;//納品予定
		String Status = "確定";
		String FoodLimitCode = null;
		
		for(int i = 0; i < listSize; i++) {
			orderCodes[i] = createOrderCode(i);
			pCode[i] = orderlist[i][0];
			pName[i] = orderlist[i][1];
			quantity[i] = orderlist[i][2];
		}
		for(int i = 0; i<listSize; i++) {
			
			String sql = "INSERT INTO orders (OrderCode,OrderDate,OrderQuantity,DeliveryDate,Status,FoodLimitCode,ProductCode) "
					+ "VALUE('" 
					+ orderCodes[i] +"','" + orderDate+ "','" + quantity[i] + "','" + DeliveryDate +"','" + Status + "','" 
					+ FoodLimitCode +"','" +pCode[i]  +"')";
			try {
				DBAccess db = new DBAccess();
				PreparedStatement ps = null;
				con = db.createConnection();
				ps = con.prepareStatement(sql);
				ps.executeQuery();
			}catch (Exception e) {
				e.printStackTrace();
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
		String sql = "SELECT COUNT(*) FROM orders";
		try {
			con = db.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
			count = count + i ;
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBAccess db = new DBAccess();
		try {
			con = db.createConnection();
			//発注日、発注コード、商品コード、発注商品(商品名)、個数、納品予定日
			String sql = "SELECT OrderDate, OrderCode orders.ProductCode, ProductName, OrderQuantity, DeliveryDate"
						+ "FROM orders"
						+ "INNDER JOIN product ON orders.ProductCode = product.ProductCode";
			ps = con.prepareStatement(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
