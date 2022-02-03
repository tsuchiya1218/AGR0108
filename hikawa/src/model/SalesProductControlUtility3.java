package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesProductControlUtility3 {
	public static String[][] salesproductToArray(ArrayList<SalesProduct> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][1];

		for (int i = 0; i < listSize; i++) {
			SalesProduct sp = list.get(i);
			tableData[i][0] = sp.getSPCode();
			tableData[i][1] = sp.getPdCode();
			tableData[i][2] = sp.getSPName();
			tableData[i][3] = Integer.toString(sp.getSPQuantity());
			tableData[i][4] = sp.getSPDate();
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上商品履歴画面
