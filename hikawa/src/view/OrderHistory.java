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

public class OrderHistory extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public OrderHistory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 92, 477, 212);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null },
				},
				new String[] {
						"\u767A\u6CE8\u65E5", "\u767A\u6CE8\u30B3\u30FC\u30C9", "\u5546\u54C1\u30B3\u30FC\u30C9",
						"\u767A\u6CE8\u5546\u54C1", "\u500B\u6570", "\u7D0D\u54C1\u4E88\u5B9A\u65E5", ""
				}) {
			Class[] columnTypes = new Class[] {
					String.class, Integer.class, Integer.class, String.class, Object.class, Object.class, Object.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("発注履歴画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(249, 44, 124, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnOrder = new JButton("発注表");
		btnOrder.setBounds(545, 22, 82, 26);
		btnOrder.setActionCommand("btnOrder");
		btnOrder.addActionListener(this);
		contentPane.add(btnOrder);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//発注表ボタンを押した際の処理
		if (cmd.equals("btnOrder")) {
			setVisible(false);
			HikawaController.OrderTableDisplay();
		}
	}

}
