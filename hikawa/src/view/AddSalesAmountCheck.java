package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.HikawaController;
import dao.AddSalesAmountDBAccess;

public class AddSalesAmountCheck extends JFrame implements ActionListener {

	private JPanel contentPane;

	static String date = AddSalesAmount.getDate();

	static int amount = AddSalesAmount.getAmount();
	Integer i = Integer.valueOf(amount);
	String samount = i.toString();

	/**
	 * Create the frame.
	 */
	public AddSalesAmountCheck() {
		setVisible(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("売上入力確認画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(53, 53, 165, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("日付：");
		lblNewLabel_2.setBounds(45, 110, 37, 17);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(date);
		lblNewLabel_3.setBounds(92, 111, 118, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("売上：");
		lblNewLabel_4.setBounds(45, 139, 37, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel((samount));
		lblNewLabel_5.setBounds(92, 139, 91, 16);
		contentPane.add(lblNewLabel_5);

		JButton btnConfirm = new JButton("確定");
		btnConfirm.setBounds(47, 190, 62, 26);
		btnConfirm.setActionCommand("btnConfirm");
		btnConfirm.addActionListener(this);
		contentPane.add(btnConfirm);

		JButton btnRe = new JButton("再入力");
		btnRe.setBounds(146, 190, 80, 26);
		btnRe.setActionCommand("btnRe");
		btnRe.addActionListener(this);
		contentPane.add(btnRe);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//String date = AddSalesAmount.getDate();
		//Integer amount = Integer.parseInt(getAmount());

		AddSalesAmountDBAccess asad = null;
		//確定ボタンを押した際の処理
		if (cmd.equals("btnConfirm")) {
			//DB追加処理書く

			//date = dateFeild.getText();
			//amount = Integer.parseInt(amountFeild.getText());

			try {				
				asad = new AddSalesAmountDBAccess(date, amount);
				asad.addSalesAmount();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(contentPane, "追加完了しました");
			HikawaController.SalesDisplay();

		}

		//再入力ボタンを押した際の処理
		if (cmd.equals("btnRe")) {
			setVisible(false);
			HikawaController.AddSaleDisplay();
		}
	}
}
