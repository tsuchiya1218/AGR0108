package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.HikawaController;

public class ProductSalesQuantity extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ProductSalesQuantity() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("売上数量入力画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(73, 54, 165, 26);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 92, 226, 142);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null },
				},
				new String[] {
						"\u5546\u54C1\u540D", "\u58F2\u4E0A\u6570\u91CF"
				}));
		scrollPane.setViewportView(table);

		JButton btnConfirm = new JButton("確定");
		btnConfirm.setBounds(69, 255, 69, 26);
		btnConfirm.setActionCommand("btnConfirm");
		btnConfirm.addActionListener(this);
		contentPane.add(btnConfirm);

		JButton btnProductSelectionSales = new JButton("売上商品選択");
		btnProductSelectionSales.setBounds(195, 16, 108, 26);
		btnProductSelectionSales.setActionCommand("btnProductSelectionSales");
		btnProductSelectionSales.addActionListener(this);
		contentPane.add(btnProductSelectionSales);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//売上商品選択ボタンを押した際の処理
		if (cmd.equals("btnProductSelectionSales")) {
			setVisible(false);
			HikawaController.ProductSelectionSalesDisplay();
		}

		//確定ボタンを押した際の処理
		if (cmd.equals("btnConfirm")) {
			
			//確定ボタンを押した際の処理を追加する
			
			
			setVisible(false);
			HikawaController.SalesDisplay();
		}
	}

}
