package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class OrderTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderTable frame = new OrderTable();
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
	public OrderTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("発注表画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(191, 51, 108, 26);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 112, 348, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u30B3\u30FC\u30C9", "\u5546\u54C1\u540D", "\u500B\u6570", ""
			}
		) {
			
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class,Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("発注履歴");
		btnNewButton.setBounds(294, 11, 85, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("トップ");
		btnNewButton_1.setBounds(390, 11, 75, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("発注");
		btnNewButton_2.setBounds(87, 224, 76, 26);
		contentPane.add(btnNewButton_2);
	}
}
