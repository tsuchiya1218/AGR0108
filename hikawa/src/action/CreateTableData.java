package action;

import java.util.ArrayList;

import model.Order;
import model.ProductTable;
import model.Sales;

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
	
	public static String[][] orderTableToArray(ArrayList<Order> list){
		int listSize = list.size();
		String[][] tableData = new String[listSize][3];
		for (int i = 0; i < listSize; i++ ) {
			Order o = list.get(i);
			tableData[i][0] = o.getPdCode();
			tableData[i][1] = o.getPdName();
			tableData[i][2] = Integer.toString(o.getStock());
		}
		
		return tableData;
	}

	public static String[][] salesToArray(ArrayList<Sales> list) {
		int listSize = list.size();
		String[][] tableData = new String[listSize][2];
		for (int i = 0; i < listSize; i++ ) {
			Sales s = list.get(i);
			tableData[i][0] = s.getDate();
			tableData[i][1] = Integer.toString(s.getAmount());
		}
		
		return tableData;
	}
}
