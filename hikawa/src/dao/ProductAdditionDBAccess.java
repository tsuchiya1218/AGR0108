/*
 * 商品表に商品を追加するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductAdditionDBAccess {
	public String pName,mName,cID,foodLCode;
	public int price;
	public ProductAdditionDBAccess(String pName, String mName, String cID, int price, String foodLCode){
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		this.pName = pName;
		this.mName = mName;
		this.cID = cID;
		this.price = price;
		this.foodLCode = foodLCode;
	}
	
	
	//商品を新規作成する
	public void productAddition() throws Exception {
		String makerID = MakerDBAccess.getMakerIDbyName(mName);//makerIDを取得
		String pCode = makeProductCode();//商品コード生成
		Connection con = null;
		DBAccess db = new DBAccess();
		PreparedStatement ps = null;
		if(makerID == null) {
			makerID = MakerDBAccess.makeMakerID();
			MakerDBAccess.makeMaker(makerID,mName);
		}
		try {
			con = db.createConnection();
			String sql = 
					"INSERT INTO product(ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryID) "
					+"VALUES('" + pCode +"','"+ pName + "','" + price +"','"+ foodLCode + "','" + makerID + "','" + cID  +"')";
			//ProductCode,ProductName,Price,FoodLimitCode,MakerID,CategoryIDを商品表に追加
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
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
		int cnt = 1;
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = db.createConnection();
			ps = con.prepareStatement("SELECT COUNT(*) cnt FROM product WHERE CategoryID = ?");
			ps.setString(1, cID);
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt += rs.getInt("cnt") ;
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
		String Scnt = null;
		if (cnt < 10) {
			Scnt = "00"+cnt;
		}else if(cnt < 100) {
			Scnt = "0"+cnt;
		}else {
			Scnt = "";
		}
		ProductCode = cID + "_" + Scnt + foodLCode;
		return ProductCode;
	}
}
