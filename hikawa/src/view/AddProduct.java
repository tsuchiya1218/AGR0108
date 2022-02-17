package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.HikawaController;
import dao.ProductAdditionDBAccess;

public class AddProduct extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField pNameFeild;
	private JTextField mNameFeild;
	private JComboBox<String> cIDBox;
	private JTextField priceFeild;
	private JComboBox<String> foodLCodeBox;

	/**
	 * Create the frame.
	 */
	public AddProduct() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 97, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("商品追加画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(127, 50, 124, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(72, 95, 50, 16);
		contentPane.add(lblNewLabel_2);

		pNameFeild = new JTextField();
		pNameFeild.setBounds(125, 92, 136, 23);
		contentPane.add(pNameFeild);

		JLabel lblNewLabel_3 = new JLabel("メーカー：");
		lblNewLabel_3.setBounds(59, 126, 64, 16);
		contentPane.add(lblNewLabel_3);

		mNameFeild = new JTextField();
		mNameFeild.setBounds(125, 124, 136, 23);
		contentPane.add(mNameFeild);

		JLabel lblNewLabel_4 = new JLabel("カテゴリ：");
		lblNewLabel_4.setBounds(59, 155, 62, 16);
		contentPane.add(lblNewLabel_4);

		cIDBox = new JComboBox<String>();
		cIDBox.setModel(new DefaultComboBoxModel<String>(new String[] { "肉", "魚", "酒" }));
		cIDBox.setBounds(126, 152, 135, 25);
		contentPane.add(cIDBox);

		JLabel lblNewLabel_5 = new JLabel("価格：");
		lblNewLabel_5.setBounds(84, 184, 39, 16);
		contentPane.add(lblNewLabel_5);

		priceFeild = new JTextField();
		priceFeild.setBounds(125, 182, 135, 23);
		contentPane.add(priceFeild);

		JLabel lblNewLabel_6 = new JLabel("食品期限：");
		lblNewLabel_6.setBounds(60, 214, 66, 16);
		contentPane.add(lblNewLabel_6);

		foodLCodeBox = new JComboBox<String>();
		foodLCodeBox.setModel(new DefaultComboBoxModel<String>(new String[] { "消費", "賞味" }));
		foodLCodeBox.setBounds(125, 211, 136, 25);
		contentPane.add(foodLCodeBox);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(291, 12, 82, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton btnAdd = new JButton("追加");
		btnAdd.setBounds(78, 257, 82, 26);
		btnAdd.setActionCommand("btnAdd");
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		// 追加ボタンが押された時の処理
		if (cmd.equals("btnAdd")) {
			String pName = pNameFeild.getText();
			String mName = mNameFeild.getText();
			String cIDS = (String) cIDBox.getSelectedItem();
			String cID = null;
			int price = Integer.parseInt(priceFeild.getText());
			String foodLCode = (String) foodLCodeBox.getSelectedItem();

			//コンボボックスで選択した食品期限をコードに変換
			if(foodLCode == "消費") {
				foodLCode = "01";
			}else if(foodLCode == "賞味") {
				foodLCode = "02";
			}

			//コンボボックスで選択したカテゴリーをコードに変換
			if(cIDS == "肉") {
				cID = "02";
			}

			ProductAdditionDBAccess pad = new ProductAdditionDBAccess(pName, mName, cID, price, foodLCode);
			try {

				pad.productAddition();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}

		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}
	}
}
