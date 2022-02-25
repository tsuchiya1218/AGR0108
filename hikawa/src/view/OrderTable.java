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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import action.CreateTableData;
import control.HikawaController;
import dao.OrderHistoryDBAccess;
import dao.OrderTableDBAccess;

public class OrderTable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public OrderTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 300);
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
			
			String[][] tabledata = CreateTableData.orderTableToArray(otd.getOrderTable());
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

		JButton btnOrderHistory = new JButton("発注履歴");
		btnOrderHistory.setBounds(294, 11, 85, 26);
		btnOrderHistory.setActionCommand("btnOrderHistory");
		btnOrderHistory.addActionListener(this);
		contentPane.add(btnOrderHistory);

		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(390, 11, 75, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);

		JButton btnOrder = new JButton("発注");
		btnOrder.setBounds(87, 224, 76, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
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
			setVisible(false);
			OrderHistoryDBAccess ohd = new OrderHistoryDBAccess();
			OrderTableDBAccess otd = new OrderTableDBAccess();
			//発注表に追加
			try {
				ohd.addOrderHistory();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
				System.out.println("発注追加時のエラー");
			}finally {
				try {
					otd.deleteOrderTable();
				} catch (Exception e2) {
					e2.printStackTrace();
					System.out.println("発注表の削除エラー");
				}
			}
		}
	}
}
