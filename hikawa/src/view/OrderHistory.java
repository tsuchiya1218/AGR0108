package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import action.CreateTableData;
import control.HikawaController;
import dao.FoodLimitDBAccess;
import dao.OrderHistoryDBAccess;

public class OrderHistory extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField, textField3;
	private DefaultTableModel tableModel;
	JFormattedTextField textField4;
	JFormattedTextField textField2;

	/**
	 * Create the frame.
	 */
	public OrderHistory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 664, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 92, 477, 212);
		contentPane.add(scrollPane);

		String[] columnNames = { "発注日", "商品コード", "商品名", "個数", "納品予定日", "状況" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);

		try {
			OrderHistoryDBAccess ohd = new OrderHistoryDBAccess();

			//列の入れ替えを禁止
			table.getTableHeader().setReorderingAllowed(false);

			//列の幅指定
			table.getColumn("発注日").setPreferredWidth(150);
			table.getColumn("商品コード").setPreferredWidth(150);
			table.getColumn("商品名").setPreferredWidth(280);
			table.getColumn("個数").setPreferredWidth(90);
			table.getColumn("納品予定日").setPreferredWidth(150);
			table.getColumn("状況").setPreferredWidth(90);

			String[][] tabledata = CreateTableData.historyTableToArray(ohd.getOrderHistory());
			if (tabledata != null) {
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("発注履歴画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(249, 44, 124, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(545, 22, 82, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);
		
		/*-------------------------------------------------------*/

		//納品予定用商品コードラベル
		JLabel lblNewLabel_4 = new JLabel("商品コード：");
		lblNewLabel_4.setBounds(75, 320, 73, 13);
		contentPane.add(lblNewLabel_4);

		//納品予定用商品コード入力欄
		textField3 = new JTextField();
		textField3.setBounds(152, 320, 96, 19);
		contentPane.add(textField3);
		textField3.setColumns(10);

		//納品予定用食品期限ラベル
		JLabel lblNewLabel_5 = new JLabel("納品予定：");
		lblNewLabel_5.setBounds(260, 320, 73, 13);
		contentPane.add(lblNewLabel_5);

		//納品予定用食品期限入力欄
		DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
		textField4 = new JFormattedTextField(df);
		try {
			MaskFormatter dateMask = new MaskFormatter("####/##/##");
			dateMask.install(textField4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		textField4.setBounds(320, 320, 96, 19);
		contentPane.add(textField4);
		textField4.setColumns(10);
		

		JButton btnNewButton2 = new JButton("納品日変更");
		btnNewButton2.setBounds(430, 320, 110, 21);
		btnNewButton2.setActionCommand("btnNewButton2");
		btnNewButton2.addActionListener(this);
		contentPane.add(btnNewButton2);

		/*-------------------------------------------------------*/
		
		//商品コードラベル
		JLabel lblNewLabel_2 = new JLabel("商品コード：");
		lblNewLabel_2.setBounds(75, 350, 73, 13);
		contentPane.add(lblNewLabel_2);

		//商品コード入力欄
		textField = new JTextField();
		textField.setBounds(152, 350, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		//食品期限ラベル
		JLabel lblNewLabel_3 = new JLabel("食品期限：");
		lblNewLabel_3.setBounds(260, 350, 73, 13);
		contentPane.add(lblNewLabel_3);

		//食品期限入力欄;
		DateFormat df2 = new SimpleDateFormat("yyyy/mm/dd");
		textField2 = new JFormattedTextField(df2);
		try {
			MaskFormatter dateMask2 = new MaskFormatter("####/##/##");
			dateMask2.install(textField2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		textField2.setBounds(320, 350, 96, 19);
		contentPane.add(textField2);
		textField2.setColumns(10);

		JButton btnNewButton = new JButton("納品確定");
		btnNewButton.setBounds(430, 350, 110, 21);
		btnNewButton.setActionCommand("btnNewButton");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		/*-------------------------------------------------------*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//発注表ボタンを押した際の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}
		
		
		//納品日変更ボタンを押した際の処理
		if (cmd.equals("btnNewButton2")) {
			String pCode = textField3.getText();
			String date = textField4.getText();
			//未入力チェック
			if(pCode.equals("") || date.equals("    /  /  ") || date.equals("")) {
				JOptionPane.showMessageDialog(contentPane, "商品コードまたは納品予定を入力してください。");
			}else {
				OrderHistoryDBAccess ohd = new OrderHistoryDBAccess();
				try {
					ohd.editDeliDate(pCode, date);
					JOptionPane.showMessageDialog(contentPane, "変更しました。");
					setVisible(false);
					HikawaController.OrderHistoryDisplay();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (cmd.equals("btnNewButton")) {
			String pCode = textField.getText();
			String date = textField2.getText();
			//未入力チェック
			if(pCode.equals("") || date.equals("    /  /  ") || date.equals("")) {
				JOptionPane.showMessageDialog(contentPane, "商品コードまたは食品期限を入力してください。");
			}else {
				FoodLimitDBAccess fl = new FoodLimitDBAccess();
				try {
					fl.regFoodLimit(pCode, date);
					JOptionPane.showMessageDialog(contentPane, "確定しました。");
					setVisible(false);
					HikawaController.OrderHistoryDisplay();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "商品コードが正しくありません");
				}
			}
		}
		
		
	}

}