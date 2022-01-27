package view;

import java.awt.Font;
import java.awt.TextField;
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

import control.HikawaController;

public class ProductSelectionSales extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ProductSelectionSales() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 121, 345, 171);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
				},
				new String[] {
						"\u5546\u54C1\u756A\u53F7", "\u5546\u54C1\u540D", ""
				}) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Object.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
					false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("売上商品選択画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(129, 41, 165, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(40, 95, 50, 16);
		contentPane.add(lblNewLabel_2);

		TextField textField = new TextField();
		textField.setBounds(94, 92, 127, 23);
		contentPane.add(textField);

		JButton btnSerch = new JButton("検索");
		btnSerch.setBounds(227, 90, 66, 26);
		btnSerch.setActionCommand("btnSerch");
		btnSerch.addActionListener(this);
		contentPane.add(btnSerch);

		JButton btnSales = new JButton("売上");
		btnSales.setBounds(337, 18, 71, 26);
		btnSales.setActionCommand("btnSales");
		btnSales.addActionListener(this);
		contentPane.add(btnSales);

		JButton btnProductSalesQuantity = new JButton("個数入力");
		btnProductSalesQuantity.setBounds(53, 307, 88, 26);
		btnProductSalesQuantity.setActionCommand("btnProductSalesQuantity");
		btnProductSalesQuantity.addActionListener(this);
		contentPane.add(btnProductSalesQuantity);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//検索ボタンが押された時の処理
		if (cmd.equals("btnSerch")) {

		}

		//売上ボタンを押した際の処理
		if (cmd.equals("btnSales")) {
			setVisible(false);
			HikawaController.SalesDisplay();
		}

		//個数入力ボタンを押した際の処理
		if (cmd.equals("btnProductSalesQuantity")) {
			setVisible(false);
			HikawaController.ProductSalesQuantityDisplay();
		}
	}

}
