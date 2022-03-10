package view;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.HikawaController;
import dao.ProductEditDBAccess;

public class EditProduct extends JFrame implements ActionListener {
	String pCode, pName, foodlimit;
	Integer sellPrice, purPrice, stock;

	private JPanel contentPane;
	JComboBox<String> cIDBox;
	JFormattedTextField foodlimitFeild;
	TextField stockFeild;
	TextField SpriceFeild;
	TextField PpriceFeild;
	JComboBox<String> mNameBox;
	TextField pNameFeild;

	public EditProduct(String pCode, String pName, int sellPrice, int purPrice, int stock, String foodlimit) {
		this.pCode = pCode;
		this.pName = pName;
		this.sellPrice = sellPrice;
		this.purPrice = purPrice;
		this.stock = stock;
		this.foodlimit = foodlimit;
	}

	/**
	 * Create the frame.
	 * @throws Exception
	 */

	public void EditProducts() throws Exception {
		setVisible(true);

		//入力制限
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("####-##-##");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("商品編集画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(104, 50, 124, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_9 = new JLabel("商品コード:" + pCode + "  商品名:" + pName);
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_9.setBounds(15, 85, 700, 33);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(46, 123, 50, 16);
		contentPane.add(lblNewLabel_2);

		pNameFeild = new TextField(pName);
		pNameFeild.setBounds(104, 120, 138, 23);
		contentPane.add(pNameFeild);

		JLabel lblNewLabel_3 = new JLabel("メーカー：");
		lblNewLabel_3.setBounds(33, 157, 63, 16);
		contentPane.add(lblNewLabel_3);

		//DBからメーカーを取得、表示
		List<String> list1 = ProductEditDBAccess.ProductMaker();
		String[] lists1 = new String[list1.size()];
		for (int i = 0; i < list1.size(); i++) {
			lists1[i] = list1.get(i);
		}
		mNameBox = new JComboBox<String>();
		mNameBox.setModel(new DefaultComboBoxModel<String>(lists1));
		mNameBox.setBounds(104, 155, 138, 23);
		contentPane.add(mNameBox);

		JLabel lblNewLabel_5 = new JLabel("販売価格：");
		lblNewLabel_5.setBounds(30, 190, 70, 16);
		contentPane.add(lblNewLabel_5);

		SpriceFeild = new TextField();
		SpriceFeild.setText(sellPrice.toString());
		SpriceFeild.setBounds(103, 190, 140, 23);
		contentPane.add(SpriceFeild);

		JLabel lblNewLabel_8 = new JLabel("仕入価格：");
		lblNewLabel_8.setBounds(30, 220, 70, 16);
		contentPane.add(lblNewLabel_8);

		PpriceFeild = new TextField(purPrice.toString());
		PpriceFeild.setBounds(103, 220, 140, 23);
		contentPane.add(PpriceFeild);

		JLabel lblNewLabel_6 = new JLabel("在庫量：");
		lblNewLabel_6.setBounds(46, 250, 53, 16);
		contentPane.add(lblNewLabel_6);

		stockFeild = new TextField(stock.toString());
		stockFeild.setBounds(102, 250, 142, 23);
		contentPane.add(stockFeild);

		JLabel lblNewLabel_7 = new JLabel("食品期日：");
		lblNewLabel_7.setBounds(33, 280, 66, 16);
		contentPane.add(lblNewLabel_7);

		foodlimitFeild = new JFormattedTextField(mf);
		foodlimitFeild.setText(foodlimit);
		foodlimitFeild.setBounds(102, 280, 143, 23);
		contentPane.add(foodlimitFeild);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(231, 24, 83, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton Confirm = new JButton("確定");
		Confirm.setActionCommand("Confirm");
		Confirm.addActionListener(this);
		Confirm.setBounds(54, 315, 77, 26);
		contentPane.add(Confirm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String pName = "";
		String mName = "";
		Integer Sprice = null;
		Integer Pprice = null;
		Integer stock = null;
		String foodlimit = "    -  -  ";
		//確定ボタンが押された時の処理
		if (cmd.equals("Confirm")) {

			for (int i = 0; i < 1; i++) {
				//入力判定
				pName = pNameFeild.getText();
				if (!pName.equals("")) {
					mName = (String) mNameBox.getSelectedItem();
					if (!mName.equals("")) {

						try {
							Sprice = Integer.parseInt(SpriceFeild.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "販売価格には数値を入力してください");
							break;
						}

						if (!(Sprice == null)) {

							try {
								Pprice = Integer.parseInt(PpriceFeild.getText());
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(contentPane, "仕入れ価格には数値を入力してください");
								break;
							}

							if (!(Pprice == null)) {

								try {
									stock = Integer.parseInt(stockFeild.getText());
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(contentPane, "在庫には数値を入力してください");
									break;
								}

								if (!(stock == null)) {
									foodlimit = foodlimitFeild.getText();
									if (!foodlimit.equals("    -  -  ")) {

										ProductEditDBAccess ped = new ProductEditDBAccess(pCode, pName, mName, Sprice,
												Pprice, stock,
												foodlimit);
										try {
											ped.ProductEdit();
										} catch (Exception e1) {
											// TODO 自動生成された catch ブロック
											e1.printStackTrace();
										}

										JOptionPane.showMessageDialog(contentPane, "更新されました");

									} else {
										JOptionPane.showMessageDialog(contentPane, "食品期日を入力してください");
									}

								}
							}

						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "メーカーを選択してください");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "商品名を入力してください");

				}
			}
		}

		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}
	}
}