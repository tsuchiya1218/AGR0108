package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesProductControlUtility {
	public static String[][] salesproductselectToArray(ArrayList<SalesProductSelect> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			SalesProductSelect spproduct = list.get(i);
			tableData[i][0] = spproduct.getPdCode();
			tableData[i][1] = spproduct.getPdName();
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上商品選択画面