package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductEditDBAccess {
	public static void ProductEdit(String pName,String mName, int cID, int price,int stock,String foodlimit) throws Exception{
		DBAccess db = new DBAccess();
		Connection con = db.createConnection();
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(
					"UPDATE PT SET ProductName = ?, MakerName = ?, CategoryID = ? Price = ? Stock = ? LimitDate = ?"
					+"FROM producttable as PT INNER JOIN product ON product.ProductCode = producttable.ProductCode "
					+ "INNER JOIN category ON product.CategoryID = category.CategoryID "
					+ "INNER JOIN maker ON product.MakerID = maker.makerID"
					+ "INNER JOIN foodlimit ON product.FoodLimitCode = foodlimit.FoodLimitCode");
			ps.setString(1, pName);
			ps.setString(2, mName);
			ps.setInt(3, cID);
			ps.setInt(4, price);
			ps.setInt(5, stock);
			ps.setString(6, foodlimit);
			
			ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
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
}


