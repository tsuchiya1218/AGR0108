package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.HikawaController;

public class AddSalesAmount extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField dateFeild;
	private JTextField amountFeild;

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

		dateFeild = new JTextField();
		dateFeild.setBounds(82, 106, 151, 23);
		contentPane.add(dateFeild);

		/*TextField textField = new TextField();
		textField.setBounds(82, 106, 151, 23);
		contentPane.add(textField);
		*/
		JLabel lblNewLabel_3 = new JLabel("売上：");
		lblNewLabel_3.setBounds(39, 151, 37, 16);
		contentPane.add(lblNewLabel_3);

		amountFeild = new JTextField();
		amountFeild.setBounds(81, 149, 152, 23);
		contentPane.add(amountFeild);

		/*
		TextField textField_1 = new TextField();
		textField_1.setBounds(81, 149, 152, 23);
		contentPane.add(textField_1);
		*/
		JButton btnSales = new JButton("売上");
		btnSales.setBounds(225, 7, 59, 26);
		btnSales.setActionCommand("btnSales");
		btnSales.addActionListener(this);
		contentPane.add(btnSales);

		JButton btnCheck = new JButton("確認");
		btnCheck.setBounds(52, 195, 67, 26);
		btnCheck.setActionCommand("btnCheck");
		btnCheck.addActionListener(this);
		contentPane.add(btnCheck);
	}
	
	static String date = null;
	static int amount = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//String date = null;
		//Integer amount = null;

		//売上ボタンを押した際の処理
		if (cmd.equals("btnSales")) {
			HikawaController.SalesDisplay();
		}

		//確認ボタンを押した際の処理
		if (cmd.equals("btnCheck")) {
			try {
				try {
					date = dateFeild.getText();
					amount = Integer.parseInt(amountFeild.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "項目を入力してください");
				}
				HikawaController.AddSalesAmountCheckDisplay();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static String getDate() {
		return date;
	}	
	public static int getAmount() {
		return amount;
	}
}