package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.HikawaController;

public class Top extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Top() {
		setVisible(true);
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

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(77, 78, 88, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(77, 114, 90, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);

		JButton btnSales = new JButton("売上");
		btnSales.setBounds(80, 151, 84, 26);
		btnSales.setActionCommand("btnSales");
		btnSales.addActionListener(this);
		contentPane.add(btnSales);

		JButton btnWaste = new JButton("廃棄一覧表");
		btnWaste.setBounds(73, 188, 98, 26);
		btnWaste.setActionCommand("btnWaste");
		btnWaste.addActionListener(this);
		contentPane.add(btnWaste);

		JButton btnLogout = new JButton("ログアウト");
		btnLogout.setBounds(74, 226, 98, 26);
		btnLogout.setActionCommand("btnLogout");
		btnLogout.addActionListener(this);
		contentPane.add(btnLogout);

		JLabel lblNewLabel_1 = new JLabel("hikawaシステム");
		lblNewLabel_1.setBounds(6, 10, 96, 16);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}

		//発注表ボタンを押した際の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}

		//売上ボタンを押した際の処理
		if (cmd.equals("btnSales")) {
			setVisible(false);
			HikawaController.SalesDisplay();
		}

		//廃棄一覧表ボタンを押した際の処理
		if (cmd.equals("btnWaste")) {
			setVisible(false);
			HikawaController.WasteDisplay();
		}

		//ログアウトボタンを押した際の処理
		if (cmd.equals("btnLogout")) {
			setVisible(false);
			HikawaController.LoginDisplay();
		}

	}

}
