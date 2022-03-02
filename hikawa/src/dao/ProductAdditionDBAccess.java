/*
 * 商品表に商品を追加するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductAdditionDBAccess {
	public String pName, mName, cID,pCode,makerID;
	public int Sprice,Pprice;

	public ProductAdditionDBAccess(String pName, String mName, String cID, int Sprice,int Pprice) {
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		this.pName = pName;
		this.mName = mName;
		this.cID = cID;
		this.Sprice = Sprice;
		this.Pprice = Pprice;
	}

	//商品を新規作成する
	public void productAddition() throws Exception {
		makerID = MakerDBAccess.getMakerIDbyName(mName);//makerIDを取得
		cID = categoryID();//カテゴリーを名前からコードに変換
		pCode = makeProductCode();//商品コード生成
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;
		if (makerID == null) {
			makerID = MakerDBAccess.makeMakerID();
			MakerDBAccess.makeMaker(makerID, mName);
		}
		try {
			con = db.createConnection();

			String sql = "INSERT INTO product (ProductCode,ProductName,SellPrice,Stock,PurPrice,FoodLimitCode,MakerID,CategoryID,OrderHistoryCode) "
					+ "VALUES(?,?,?,0,?,'00',?,?,'00')";
			//ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryIDを商品表に追加

			ps = con.prepareStatement(sql);

			ps.setString(1, pCode);
			ps.setString(2, pName);
			ps.setInt(3, Sprice);
			ps.setInt(4, Pprice);
			ps.setString(5,makerID);
			ps.setString(6,cID);

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

	//今現在あるカテゴリーを格納する
	public static List<String> ProductCategory() throws Exception {
		List<String> list = new ArrayList<String>();
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
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

	//カテゴリー名からコードに変換
	public String categoryID() throws Exception {
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		String ScID = null;
		try {

			ps = con.prepareStatement(
					"SELECT CategoryID From category WHERE CategoryName ='" + cID + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				ScID = rs.getString("CategoryID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ScID;

	}

	/*
	 * 商品コードを作成するクラス
	 * カテゴリID_そのカテゴリの商品数+1
	 */
	public String makeProductCode() {
		String ProductCode = null;
		String Pcode = null;
		//01_00の部分を格納
		String Pcode1 = null;
		//01_00(1)01この部分を格納
		Integer Pcode2 = null;
		int cnt2 = 1;

		Connection con = null;
		DBAccess db = new DBAccess();

		ResultSet rs1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;

		try {
			con = db.createConnection();
			//同じ商品が何個あるか
			ps2 = con.prepareStatement(
					"SELECT COUNT(*) cnt , ProductCode FROM product INNER JOIN maker ON product.MakerID = maker.MakerID WHERE ProductName = ? AND CategoryID = ? AND MakerName = ?");
			ps2.setString(1, pName);
			ps2.setString(2, cID);
			ps2.setString(3, mName);
			rs2 = ps2.executeQuery();

			while (rs2.next()) {
				cnt2 = rs2.getInt("cnt");

				Pcode = rs2.getString("ProductCode");
			}

			if (cnt2 == 0) {//同じ商品がなかった場合

				//同じカテゴリー内に商品が何個あるか
				ps1 = con.prepareStatement("SELECT ProductCode FROM product WHERE CategoryID = ?");
				ps1.setString(1, cID);
				rs1 = ps1.executeQuery();

				while (rs1.next()) {
					Pcode = rs1.getString("ProductCode");
				}

				//カテゴリー内の数
				Pcode1 = Pcode.substring(0, Pcode.length() - 3);
				Pcode2 = Integer.parseInt(Pcode.substring(5, Pcode.length() - 2)) + 1;
				Pcode = Pcode1 + Pcode2;

				//同じ商品個数判定
				String Spq = null;
				cnt2 += 1;
				if (cnt2 < 10) {
					Spq = "0" + cnt2;
				} else {
					Spq = "" + cnt2;
				}

				ProductCode = Pcode + Spq;

			} else {

				//同じ商品個数判定
				String Spq = null;
				cnt2 += 1;
				if (cnt2 < 10) {
					Spq = "0" + cnt2;
				} else {
					Spq = "" + cnt2;
				}

				Pcode = Pcode.substring(0, Pcode.length() - 2);
				ProductCode = Pcode + Spq;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs1 != null) {
				try {
					rs1.close();
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
			if (rs2 != null) {
				try {
					rs2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ps2 != null) {
				try {
					ps2.close();
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

		return ProductCode;
	}

}
