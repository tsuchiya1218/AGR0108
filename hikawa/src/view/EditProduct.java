package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EditProduct extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProduct frame = new EditProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 432);
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
		
		TextField textField = new TextField();
		textField.setBounds(104, 120, 138, 23);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("メーカー：");
		lblNewLabel_3.setBounds(33, 157, 63, 16);
		contentPane.add(lblNewLabel_3);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(104, 155, 138, 23);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("カテゴリ：");
		lblNewLabel_4.setBounds(33, 191, 62, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"肉", "魚", "酒"}));
		comboBox.setBounds(104, 188, 136, 25);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("価格：");
		lblNewLabel_5.setBounds(58, 227, 37, 16);
		contentPane.add(lblNewLabel_5);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(103, 225, 140, 23);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("在庫量：");
		lblNewLabel_6.setBounds(46, 261, 53, 16);
		contentPane.add(lblNewLabel_6);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(102, 260, 142, 23);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_7 = new JLabel("食品期日：");
		lblNewLabel_7.setBounds(33, 296, 66, 16);
		contentPane.add(lblNewLabel_7);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(102, 295, 143, 23);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("商品表");
		btnNewButton.setBounds(231, 24, 83, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確定");
		btnNewButton_1.setBounds(54, 335, 77, 26);
		contentPane.add(btnNewButton_1);
	}

}
