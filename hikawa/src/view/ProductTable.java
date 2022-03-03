package view;

import java.awt.Font;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import action.CreateTableData;
import control.HikawaController;
import dao.OrderTableDBAccess;
import dao.ProductDeleteDBAccess;
import dao.ProductSearchDBAccess;
import dao.ProductTableDBAccess;

public class ProductTable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	private TextField AddOrdertext;
	private TextField Deletetext;
	private TextField EditProducttext;
	private JScrollPane scrollPane;
	private TextComponent btnSerchtext;
	private DefaultTableModel tableModel;
	private JTextField wastetext;

	/**
	 * Create the frame.
	 * @throws Exception
	 */
	public ProductTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 497);
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
		lblNewLabel_2.setBounds(29, 103, 55, 16);
		contentPane.add(lblNewLabel_2);

		btnSerchtext = new TextField();
		btnSerchtext.setBounds(83, 101, 120, 23);
		contentPane.add(btnSerchtext);

		JButton btnSerch = new JButton("検索");
		btnSerch.setBounds(209, 98, 63, 26);
		btnSerch.setActionCommand("btnSerch");
		btnSerch.addActionListener(this);
		contentPane.add(btnSerch);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 134, 811, 213);
		contentPane.add(scrollPane);

		String[] columnNames = { "発注状況", "商品コード", "商品名", "カテゴリー", "値段", "メーカー名", "在庫量", "食品期限" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);

		try {
			ProductTableDBAccess ptd = new ProductTableDBAccess();

			//列の入れ替えを禁止
			table.getTableHeader().setReorderingAllowed(false);

			//列の幅指定
			table.getColumn("発注状況").setPreferredWidth(90);
			table.getColumn("商品コード").setPreferredWidth(100);
			table.getColumn("商品名").setPreferredWidth(350);
			table.getColumn("カテゴリー").setPreferredWidth(90);
			table.getColumn("値段").setPreferredWidth(80);
			table.getColumn("メーカー名").setPreferredWidth(150);
			table.getColumn("在庫量").setPreferredWidth(50);
			table.getColumn("食品期限").setPreferredWidth(135);

			String[][] tabledata = CreateTableData.productTableToArray(ptd.getProductTable());
			if (tabledata != null) {
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

		/*
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

		*/

		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(33, 424, 91, 26);
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
		lblNewLabel_3.setBounds(40, 357, 304, 16);
		contentPane.add(lblNewLabel_3);

		AddOrdertext = new TextField();
		AddOrdertext.setBounds(31, 381, 95, 23);
		contentPane.add(AddOrdertext);

		JButton btnAddOrder = new JButton("発注追加");
		btnAddOrder.setActionCommand("btnAddOrder");
		btnAddOrder.addActionListener(this);
		btnAddOrder.setBounds(131, 380, 85, 26);
		contentPane.add(btnAddOrder);

		EditProducttext = new TextField();
		EditProducttext.setBounds(236, 381, 95, 23);
		contentPane.add(EditProducttext);

		JButton btnEditProduct = new JButton("商品編集");
		btnEditProduct.setActionCommand("btnEditProduct");
		btnEditProduct.addActionListener(this);
		btnEditProduct.setBounds(337, 380, 88, 26);
		contentPane.add(btnEditProduct);

		Deletetext = new TextField();
		Deletetext.setBounds(446, 381, 95, 23);
		contentPane.add(Deletetext);

		JButton btnDelete = new JButton("商品削除");
		btnDelete.setActionCommand("btnDelete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(547, 380, 91, 26);
		contentPane.add(btnDelete);

		JButton btnAddProduct = new JButton("商品追加");
		btnAddProduct.setActionCommand("btnAddProduct");
		btnAddProduct.addActionListener(this);
		btnAddProduct.setBounds(151, 424, 95, 26);
		contentPane.add(btnAddProduct);

		wastetext = new JTextField();
		wastetext.setBounds(654, 381, 104, 23);
		contentPane.add(wastetext);
		wastetext.setColumns(10);

		JButton btnwasteAdd = new JButton("廃棄追加");
		btnwasteAdd.setActionCommand("btnwasteAdd");
		btnwasteAdd.addActionListener(this);
		btnwasteAdd.setBounds(768, 380, 87, 26);
		contentPane.add(btnwasteAdd);

		JButton btnfoodlimitASC = new JButton("昇順");
		btnfoodlimitASC.setActionCommand("btnfoodlimitASC");
		btnfoodlimitASC.addActionListener(this);
		btnfoodlimitASC.setBounds(777, 101, 63, 21);
		contentPane.add(btnfoodlimitASC);

		JLabel lblNewLabel_4 = new JLabel("食品期限が近い順に表示する：");
		lblNewLabel_4.setBounds(610, 106, 168, 13);
		contentPane.add(lblNewLabel_4);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		String sName = null;
		ProductSearchDBAccess psd = null;

		// 検索ボタンが押された時の処理
		if (cmd.equals("btnSerch")) {
			//テキストフィールド内の情報を取得
			sName = btnSerchtext.getText();
			if (!(sName.equals(""))) {
				try {

					psd = new ProductSearchDBAccess(sName);
					psd.productSerchByName(sName);

					tableModel.setRowCount(0);

					String[][] searchdata = CreateTableData.productTableToArray(psd.productSerchByName(sName));
					for (String[] rowData : searchdata) {
						tableModel.addRow(rowData);
					}
				} catch (Exception ex1) {
					JOptionPane.showMessageDialog(contentPane, "商品名を入力してください");
				}
			} else {
				try {
					tableModel.setRowCount(0);
					ProductTableDBAccess ptd = new ProductTableDBAccess();

					String[][] tabledata = CreateTableData.productTableToArray(ptd.getProductTable());
					for (String[] data : tabledata) {
						tableModel.addRow(data);
					}
				} catch (Exception ex2) {
					ex2.printStackTrace();
				}
			}
			scrollPane.setViewportView(table);
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
			//入力された商品コードをpCodeに代入
			String pCode = AddOrdertext.getText();
			OrderTableDBAccess otd = new OrderTableDBAccess();
			//商品コードの入力判定
			if (!pCode.equals("")) {
				try {
					String pName = otd.serchPName(pCode);
					//商品コードが存在するか判定
					if (pName != null) {
						try {
							otd.addOrderTable(pCode);
							JOptionPane.showMessageDialog(contentPane, pName + "を発注表に追加しました。");
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "存在しない商品コードです。");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください。");
			}
		}

		// 商品編集ボタンが押された時の処理
		if (cmd.equals("btnEditProduct")) {
			String ProductCode = null;
			try {
				ProductCode = EditProducttext.getText();

				if (!ProductCode.equals("")) {

					setVisible(false);
					EditProduct ep = new EditProduct(ProductCode);
					ep.EditProducts();
				} else {
					JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 削除ボタンが押された時の処理
		if (cmd.equals("btnDelete")) {
			String ProductCode = null;
			try {
				//入力判定
				try {
					ProductCode = Deletetext.getText();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください");
				}
				ProductDeleteDBAccess pdd = new ProductDeleteDBAccess(ProductCode);
				pdd.ProductDelete();

				JOptionPane.showMessageDialog(contentPane, "該当商品を削除しました");

				//再読み込み
				setVisible(false);
				HikawaController.ProductTableDisplay();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 商品追加ボタンが押された時の処理
		if (cmd.equals("btnAddProduct")) {
			setVisible(false);
			try {
				HikawaController.AddProductDisplay();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}

		// 食品期限昇順ボタンが押された時の処理
		if (cmd.equals("btnfoodlimitASC")) {
			try {
				tableModel.setRowCount(0);
				ProductTableDBAccess ptd = new ProductTableDBAccess();

				String[][] tabledata = CreateTableData.productTableToArray(ptd.getfoodlimitTable());
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		// 廃棄商品追加ボタンが押された時の処理
		if (cmd.equals("btnwasteAdd")) {

		}
	}
}