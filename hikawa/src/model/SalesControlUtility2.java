package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesControlUtility2 {
	public static String[][] salesToArray(ArrayList<Sales> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			Sales sales = list.get(i);
			tableData[i][0] = Integer.toString(sales.getDay());
			tableData[i][1] = Integer.toString(sales.getwTotal());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
//週売上詳細画面