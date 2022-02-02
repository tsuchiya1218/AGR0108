package action;



import java.util.ArrayList;

import dao.ProductSearchDBAccess;
import model.Product;
import model.ProductControlUtility;

public class Productserchaction {

	public  static String[][] execute(String[] data) throws Exception {
		 data[0] = data[0].replaceAll("　","");
		 data[0] = data[0].replaceAll(" ","");
		 //data(String[] data[0]=tel,data[1]=kana);
		 ProductSearchDBAccess db = new ProductSearchDBAccess() ;
		 ArrayList<Product> list = new ArrayList<Product>();
		 String[][] tableData = null;
		 
		 if(!data[0].isEmpty()) {
			 list = db.searchProductByproductName(data[0]);
			 if(list != null && list.size() != 0) {
				 tableData = ProductControlUtility.productToArray(list);
			 }
		 }else if(!data[0].isEmpty()) {
			 list = db.searchProduct(data[0]);
			 if(list != null && list.size() != 0) {
				 tableData = ProductControlUtility.productToArray(list);
			 }
		 }
		 return tableData;
	 }
	}
