package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.WasteTable;

public class WasteDBAccess {
	String pCode;
	Integer wCode;
	//最後にこのlistを返す
	public ArrayList<WasteTable> list = new ArrayList<WasteTable>();
	Connection con;

	public WasteDBAccess(String pCode) {
		this.pCode = pCode;
	}

	public WasteDBAccess() {
	}

	public void WasteAdd() throws Exception {
		Connection con1 = null;
		Connection con2 = null;

		DBAccess db1 = new DBAccess();
		DBAccess db2 = new DBAccess();

		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		ResultSet rs = null;

		int cnt = 0;
		wCode = WasteCode();//WasteCode作成
		try {
			con1 = db1.createConnection();
			ps1 = con1.prepareStatement(
					"SELECT COUNT(*) as cnt From waste WHERE ProductCode LIKE '" + pCode + "'");

			rs = ps1.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps1 != null) {
				try {
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				db1.closeConnection(con1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cnt == 0) {
			try {
				con2 = db2.createConnection();

				String sql = "INSERT INTO waste (WasteCode,ProductCode) VALUES(?,?)";
				//ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryIDを商品表に追加

				ps2 = con2.prepareStatement(sql);
				ps2.setInt(1, wCode);
				ps2.setString(2, pCode);

				ps2.executeUpdate();
				con2.commit();
			} catch (Exception e) {
				con2.rollback();
				throw new SQLException();
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
			throw new SQLException();
		}

	}

	public Integer WasteCode() throws Exception {//WasteCode作成
		Integer wCode = null;
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {

			ps = con.prepareStatement(
					"SELECT WasteCode From waste ORDER BY WasteCode ASC");

			rs = ps.executeQuery();

			while (rs.next()) {
				wCode = rs.getInt("WasteCode");
			}

			if (wCode == null) {
				wCode = 1;
			} else {
				wCode = wCode + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return wCode;
	}

	public ArrayList<WasteTable> getWasteTable() throws Exception {
		ResultSet rs = null;
		PreparedStatement ps = null;
		DBAccess db = new DBAccess();
		try {
			con = db.createConnection();

			String sql = "SELECT waste.ProductCode,ProductName,Stock,LimitDate From product "
					+ "INNER JOIN foodlimit ON foodlimit.FoodLimitCode = product.FoodLimitCode "
					+ "INNER JOIN waste ON waste.ProductCode = product.ProductCode";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new WasteTable(rs.getString("ProductCode"), rs.getString("ProductName"),
						rs.getInt("Stock"), rs.getString("LimitDate")));
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
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			db.closeConnection(con);

		}
		return list;
	}

	public void cancelwaste() throws Exception {//廃棄解除

		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;

		try {
			con = db.createConnection();
			String sql = "DELETE FROM waste WHERE ProductCode = '" + pCode + "'";

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

	public static void Deletewaste() throws Exception {//廃棄削除
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;

		Connection con1 = null;
		DBAccess db1 = new DBAccess();
		PreparedStatement ps1 = null;

		try {
			con = db.createConnection();
			String sql = "UPDATE product INNER JOIN waste ON product.ProductCode = waste.ProductCode SET Invailed = 1";

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

		try {
			con1 = db1.createConnection();
			String sql1 = "DELETE FROM waste";

			ps1 = con1.prepareStatement(sql1);
			ps1.executeUpdate();
			con1.commit();
		} catch (Exception e) {
			con1.rollback();
			e.printStackTrace();
		} finally {
			if (ps1 != null) {
				try {
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				db1.closeConnection(con1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}