package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WasteControlUtility2 {
	public static String[][] wasteaddToArray(ArrayList<WasteAdd> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][4];

		for (int i = 0; i < listSize; i++) {
			WasteAdd wasadd = list.get(i);
			tableData[i][0] = wasadd.getPdCode();
			tableData[i][1] = wasadd.getPdName();
			tableData[i][2] = Integer.toString(wasadd.getWasteQuantity());
			tableData[i][3] = Integer.toString(wasadd.getLimit());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//廃棄商品追加画面