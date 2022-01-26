/* クラス名：	LoginDisplayAction
* 概要　　：	ログイン画面表示アクション
* 作成者名：
* 作成日　：
* 修正者名：
* 修正日　：
*/

package action;

import java.awt.EventQueue;

import view.Login;

public class StartDisplayAction {

	public void execute() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		new Login();
	}
}