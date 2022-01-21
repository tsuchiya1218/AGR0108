/*
 * 商品表に商品を追加するクラス
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductAdditionDBAccess {
	public void productAddition(String pName, String mName, String cID, int price, int foodLCode) {
		//引数(商品名、メーカー名、カテゴリID、価格、食品期限コード)
		Connection con = null;
		DBAccess db = new DBAccess();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = db.createConnection();
			ps = con.prepareStatement("INSERT");
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
