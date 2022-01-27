package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesProductControlUtility {
	public static String[][] productToArray(ArrayList<Product> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][2];

		for (int i = 0; i < listSize; i++) {
			Product product = list.get(i);
			tableData[i][0] = product.getProductCode();
			tableData[i][1] = product.getProductName();
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//売上商品選択画面