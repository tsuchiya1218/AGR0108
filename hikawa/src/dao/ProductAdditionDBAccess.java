/*
 * 商品表に商品を追加するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductAdditionDBAccess {
	String pName,mName,cID;
	String makerID = getMakerIDbyName();
	int price,foodLCode;
	ProductAdditionDBAccess(String pName, String mName, String cID, int price, int foodLCode){
		this.pName = pName;
		this.mName = mName;
		this.cID = cID;
		this.price = price;
		this.foodLCode = foodLCode;
	}
	public void productAddition() {
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			
			con = db.createConnection();
			//ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryIDを商品表に追加
			ps = con.prepareStatement("INSERT ");
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//メーカー名からメーカーＩＤを取得する(存在しなければNULLを返す)
	public String getMakerIDbyName() throws Exception {
		String makerID = null;
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
					makerID = rs.getString("makerID");
				}
			}
		}catch(Exception e){
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
			db.closeConnection(con);
		}
		return makerID;
	}
}
