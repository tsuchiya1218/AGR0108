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

public class ProductTable extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public ProductTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商品表画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(374, 39, 110, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(33, 72, 55, 16);
		contentPane.add(lblNewLabel_2);
		
		TextField textField = new TextField();
		textField.setBounds(87, 70, 120, 23);
		contentPane.add(textField);
		
		JButton btnSerch = new JButton("検索");
		btnSerch.setBounds(213, 67, 63, 26);
		btnSerch.setActionCommand("btnSerch");
		btnSerch.addActionListener(this);
		contentPane.add(btnSerch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 109, 811, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u767A\u6CE8\u72B6\u6CC1", "\u5546\u54C1\u30B3\u30FC\u30C9", "\u5546\u54C1\u540D", "\u30AB\u30C6\u30B4\u30EA\u30FC", "\u5024\u6BB5", "\u30E1\u30FC\u30AB\u30FC\u540D", "\u5728\u5EAB\u91CF", "\u98DF\u54C1\u671F\u9650", "\u767A\u6CE8", "\u5546\u54C1\u60C5\u5831", "\u524A\u9664"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				//編集可能→true 不可→	false
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(69, 343, 91, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);
		
		JButton btnWaste = new JButton("廃棄一覧表");
		btnWaste.setBounds(625, 54, 120, 26);
		btnWaste.setActionCommand("btnWaste");
		btnWaste.addActionListener(this);
		contentPane.add(btnWaste);
		
		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(755, 54, 77, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);
	}
	

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//検索ボタンが押された時の処理
		if (cmd.equals("btnSerch")) {

		}

		//発注表ボタンが押された時の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}

		//廃棄一覧表ボタンが押された時の処理
		if (cmd.equals("btnWaste")) {
			setVisible(false);
			HikawaController.WasteDisplay();
		}

		//トップボタンが押された時の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}
	}
}
