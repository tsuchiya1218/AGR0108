package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrderControlUtility {
	public static String[][] orderToArray(ArrayList<Order> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][3];

		for (int i = 0; i < listSize; i++) {
			Order order = list.get(i);
			tableData[i][0] = order.getProductCode();
			tableData[i][1] = order.getOrderName();
			tableData[i][2] = Integer.toString(order.getOrderQuantity());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//発注表画面