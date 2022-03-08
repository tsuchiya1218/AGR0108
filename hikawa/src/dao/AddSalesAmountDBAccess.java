package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		int cnt = 0;
		Connection con1 = null;
		Connection con2 = null;
		DBAccess db1 = new DBAccess();
		DBAccess db2 = new DBAccess();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		try {
			con1 = db1.createConnection();
			
			String sql = "SELECT COUNT(*) as cnt FROM sales WHERE Date = '" + date + "'";

			ps1 = con1.prepareStatement(sql);

			rs = ps1.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("データベース接続のエラーです。");
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
			if (ps1 != null) {
				try {
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			db1.closeConnection(con1);
		}

		if (cnt == 0) {
			try {
				con2 = db2.createConnection();
				//INSERT INTO テーブル名 (列名1, 列名2,...) VALUES (値1, 値2,...);
				String sql = "INSERT INTO sales (Date,Amount) "
						+ "VALUES(?,?)";

				ps2 = con2.prepareStatement(sql);

				ps2.setString(1, date);
				ps2.setInt(2, amount);

				ps2.executeUpdate();
				con2.commit();
			} catch (Exception e) {
				con2.rollback();
				e.printStackTrace();
			} finally {
				if (ps2 != null) {
					try {
						ps2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					db2.closeConnection(con2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				con2 = db2.createConnection();
				//INSERT INTO テーブル名 (列名1, 列名2,...) VALUES (値1, 値2,...);
				String sql = "UPDATE sales "
						+ "SET Amount = ? "
						+ "WHERE Date = ?";

				ps2 = con2.prepareStatement(sql);

				ps2.setString(2, date);
				ps2.setInt(1, amount);

				ps2.executeUpdate();
				con2.commit();
			} catch (Exception e) {
				con2.rollback();
				e.printStackTrace();
			} finally {
				if (ps2 != null) {
					try {
						ps2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					db2.closeConnection(con2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		

	}
}
