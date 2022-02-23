/*
 * 商品編集するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductEditDBAccess {

	public String pCode, pName, mName, cID, foodlimit;
	public int price, stock;

	public ProductEditDBAccess(String pCode, String pName, String mName, String cID, Integer price, Integer stock,
			String foodlimit) {
		//引数(商品コード、商品名、メーカー名、カテゴリID、値段、在庫数、食品期限)
		this.pCode = pCode;
		this.pName = pName;
		this.mName = mName;
		this.cID = cID;
		this.price = price;
		this.stock = stock;
		this.foodlimit = foodlimit;
	}

	public void ProductEdit() throws Exception {

		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		try {
			//商品表更新（商品名、価格、カテゴリー）
			ps1 = con.prepareStatement(
					"UPDATE product "
							+ "SET ProductName = '" + pName + "' , Price = '" + price + "' , CategoryID = '" + cID
							+ "' "
							+ "WHERE ProductCode = '" + pCode + "'");

			//食品期限変更
			ps2 = con.prepareStatement(
					"UPDATE foodlimit "
							+ "INNER JOIN product ON product.FoodLimitCode = foodlimit.FoodLimitCode "
							+ "SET foodlimit.LimitDate = '" + foodlimit + "' "
							+ "WHERE ProductCode = '" + pCode + "'");

			ps1.executeUpdate();
			ps2.executeUpdate();
			//コミット
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//ロールバック
			con.rollback();
		} finally {
			if (ps1 != null) {
				try {
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (ps2 != null) {
					try {
						ps2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			try {
				db.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//今現在あるメーカーを格納する
	public static List<String> ProductMaker() throws Exception {

		List<String> list = new ArrayList<String>();
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		int i = 0;
		try {

			ps = con.prepareStatement(
					"SELECT * From maker");

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("MakerName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
}
/*
 * 商品編集するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductEditDBAccess {

	public String pCode, pName, foodlimit,cID;
	public int price, stock, mID;

	public ProductEditDBAccess(String pCode, String pName, String mName, String cName, Integer price, Integer stock,
			String foodlimit) {
		//引数(商品コード、商品名、メーカー名、カテゴリID、値段、在庫数、食品期限)
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.stock = stock;
		this.foodlimit = foodlimit;

		//メーカー名からメーカーIDを取得
		try {
			DBAccess db = new DBAccess();
			Connection con;
			con = db.createConnection();
			ResultSet rs = null;
			PreparedStatement ps = null;

			ps = con.prepareStatement(
					"SELECT * From maker WHERE MakerName = '" + mName + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				this.mID = rs.getInt("MakerID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		//カテゴリー名からカテゴリーIDを取得
		try {
			DBAccess db = new DBAccess();
			Connection con;
			con = db.createConnection();
			ResultSet rs = null;
			PreparedStatement ps = null;

			ps = con.prepareStatement(
					"SELECT * From category WHERE CategoryName = '" + cName + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				this.cID = rs.getString("CategoryID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ProductEdit() throws Exception {

		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		try {
			//商品表更新（商品名、価格、カテゴリー,メーカーID）
			ps1 = con.prepareStatement(
					"UPDATE product "
							+ "SET ProductName = '" + pName + "' , Price = '" + price + "' , CategoryID = '" + cID
							+ "' , MakerID = '" + mID + "' "
							+ "WHERE ProductCode = '" + pCode + "'");

			//食品期限変更(直接foodlimitを更新してるので商品一つ一つ変更できるようにする)
			ps2 = con.prepareStatement(
					"UPDATE foodlimit "
							+ "INNER JOIN product ON product.FoodLimitCode = foodlimit.FoodLimitCode "
							+ "SET foodlimit.LimitDate = '" + foodlimit + "' "
							+ "WHERE ProductCode = '" + pCode + "'");

			ps1.executeUpdate();
			ps2.executeUpdate();
			//コミット
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//ロールバック
			con.rollback();
		} finally {
			if (ps1 != null) {
				try {
					ps1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (ps2 != null) {
					try {
						ps2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			try {
				db.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//今現在あるメーカーを格納する
	public static List<String> ProductMaker() throws Exception {

		List<String> list = new ArrayList<String>();
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		int i = 0;
		try {

			ps = con.prepareStatement(
					"SELECT * From maker");

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("MakerName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	//今現在あるカテゴリーを格納する
	public static List<String> ProductCategory() throws Exception {
		List<String> list = new ArrayList<String>();
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		int i = 0;
		try {

			ps = con.prepareStatement(
					"SELECT * From category");

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("CategoryName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}