package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
		setBounds(100, 100, 448, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ログイン画面");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("従業員番号: ");
		label.setBounds(97, 33, 68, 16);
		panel_1.add(label);
		
		TextField textField = new TextField();
		textField.setBounds(175, 30, 145, 23);
		textField.setColumns(15);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("パスワード: ");
		lblNewLabel_1.setBounds(97, 65, 74, 16);
		panel_1.add(lblNewLabel_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(175, 64, 145, 23);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("ログイン");
		btnNewButton.setBounds(101, 127, 92, 26);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("リセット");
		btnNewButton_1.setBounds(225, 127, 92, 26);
		panel_1.add(btnNewButton_1);
	}
}
