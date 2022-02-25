package control;

import action.AddProductDisplayAction;
import action.AddSaleDisplayAction;
import action.AddSalesAmountCheckDisplayAction;
import action.AddWastePtoductDisplayAction;
import action.EditProductDisplayAction;
import action.LoginDisplayAction;
import action.OrderHistoryDisplayAction;
import action.OrderTableDisplayAction;
import action.ProductSalesQuantityDisplayAction;
import action.ProductSelectionSalesDisplayAction;
import action.ProductTableDisplayAction;
import action.SaleProductHistoryDisplayAction;
import action.SalesDisplayAction;
import action.TopDisplayAction;
import action.WasteDisplayAction;

public class HikawaController {

	// Top表示
	public static void TopDisplay() {
		TopDisplayAction action = new TopDisplayAction();
		action.execute();
	}

	// 商品表表示
	public static void ProductTableDisplay() {
		ProductTableDisplayAction action = new ProductTableDisplayAction();
		action.execute();
	}

	// 発注表表示
	public static void OrderTableDisplay() {
		OrderTableDisplayAction action = new OrderTableDisplayAction();
		action.execute();
	}

	// 発注履歴表示
	public static void OrderHistoryDisplay() {
		OrderHistoryDisplayAction action = new OrderHistoryDisplayAction();
		action.execute();
	}

	// 売上表示
	public static void SalesDisplay() {
		SalesDisplayAction action = new SalesDisplayAction();
		action.execute();
	}

	// ログイン画面表示
	public static void LoginDisplay() {
		LoginDisplayAction action = new LoginDisplayAction();
		action.execute();
	}

	// 売上金額入力画面表示
	public static void AddSaleDisplay() {
		AddSaleDisplayAction action = new AddSaleDisplayAction();
		action.execute();
	}

	// 売上商品選択画面表示
	public static void ProductSelectionSalesDisplay() {
		ProductSelectionSalesDisplayAction action = new ProductSelectionSalesDisplayAction();
		action.execute();
	}

	// 売上商品履歴画面表示
	public static void SaleProductHistoryDisplay() {
		SaleProductHistoryDisplayAction action = new SaleProductHistoryDisplayAction();
		action.execute();
	}

	// 売上入力確認画面表示
	public static void AddSalesAmountCheckDisplay() {
		AddSalesAmountCheckDisplayAction action = new AddSalesAmountCheckDisplayAction();
		action.execute();

	}

	// 売上数量入力画面表示
	public static void ProductSalesQuantityDisplay() {
		ProductSalesQuantityDisplayAction action = new ProductSalesQuantityDisplayAction();
		action.execute();

	}

	// 廃棄一覧表表示
	public static void WasteDisplay() {
		WasteDisplayAction action = new WasteDisplayAction();
		action.execute();
	}

	// 廃棄商品追加画面表示
	public static void AddWastePtoductDisplay() {
		AddWastePtoductDisplayAction action = new AddWastePtoductDisplayAction();
		action.execute();

	}

	// 商品編集画面表示
	public static void EditProductDisplay() {
		EditProductDisplayAction action = new EditProductDisplayAction();
		action.execute();

	}

	//商品追加画面表示
	public static void AddProductDisplay() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		AddProductDisplayAction action = new AddProductDisplayAction();
		action.execute();
	}
}
