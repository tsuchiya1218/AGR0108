package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesControlUtility {
	public static String[][] salesToArray(ArrayList<Sales> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][4];

		for (int i = 0; i < listSize; i++) {
			Sales sales = list.get(i);
			tableData[i][0] = sales.getWeek();
			tableData[i][1] = Integer.toString(sales.getwTotal());
			tableData[i][2] = Integer.toString(sales.getmTotal());
			tableData[i][3] = Integer.toString(sales.getyTotal());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上画面