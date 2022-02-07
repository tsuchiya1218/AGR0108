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

public class ProductTable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	
	private TextField AddOrdertext;
	private TextField EditProducttext;
	private TextField Deletetext;

	/**
	 * Create the frame.
	 */
	public ProductTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 481);
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

		TextField btnSerchtext = new TextField();
		btnSerchtext.setBounds(87, 70, 120, 23);
		contentPane.add(btnSerchtext);

		JButton btnSerch = new JButton("検索");
		btnSerch.setBounds(213, 67, 63, 26);
		btnSerch.setActionCommand("btnSerch");
		btnSerch.addActionListener(this);
		contentPane.add(btnSerch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 109, 811, 213);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "\u767A\u6CE8\u72B6\u6CC1", "\u5546\u54C1\u30B3\u30FC\u30C9", "\u5546\u54C1\u540D",
						"\u30AB\u30C6\u30B4\u30EA\u30FC", "\u5024\u6BB5", "\u30E1\u30FC\u30AB\u30FC\u540D",
						"\u5728\u5EAB\u91CF", "\u98DF\u54C1\u671F\u9650" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Integer.class,
					String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(33, 404, 91, 26);
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

		JLabel lblNewLabel_3 = new JLabel("＊以下の入力欄には商品コードを入力してください。");
		lblNewLabel_3.setBounds(38, 329, 304, 16);
		contentPane.add(lblNewLabel_3);

		TextField AddOrdertext = new TextField();
		AddOrdertext.setBounds(29, 353, 95, 23);
		contentPane.add(AddOrdertext);

		JButton btnAddOrder = new JButton("発注追加");
		btnAddOrder.setActionCommand("btnAddOrder");
		btnAddOrder.addActionListener(this);
		btnAddOrder.setBounds(129, 352, 85, 26);
		contentPane.add(btnAddOrder);

		TextField EditProducttext = new TextField();
		EditProducttext.setBounds(247, 353, 95, 23);
		contentPane.add(EditProducttext);

		JButton btnEditProduct = new JButton("商品編集");
		btnEditProduct.setActionCommand("btnEditProduct");
		btnEditProduct.addActionListener(this);
		btnEditProduct.setBounds(349, 352, 88, 26);
		contentPane.add(btnEditProduct);

		TextField Deletetext = new TextField();
		Deletetext.setBounds(460, 353, 95, 23);
		contentPane.add(Deletetext);

		JButton btnDelete = new JButton("削除");
		btnDelete.setActionCommand("btnDelete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(562, 352, 60, 26);
		contentPane.add(btnDelete);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		// 検索ボタンが押された時の処理
		if (cmd.equals("btnSerch")) {

		}

		// 廃棄一覧表ボタンが押された時の処理
		if (cmd.equals("btnWaste")) {
			setVisible(false);
			HikawaController.WasteDisplay();
		}

		// トップボタンが押された時の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		// 発注表ボタンが押された時の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}
		// 発注追加ボタンが押された時の処理
		if (cmd.equals("btnAddOrder")) {
			Integer ProductCode = Integer.parseInt(AddOrdertext.getText());
		}

		// 商品編集ボタンが押された時の処理
		if (cmd.equals("btnEditProduct")) {
			//Integer ProductCode = Integer.parseInt(EditProducttext.getText());
			//System.out.println(ProductCode);
			
			setVisible(false);
	    	HikawaController.EditProductDisplay();
		}

		// 削除ボタンが押された時の処理
		if (cmd.equals("btnDelete")) {
			Integer ProductCode = Integer.parseInt(Deletetext.getText());
		}
	}
}
