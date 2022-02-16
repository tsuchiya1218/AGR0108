package view;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddProduct extends JFrame {

	private JPanel contentPane;


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

		TextField textField = new TextField();
		textField.setBounds(125, 92, 136, 23);
		contentPane.add(textField);

		JLabel lblNewLabel_3 = new JLabel("メーカー：");
		lblNewLabel_3.setBounds(59, 126, 64, 16);
		contentPane.add(lblNewLabel_3);

		TextField textField_1 = new TextField();
		textField_1.setBounds(125, 124, 136, 23);
		contentPane.add(textField_1);

		JLabel lblNewLabel_4 = new JLabel("カテゴリ：");
		lblNewLabel_4.setBounds(59, 155, 62, 16);
		contentPane.add(lblNewLabel_4);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"肉", "魚", "酒"}));
		comboBox.setBounds(126, 152, 135, 25);
		contentPane.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("価格：");
		lblNewLabel_5.setBounds(84, 184, 39, 16);
		contentPane.add(lblNewLabel_5);

		TextField textField_2 = new TextField();
		textField_2.setBounds(125, 182, 135, 23);
		contentPane.add(textField_2);

		JLabel lblNewLabel_6 = new JLabel("食品期限：");
		lblNewLabel_6.setBounds(60, 214, 66, 16);
		contentPane.add(lblNewLabel_6);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"消費", "賞味"}));
		comboBox_1.setBounds(125, 211, 136, 25);
		contentPane.add(comboBox_1);

		JButton btnNewButton = new JButton("商品表");
		btnNewButton.setBounds(291, 12, 82, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("追加");
		btnNewButton_1.setBounds(78, 257, 82, 26);
		contentPane.add(btnNewButton_1);
	}
}
