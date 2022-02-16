package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

//発注履歴のデータベースアクセス
public class OrderHistoryDBAccess {
	
	/*
	 * 表示画面項目:発注日、発注コード、商品コード、発注商品(商品名)、個数、納品予定日
	 * DB項目:OrderCode,OrderDate,OrderQuantity,DeliveryDate,Status,FoodLimitCode
	 */
	
	//発注履歴を追加する
	//発注表をを参照し、発注表のデータを含め発注履歴に追加する。
	//発注履歴に残すことが確認出来たら発注表のデータを消す？
	public void addOrderHistory() {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		//OrderCodeを生成する
		String orderCode;		
		//発注日を今日の日付に設定
		LocalDate orderDate = LocalDate.now();//発注日
		
	}
}
