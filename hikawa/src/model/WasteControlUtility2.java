package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WasteControlUtility2 {
	public static String[][] productToArray(ArrayList<Product> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][4];

		for (int i = 0; i < listSize; i++) {
			Product product = list.get(i);
			tableData[i][0] = product.getProductCode();
			tableData[i][1] = product.getProductName();
			tableData[i][2] = Integer.toString(product.getStock());
			tableData[i][3] = Integer.toString(product.getExpiration());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}
}
//廃棄商品追加画面