package view;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Login extends JFrame {
	public static void main(String args[]) {
	    Login frame = new Login("Login");
	    frame.setVisible(true);
	}
	
	Login(String title){
	    setTitle(title);
	    setSize(600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel p = new JPanel();
	    
	    JLabel label1 = new JLabel("従業員番号：");
	    JLabel label2 = new JLabel("パスワード");
	    
	    JTextField EPYcodetxt = new JTextField();
	    JTextField Passtxt = new JTextField();
	    
	    p.add(label1);
	    p.add(EPYcodetxt);
	    p.add(label2);
	    p.add(Passtxt);
	    
	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	}
	
	
}
