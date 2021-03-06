package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import action.CreateTableData;
import control.HikawaController;
import dao.OrderHistoryDBAccess;
import dao.OrderTableDBAccess;

public class OrderTable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public OrderTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("発注表画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(191, 51, 108, 26);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 112, 348, 95);
		contentPane.add(scrollPane);
		String[] columnNames = { "商品コード", "商品名", "個数"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);

		try {
			OrderTableDBAccess otd = new OrderTableDBAccess();

			//列の入れ替えを禁止
			table.getTableHeader().setReorderingAllowed(false);

			//列の幅指定
			table.getColumn("商品コード").setPreferredWidth(10);
			table.getColumn("商品名").setPreferredWidth(150);
			table.getColumn("個数").setPreferredWidth(10);

			String[][] tabledata = CreateTableData.orderTableToArray(otd.getOrders());
			if (tabledata != null) {
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
		}

		scrollPane.setViewportView(table);
		
		//発注履歴ボタン
		JButton btnOrderHistory = new JButton("発注履歴");
		btnOrderHistory.setBounds(297, 11, 85, 26);
		btnOrderHistory.setActionCommand("btnOrderHistory");
		btnOrderHistory.addActionListener(this);
		contentPane.add(btnOrderHistory);
		
		//トップボタン
		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(390, 11, 75, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);
		
		//発注ボタン
		JButton btnOrder = new JButton("発注");
		btnOrder.setBounds(58, 342, 76, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);
		
		//個数変更のラベル
		JLabel lblNewLabel_2 = new JLabel("個数変更");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 226, 64, 16);
		contentPane.add(lblNewLabel_2);
		
		
		//個数変更の商品コード入力フィールド
		textField = new JTextField();
		textField.setBounds(88, 252, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//個数入力ラベル
		JLabel lblNewLabel_3 = new JLabel("個数入力：");
		lblNewLabel_3.setBounds(193, 255, 64, 13);
		contentPane.add(lblNewLabel_3);
		
		//個数入力フィールド？
		textField_1 = new JTextField();
		textField_1.setBounds(258, 252, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//商品コードラベル
		JLabel lblNewLabel_4 = new JLabel("商品コード：");
		lblNewLabel_4.setBounds(12, 255, 74, 13);
		contentPane.add(lblNewLabel_4);

		//商品削除ラベル
		JLabel lblNewLabel_5 = new JLabel("商品削除");
		lblNewLabel_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(32, 289, 64, 15);
		contentPane.add(lblNewLabel_5);

		//商品コードラベル
		JLabel lblNewLabel_6 = new JLabel("商品コード：");
		lblNewLabel_6.setBounds(23, 314, 75, 13);
		contentPane.add(lblNewLabel_6);
		
		//変更ボタン
		JButton btnchange = new JButton("変更");
		btnchange.setActionCommand("btnchange");
		btnchange.addActionListener(this);
		btnchange.setBounds(360, 251, 64, 21);
		contentPane.add(btnchange);
		
		//商品削除の商品コード入力
		textField_2 = new JTextField();
		textField_2.setBounds(99, 311, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//削除ボタン
		JButton btnDelete = new JButton("削除");
		btnDelete.setActionCommand("btnDelete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(208, 310, 64, 21);
		contentPane.add(btnDelete);
		
		//商品表ボタン
		JButton producttablebtn = new JButton("商品表");
		producttablebtn.setActionCommand("producttablebtn");
		producttablebtn.addActionListener(this);
		producttablebtn.setBounds(196, 12, 91, 26);
		contentPane.add(producttablebtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//商品表ボタンを押した際の処理
		if (cmd.equals("producttablebtn")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}

		//発注履歴ボタンを押した際の処理
		if (cmd.equals("btnOrderHistory")) {
			setVisible(false);
			HikawaController.OrderHistoryDisplay();
		}

		//トップボタンが押された時の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		//発注ボタンが押された時の処理
		if (cmd.equals("btnOrder")) {
			OrderHistoryDBAccess ohd = new OrderHistoryDBAccess();
			OrderTableDBAccess otd = new OrderTableDBAccess();
			//発注表に追加
			try {
				ohd.addOrderHistory();
				JOptionPane.showMessageDialog(contentPane, "発注完了しました");
				otd.deleteOrderTable();
				setVisible(false);
				HikawaController.OrderTableDisplay();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
				System.out.println("発注追加時のエラー");
			}
			
			
		}
		
		
		
		//個数変更ボタンが押された時の処理
		if (cmd.equals("btnchange")) {
			String qPCode = textField.getText();
			OrderTableDBAccess otd = new OrderTableDBAccess();
			if(!(qPCode.equals(""))) {
				try {
					int quantity = Integer.parseInt(textField_1.getText());
					if(otd.checkAvailProduct(qPCode)) {
						otd.updateQuantity(qPCode, quantity);
						JOptionPane.showMessageDialog(contentPane, "変更しました。");
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "商品コードが間違っています。");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPane, "個数入力に半角数字で入力してください。");
				}catch(SQLException SQLe) {
					SQLe.printStackTrace();
				}
				setVisible(false);
				HikawaController.OrderTableDisplay();
			} else {
				JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください。");
			}
		}
	
		
		//削除ボタンが押された時の処理
		if (cmd.equals("btnDelete")) {
			String pCode = textField_2.getText();
			OrderTableDBAccess otd = new OrderTableDBAccess();
			if(!(pCode.equals(""))) {
				if(otd.checkAvailProduct(pCode)) {
					otd.dleateFromOrders(pCode);
					JOptionPane.showMessageDialog(contentPane, "削除しました。");
					setVisible(false);
					HikawaController.OrderTableDisplay();
				} else {
					JOptionPane.showMessageDialog(contentPane, "商品コードが間違っています。");
				}
			
			}else {
				JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください。");
			}
		}
		
	
	
	}
}

