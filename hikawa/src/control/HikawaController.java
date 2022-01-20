package control;

import action.TopDisplayAction;

public class HikawaController {
	
	
	//Top表示
	public static void TopDisplay() {
		TopDisplayAction action = new TopDisplayAction();
		action.execute();
	}
}
