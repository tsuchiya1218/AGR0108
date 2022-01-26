package control;

import action.LoginDisplayAction;
import action.OrderHistoryDisplayAction;
import action.OrderTableDisplayAction;
import action.ProductTableDisplayAction;
import action.SalesDisplayAction;
import action.TopDisplayAction;
import action.WasteDisplayAction;

public class HikawaController {

	//Top表示
	public static void TopDisplay() {
		TopDisplayAction action = new TopDisplayAction();
		action.execute();
	}

	//商品表表示
	public static void ProductTableDisplay() {
		ProductTableDisplayAction action = new ProductTableDisplayAction();
		action.execute();
	}

	//発注表表示
	public static void OrderTableDisplay() {
		OrderTableDisplayAction action = new OrderTableDisplayAction();
		action.execute();
	}

	//発注履歴表示
	public static void OrderHistoryDisplay() {
		OrderHistoryDisplayAction action = new OrderHistoryDisplayAction();
		action.execute();
	}

	//売上表示
	public static void SalesDisplay() {
		SalesDisplayAction action = new SalesDisplayAction();
		action.execute();
	}

	//廃棄一覧表表示
	public static void WasteDisplay() {
		WasteDisplayAction action = new WasteDisplayAction();
		action.execute();
	}

	//ログイン画面表示
	public static void LoginDisplay() {
		LoginDisplayAction action = new LoginDisplayAction();
		action.execute();
	}
}
