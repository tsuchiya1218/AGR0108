package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesProductControlUtility2 {
	public static String[][] salesproductinputToArray(ArrayList<SalesProductInput> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			SalesProductInput spinp = list.get(i);
			tableData[i][0] = spinp.getSPName();

		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上数量入力画面