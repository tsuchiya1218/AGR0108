package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("従業員番号: ");
		label.setBounds(98, 97, 68, 16);
		panel_1.add(label);
		
		TextField textField = new TextField();
		textField.setBounds(176, 94, 145, 23);
		textField.setColumns(15);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("パスワード: ");
		lblNewLabel_1.setBounds(98, 129, 74, 16);
		panel_1.add(lblNewLabel_1);
		
		//JPasswordField textField_1 = new JPasswordField();
		TextField textField_1 = new TextField();
		textField_1.setBounds(176, 128, 145, 23);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("ログイン");
		btnNewButton.setBounds(102, 191, 92, 26);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("リセット");
		btnNewButton_1.setBounds(226, 191, 92, 26);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ログイン画面");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 41, 136, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("hikawaシステム");
		lblNewLabel_2.setBounds(12, 12, 92, 16);
		panel_1.add(lblNewLabel_2);
	}
}
