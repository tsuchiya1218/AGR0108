package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginControlUtility {
	public static String[][] loginToArray(ArrayList<Login> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			Login login = list.get(i);
			tableData[i][0] = Integer.toString(login.getEmpNum());
			tableData[i][1] = login.getPass();
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
