package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddSalesAmountDBAccess {
	public String date;
	public int amount;

	/*PreparedStatement ps = null;
	String week = null;
	String date = null ;
	int amount = 0;
	DBAccess db = new DBAccess();
	Connection con = null;*/

	public AddSalesAmountDBAccess(String date, int amount) {
		// TODO 自動生成されたコンストラクター・スタブ
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		this.date = date;
		this.amount = amount;
	}

	//売り上げを入力し売上表に追加する
	public void addSalesAmount() throws Exception {
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;
		try {
			con = db.createConnection();
			//INSERT INTO テーブル名 (列名1, 列名2,...) VALUES (値1, 値2,...);
			String sql = "INSERT INTO sales (Date,Amount) "
					+ "VALUES(?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ps.setInt(2, amount);

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
}
