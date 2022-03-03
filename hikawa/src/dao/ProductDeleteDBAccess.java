package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDeleteDBAccess {
	String pCode = null;

	public ProductDeleteDBAccess(String pCode){
		//引数(商品コード)
		this.pCode = pCode;
	}

	//商品を削除する
		public void ProductDelete() throws Exception {
			Connection con = null;
			DBAccess db = new DBAccess();
			PreparedStatement ps = null;

			try {
				con = db.createConnection();
				String sql = "UPDATE product SET Invailed = 1 WHERE ProductCode =  '" + pCode + "'";

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

}
