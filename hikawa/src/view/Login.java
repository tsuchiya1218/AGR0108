package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import control.HikawaController;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private TextField StaffIDText;
	private JPasswordField PassField;

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
		
		StaffIDText = new TextField();
		StaffIDText.setBounds(176, 94, 145, 23);
		StaffIDText.setColumns(15);
		panel_1.add(StaffIDText);
		
		JLabel lblNewLabel_1 = new JLabel("パスワード: ");
		lblNewLabel_1.setBounds(98, 129, 74, 16);
		panel_1.add(lblNewLabel_1);
		
		PassField = new JPasswordField();
		//TextField textField_1 = new TextField();
		PassField.setBounds(176, 128, 145, 23);
		panel_1.add(PassField);
		
		JButton btnLogin = new JButton("ログイン");
		btnLogin.setBounds(102, 191, 92, 26);
		btnLogin.setActionCommand("Login");
		btnLogin.addActionListener(this);
		panel_1.add(btnLogin);
		
		JButton btnreset = new JButton("リセット");
		btnreset.setBounds(226, 191, 92, 26);
		btnreset.setActionCommand("reset");
		btnreset.addActionListener(this);
		panel_1.add(btnreset);
		
		JLabel lblNewLabel = new JLabel("ログイン画面");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 41, 136, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("hikawaシステム");
		lblNewLabel_2.setBounds(12, 12, 92, 16);
		panel_1.add(lblNewLabel_2);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e){
	    String cmd = e.getActionCommand();
	    
	    //ログインボタンが押された時の処理
	    if (cmd.equals("Login")){
	    	String StaffID = StaffIDText.getText();
	    	System.out.println(StaffID);
	    	
	    	char[] password = PassField.getPassword();
	    	System.out.println(password);
	    	
	    	setVisible(false);
	    	HikawaController.TopDisplay();
	    }
	    
	    //リセットボタンが押された時の処理
	    if (cmd.equals("reset")){
	    	StaffIDText.setText("");
	    	PassField.setText("");
	    }
	 }
}

