package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import action.CreateTableData;
import control.HikawaController;
import dao.OrderHistoryDBAccess;

public class OrderHistory extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField, textField2;
	private DefaultTableModel tableModel;


	/**
	 * Create the frame.
	 */
	public OrderHistory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 419);
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

		String[] columnNames = { "発注日", "商品コード", "商品名", "個数", "納品予定日", "状況"};
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

		JLabel lblNewLabel_2 = new JLabel("商品コード：");
		lblNewLabel_2.setBounds(75, 328, 73, 13);
		contentPane.add(lblNewLabel_2);
		
		//商品コード入力欄
		textField = new JTextField();
		textField.setBounds(152, 325, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("食品期限：");
		lblNewLabel_3.setBounds(260, 328, 73, 13);
		contentPane.add(lblNewLabel_3);
		
		//食品期限入力欄
		textField2 = new JTextField();
		textField2.setBounds(320, 325, 96, 19);
		contentPane.add(textField2);
		textField2.setColumns(10);

		JButton btnNewButton = new JButton("納品確定");
		btnNewButton.setBounds(430, 324, 73, 21);
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//発注表ボタンを押した際の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}
	}

}