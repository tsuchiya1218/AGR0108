package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesControlUtility2 {
	public static String[][] salesdetailsToArray(ArrayList<SalesDetails> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			SalesDetails salesdetails = list.get(i);
			tableData[i][0] = Integer.toString(salesdetails.getSalesDate());
			tableData[i][1] = Integer.toString(salesdetails.getSalesAmount());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
//週売上詳細画面