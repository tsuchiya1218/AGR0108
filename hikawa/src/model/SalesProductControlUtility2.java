package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesProductControlUtility2 {
	public static String[][] salesproductToArray(ArrayList<SalesProduct> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][1];

		for (int i = 0; i < listSize; i++) {
			SalesProduct sp = list.get(i);
			tableData[i][0] = sp.getSPName();
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上数量入力画面