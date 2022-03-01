package view;

import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.HikawaController;
import dao.ProductAdditionDBAccess;

public class AddProduct extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField pNameFeild;
	private JTextField mNameFeild;
	private JComboBox<String> cIDBox;
	private JTextField SpriceFeild;
	private JTextField PpriceFeild;

	/**
	 * Create the frame.
	 * @throws Exception
	 */
	public AddProduct() throws Exception {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 324);
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
		lblNewLabel_2.setBounds(55, 95, 63, 16);
		contentPane.add(lblNewLabel_2);

		pNameFeild = new JTextField();
		pNameFeild.setBounds(125, 92, 136, 23);
		contentPane.add(pNameFeild);

		JLabel lblNewLabel_3 = new JLabel("メーカー：");
		lblNewLabel_3.setBounds(56, 126, 65, 16);
		contentPane.add(lblNewLabel_3);

		mNameFeild = new JTextField();
		mNameFeild.setBounds(125, 124, 136, 23);
		contentPane.add(mNameFeild);

		JLabel lblNewLabel_4 = new JLabel("カテゴリ：");
		lblNewLabel_4.setBounds(60, 154, 62, 16);
		contentPane.add(lblNewLabel_4);

		//DBからカテゴリー名を取得、表示
		List<String> list2 = ProductAdditionDBAccess.ProductCategory();
		String[] lists2 = new String[list2.size()];
		for (int i = 0; i < list2.size(); i++) {
			lists2[i] = list2.get(i);
		}

		cIDBox = new JComboBox<String>();
		cIDBox.setModel(new DefaultComboBoxModel<String>(lists2));
		cIDBox.setBounds(126, 152, 135, 25);
		contentPane.add(cIDBox);

		JLabel lblNewLabel_5 = new JLabel("販売価格：");
		lblNewLabel_5.setBounds(46, 185, 63, 16);
		contentPane.add(lblNewLabel_5);

		SpriceFeild = new JTextField();
		SpriceFeild.setBounds(125, 182, 135, 23);
		contentPane.add(SpriceFeild);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(254, 10, 82, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton btnAdd = new JButton("追加");
		btnAdd.setBounds(74, 249, 82, 26);
		btnAdd.setActionCommand("btnAdd");
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);

		JLabel lblNewLabel_7 = new JLabel("仕入価格：");
		lblNewLabel_7.setBounds(46, 220, 63, 13);
		contentPane.add(lblNewLabel_7);

		PpriceFeild = new JTextField();
		PpriceFeild.setBounds(126, 215, 134, 19);
		contentPane.add(PpriceFeild);
		PpriceFeild.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String pName = null;
		String mName = null;
		String cID = null;
		Integer Sprice = null;
		Integer Pprice = null;
		ProductAdditionDBAccess pad = null;
		// 追加ボタンが押された時の処理
		if (cmd.equals("btnAdd")) {

			try {

				//項目が入力されていなかったときの処理
				try {
					pName = pNameFeild.getText();
					mName = mNameFeild.getText();
					cID = (String) cIDBox.getSelectedItem();
					Sprice = Integer.parseInt(SpriceFeild.getText());
					Pprice = Integer.parseInt(PpriceFeild.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "項目を入力してください");
				}

				/*//コンボボックスで選択した食品期限をコードに変換
				if (foodLCode == "消費") {
					foodLCode = "01";
				} else if (foodLCode == "賞味") {
					foodLCode = "02";
				}*/

				pad = new ProductAdditionDBAccess(pName, mName, cID, Sprice,Pprice);
				pad.productAddition();
				JOptionPane.showMessageDialog(contentPane, "追加完了しました");
			} catch (Exception e1) {
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
