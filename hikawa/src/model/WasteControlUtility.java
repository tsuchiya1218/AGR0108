package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WasteControlUtility {
	public static String[][] salesproductToArray(ArrayList<Waste> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][1];

		for (int i = 0; i < listSize; i++) {
			Waste waste = list.get(i);
			tableData[i][0] = waste.getPuroductCode();
			tableData[i][1] = waste.getProductName();
			tableData[i][2] = Integer.toString(waste.getWasteQuantity());
			tableData[i][3] = Integer.toString(waste.getLimit());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//廃棄商品一覧表画面