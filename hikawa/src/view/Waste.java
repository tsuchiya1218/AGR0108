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

public class Waste extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Waste() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("廃棄一覧表画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(175, 53, 144, 26);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 98, 434, 168);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null },
				},
				new String[] {
						"\u5546\u54C1\u756A\u53F7", "\u5546\u54C1\u540D", "\u500B\u6570", "\u5546\u54C1\u671F\u9650", ""
				}) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, Integer.class, Object.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {
					false, false, false, false, true
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(351, 14, 75, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(439, 14, 74, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);

		JButton btnAddWaste = new JButton("廃棄商品追加");
		btnAddWaste.setBounds(50, 288, 111, 26);
		btnAddWaste.setActionCommand("btnAddWaste");
		btnAddWaste.addActionListener(this);
		contentPane.add(btnAddWaste);

		JButton btnWasteConfirm = new JButton("廃棄完了");
		btnWasteConfirm.setBounds(174, 288, 98, 26);
		btnWasteConfirm.setActionCommand("btnWasteConfirm");
		btnWasteConfirm.addActionListener(this);
		contentPane.add(btnWasteConfirm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//トップボタンが押された時の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}

		//廃棄商品追加ボタンを押した際の処理
		if (cmd.equals("btnAddWaste")) {
			setVisible(false);
			HikawaController.AddWastePtoductDisplay();
		}

		//廃棄完了ボタンを押した際の処理
		if (cmd.equals("btnWasteConfirm")) {
			//処理を追加
		}
	}

}
