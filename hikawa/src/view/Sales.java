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

import control.HikawaController;

public class Sales extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Sales() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 88, 460, 144);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
				},
				new String[] {
						"\u65E5\u4ED8", "\u9031\u8A73\u7D30", "\u9031\u5408\u8A08", "\u6708\u5408\u8A08",
						"\u5E74\u5408\u8A08"
				}) {
			Class[] columnTypes = new Class[] {
					String.class, Object.class, Integer.class, Integer.class, Integer.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
					true, false, true, true, true
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("売上画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(200, 39, 91, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(405, 12, 71, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);

		JButton btnAddSale = new JButton("売上金額入力");
		btnAddSale.setBounds(22, 255, 108, 26);
		btnAddSale.setActionCommand("btnAddSale");
		btnAddSale.addActionListener(this);
		contentPane.add(btnAddSale);

		JButton btnProductSelectionSales = new JButton("売上商品選択");
		btnProductSelectionSales.setBounds(196, 255, 115, 26);
		btnProductSelectionSales.setActionCommand("btnProductSelectionSales");
		btnProductSelectionSales.addActionListener(this);
		contentPane.add(btnProductSelectionSales);

		JButton SaleProductHistory = new JButton("売上商品履歴");
		SaleProductHistory.setBounds(374, 254, 108, 26);
		SaleProductHistory.setActionCommand("SaleProductHistory");
		SaleProductHistory.addActionListener(this);
		contentPane.add(SaleProductHistory);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//発注表ボタンを押した際の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		//売上金額入力ボタンを押した際の処理
		if (cmd.equals("btnAddSale")) {
			setVisible(false);
			HikawaController.AddSaleDisplay();
		}
		
		//売上商品選択ボタンを押した際の処理
		if (cmd.equals("btnProductSelectionSales")) {
			setVisible(false);
			HikawaController.ProductSelectionSalesDisplay();
		}
		
		//売上商品履歴ボタンを押した際の処理
		if (cmd.equals("SaleProductHistory")) {
			setVisible(false);
			HikawaController.SaleProductHistoryDisplay();
		}
	}

}
