package action;

import java.util.ArrayList;

import model.ProductTable;

public class CreateTableData {
	/*ProductTable型のArrayListをString[][]に変換する
	 *使用例
	 * productTableToArray(ProductTableDBAccess.getProductTable())
	 */
	public static String[][] productTableToArray(ArrayList<ProductTable> list) {
		int listSize = list.size();
		String[][] tableData = new String[listSize][8];
			
			for (int i = 0; i < listSize; i++) {
				ProductTable pt = list.get(i);
				tableData[i][0] = pt.getStatus();
				tableData[i][1] = pt.getProductCode();
				tableData[i][2] = pt.getpName();
				tableData[i][3] = pt.getcName();
				tableData[i][4] = Integer.toString(pt.getPrice());
				tableData[i][5] = pt.getmName();
				tableData[i][6] = Integer.toString(pt.getStock());
				tableData[i][7] = pt.getlDate();
			}
			return tableData;

	}
}
