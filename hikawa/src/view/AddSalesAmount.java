package view;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddSalesAmount extends JFrame implements ActionListener {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public AddSalesAmount() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("売上金額入力");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(91, 51, 124, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("日付：");
		lblNewLabel_2.setBounds(39, 108, 37, 16);
		contentPane.add(lblNewLabel_2);
		
		TextField textField = new TextField();
		textField.setBounds(82, 106, 151, 23);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("売上：");
		lblNewLabel_3.setBounds(39, 151, 37, 16);
		contentPane.add(lblNewLabel_3);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(81, 149, 152, 23);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("売上");
		btnNewButton.setBounds(225, 7, 59, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確認");
		btnNewButton_1.setBounds(52, 195, 67, 26);
		contentPane.add(btnNewButton_1);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
