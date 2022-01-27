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

public class AddWasteProduct extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public AddWasteProduct() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("廃棄商品追加画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(208, 48, 165, 26);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 128, 508, 168);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
				},
				new String[] {
						"\u5546\u54C1\u756A\u53F7", "\u5546\u54C1\u540D", "\u500B\u6570", "\u5546\u54C1\u671F\u9650",
						"\u5EC3\u68C4\u5546\u54C1\u8FFD\u52A0"
				}) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class, Integer.class, Object.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(43, 94, 50, 16);
		contentPane.add(lblNewLabel_2);

		TextField textField = new TextField();
		textField.setBounds(94, 93, 117, 23);
		contentPane.add(textField);

		JButton btnSerch = new JButton("検索");
		btnSerch.setBounds(219, 92, 59, 26);
		btnSerch.setActionCommand("btnSerch");
		btnSerch.addActionListener(this);
		contentPane.add(btnSerch);

		JButton btnWaste = new JButton("廃棄一覧表");
		btnWaste.setBounds(454, 23, 98, 26);
		btnWaste.setActionCommand("btnWaste");
		btnWaste.addActionListener(this);
		contentPane.add(btnWaste);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//廃棄一覧表ボタンを押した際の処理
		if (cmd.equals("btnWaste")) {
			setVisible(false);
			HikawaController.WasteDisplay();
		}

		//検索ボタンが押された時の処理
		if (cmd.equals("btnSerch")) {

		}

	}

}
