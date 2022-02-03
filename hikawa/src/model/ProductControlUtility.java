package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductControlUtility {

	public static String[][] productToArray(ArrayList<Product> list) {

		int listSize = list.size();
		String[][] tableData = new String[listSize][7];

		for (int i = 0; i < listSize; i++) {
			Product product = list.get(i);
			tableData[i][0] = product.getPdCode();
			tableData[i][1] = product.getPdName();
			tableData[i][2] = Integer.toString(product.getCategory());
			tableData[i][3] = Integer.toString(product.getPrice());
			tableData[i][4] = product.getMakerName();
			tableData[i][5] = Integer.toString(product.getStock());
			tableData[i][6] = Integer.toString(product.getExpiration());
		}
		return tableData;

	}

	public static void systemErrorMessage(JFrame frame, Exception e) {

		JOptionPane.showMessageDialog(frame, e + "：管理者に連絡してください。", "【システムエラー】", JOptionPane.ERROR_MESSAGE);
	}

}
//商品表