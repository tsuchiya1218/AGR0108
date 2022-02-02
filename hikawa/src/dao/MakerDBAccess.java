package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MakerDBAccess {
	
	//メーカー名からメーカーＩＤを取得する(存在しなければNULLを返す)
		public static String getMakerIDbyName(String mName) {
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
		public static String makeMakerID() {
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
		public static void makeMaker(String makerID, String makerName) throws Exception {
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
