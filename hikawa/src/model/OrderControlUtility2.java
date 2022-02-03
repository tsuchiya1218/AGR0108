package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrderControlUtility2 {
	public static String[][] orderhistoryToArray(ArrayList<OrderHistory> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][7];

		for (int i = 0; i < listSize; i++) {
			OrderHistory orderhis = list.get(i);
			tableData[i][0] = Integer.toString(orderhis.getOdDate());
			tableData[i][1] = orderhis.getOdCode();
			tableData[i][2] = orderhis.getPdCode();
			tableData[i][3] = orderhis.getOdName();
			tableData[i][4] = Integer.toString(orderhis.getOdQuantity());
			tableData[i][5] = Integer.toString(orderhis.getDeliDate());
			tableData[i][6] = Integer.toString(orderhis.getFoodLimit());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
//発注履歴画面
