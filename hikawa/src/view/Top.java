package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Top extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Top frame = new Top();
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
	public Top() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("トップ画面");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(63, 38, 110, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("商品表");
		btnNewButton.setBounds(77, 78, 88, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("発注表");
		btnNewButton_1.setBounds(77, 114, 90, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("売上");
		btnNewButton_2.setBounds(80, 151, 84, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("廃棄一覧表");
		btnNewButton_3.setBounds(73, 188, 98, 26);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ログアウト");
		btnNewButton_4.setBounds(74, 226, 98, 26);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("hikawaシステム");
		lblNewLabel_1.setBounds(6, 10, 96, 16);
		contentPane.add(lblNewLabel_1);
	}

}
