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

	public String pCode, pName, foodlimit,cID,SmID;
	public int Sprice,Pprice, stock, mID;

	public ProductEditDBAccess(String pCode, String pName, String mName, Integer Sprice,Integer Pprice , Integer stock,
			String foodlimit) {
		//引数(商品コード、商品名、メーカー名、カテゴリID、値段、在庫数、食品期限)
		this.pCode = pCode;
		this.pName = pName;
		this.Sprice = Sprice;
		this.Pprice = Pprice;
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

			if(mID < 10) {
				SmID = "0" + mID;
			}else if(mID > 10) {
				SmID = String.valueOf(mID);
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
			//商品表更新（商品名,仕入れ価格,販売価格,在庫,メーカーID）
			ps1 = con.prepareStatement(
					"UPDATE product "
							+ "SET ProductName = '" + pName + "' , SellPrice = '" + Sprice + "' , PurPrice = '" + Pprice + "' , Stock =  '"+ stock + "' ,  MakerID = '" + SmID + "' "
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

}
