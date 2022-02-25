package view;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.HikawaController;
import dao.ProductEditDBAccess;

public class EditProduct extends JFrame implements ActionListener {
	String pCode;

	private JPanel contentPane;
	JComboBox<String> cIDBox;
	TextField foodlimitFeild;
	TextField stockFeild;
	TextField priceFeild;
	JComboBox<String> mNameBox;
	TextField pNameFeild;

	public EditProduct(String pCode) {
		this.pCode = pCode;
	}

	/**
	 * Create the frame.
	 * @throws Exception
	 */

	public void EditProducts() throws Exception {
		setVisible(true);
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
		lblNewLabel_1.setBounds(104, 62, 124, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(46, 123, 50, 16);
		contentPane.add(lblNewLabel_2);

		pNameFeild = new TextField();
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

		JLabel lblNewLabel_5 = new JLabel("価格：");
		lblNewLabel_5.setBounds(58, 190, 37, 16);
		contentPane.add(lblNewLabel_5);

		priceFeild = new TextField();
		priceFeild.setBounds(103, 190, 140, 23);
		contentPane.add(priceFeild);

		JLabel lblNewLabel_6 = new JLabel("在庫量：");
		lblNewLabel_6.setBounds(46, 230, 53, 16);
		contentPane.add(lblNewLabel_6);

		stockFeild = new TextField();
		stockFeild.setBounds(102,230, 142, 23);
		contentPane.add(stockFeild);

		JLabel lblNewLabel_7 = new JLabel("食品期日：");
		lblNewLabel_7.setBounds(33, 260, 66, 16);
		contentPane.add(lblNewLabel_7);

		foodlimitFeild = new TextField();
		foodlimitFeild.setBounds(102, 260, 143, 23);
		contentPane.add(foodlimitFeild);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(231, 24, 83, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton Confirm = new JButton("確定");
		Confirm.setActionCommand("Confirm");
		Confirm.addActionListener(this);
		Confirm.setBounds(54, 300, 77, 26);
		contentPane.add(Confirm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String pName = null;
		String mName = null;
		Integer price = null;
		Integer stock = null;
		String foodlimit = null;
		//確定ボタンが押された時の処理
		if (cmd.equals("Confirm")) {

			try {

				//入力判定
				pName = pNameFeild.getText();
				mName = (String) mNameBox.getSelectedItem();
				price = Integer.parseInt(priceFeild.getText());
				stock = Integer.parseInt(stockFeild.getText());
				foodlimit = foodlimitFeild.getText();

				ProductEditDBAccess ped = new ProductEditDBAccess(pCode, pName, mName, price, stock, foodlimit);
				ped.ProductEdit();

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(contentPane, "項目を入力してください");
			}

		}

		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}
	}

}

