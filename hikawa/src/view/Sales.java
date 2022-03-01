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
import dao.SalesDBAccess;

public class Sales extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Create the frame.
	 */
	public Sales() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 88, 358, 144);
		contentPane.add(scrollPane);

		/*table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u65E5\u4ED8", "\u91D1\u984D"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);*/
		
		String[] columnNames = { "日付", "金額"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);

		try {
			SalesDBAccess sda = new SalesDBAccess();

			//列の入れ替えを禁止
			table.getTableHeader().setReorderingAllowed(false);

			//列の幅指定
			table.getColumn("日付").setPreferredWidth(100);
			table.getColumn("金額").setPreferredWidth(100);
			String[][] tabledata = CreateTableData.SalesToArray(sda.getSales());
			if (tabledata != null) {
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);
		

		JLabel lblNewLabel_1 = new JLabel("売上画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(159, 39, 91, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(312, 7, 71, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);

		JButton btnAddSale = new JButton("売上金額入力");
		btnAddSale.setBounds(53, 258, 108, 26);
		btnAddSale.setActionCommand("btnAddSale");
		btnAddSale.addActionListener(this);
		contentPane.add(btnAddSale);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//トップボタンを押した際の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		//売上金額入力ボタンを押した際の処理
		if (cmd.equals("btnAddSale")) {
			setVisible(false);
			HikawaController.AddSaleDisplay();
		}

	}

}