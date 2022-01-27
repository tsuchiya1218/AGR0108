package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrderControlUtility2 {
	public static String[][] orderToArray(ArrayList<Order> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][7];

		for (int i = 0; i < listSize; i++) {
			Order order = list.get(i);
			tableData[i][0] = Integer.toString(order.getOrderDate());
			tableData[i][1] = order.getOrderCode();
			tableData[i][2] = order.getProductCode();
			tableData[i][3] = order.getOrderName();
			tableData[i][4] = Integer.toString(order.getOrderQuantity());
			tableData[i][5] = Integer.toString(order.getOrderQuantity());
			tableData[i][6] = Integer.toString(order.getFoodLimit());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
//発注履歴画面
