/*
 * 商品表に商品を追加するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductAdditionDBAccess {
	String pName,mName,cID;
	String makerID = getMakerIDbyName(mName);//makerIDを取得
	int price,foodLCode;
	String pCode = makeProductCode();//商品コード生成
	
	ProductAdditionDBAccess(String pName, String mName, String cID, int price, int foodLCode){
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		this.pName = pName;
		this.mName = mName;
		this.cID = cID;
		this.price = price;
		this.foodLCode = foodLCode;
	}
	
	
	//商品を新規作成する
	public void productAddition() {
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;
		if(makerID == null) {
			makerID = makeMakerID();
			makeMaker(makerID,mName);
		}
		try {
			con = db.createConnection();
			String sql = 
					"INSERT INTO product(ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryID) "
					+"VALUES(" + pCode +","+ pName + "," + price +","+ foodLCode + "," + makerID + "," + cID  +")";
			//ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryIDを商品表に追加
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//メーカー名からメーカーＩＤを取得する(存在しなければNULLを返す)
	public String getMakerIDbyName(String mName) {
		String mID = null;
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {			
			con = db.createConnection();
			ps = con.prepareStatement("SELECT makerID FROM maker WHERE makerName = ?");
			ps.setString(1, mName);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("makerID") != null) {
					mID = rs.getString("makerID");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			mID = null;
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps!= null) {
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
		return mID;
	}
	
	
	//makerIDを作成
	public String makeMakerID() {
		String mID = null;
		int cnt = 0;
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			con = db.createConnection();
			ps = con.prepareStatement("SELECT COUNT(*) cnt FROM maker");
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps!= null) {
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
		cnt = cnt + 1;
		mID  = String.valueOf(cnt);
		return mID;
	}
	
	
	//新しいメーカーを作成する
	public void makeMaker(String makerID, String makerName) {
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;
		try {
			con = db.createConnection();
			ps = con.prepareStatement("INSERT INTO maker VALUE(?,?)");
			ps.setString(1, makerID);
			ps.setString(2, makerName);
			//insertを実行
			ps.executeUpdate();
			//コミット
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!= null) {
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
	
	
	
	/*
	 * 商品コードを作成するクラス
	 * カテゴリID_そのカテゴリの商品数+1
	 */
	public String makeProductCode() {
		String ProductCode = null;
		int cnt = 0;
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = db.createConnection();
			ps = con.prepareStatement("SELECT COUNT(*) cnt FROM product WHERE CategoryID = ?");
			ps.setString(1, cID);
			rs = ps.executeQuery();
			cnt = rs.getInt("cnt") + 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps!= null) {
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
		ProductCode = cID + "_" + cnt;
		return ProductCode;
	}
}
