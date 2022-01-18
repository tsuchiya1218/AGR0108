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

public class Waste extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waste frame = new Waste();
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
	public Waste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("廃棄一覧表画面");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(175, 53, 144, 26);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 98, 434, 168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u756A\u53F7", "\u5546\u54C1\u540D", "\u500B\u6570", "\u5546\u54C1\u671F\u9650", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("商品表");
		btnNewButton.setBounds(351, 14, 75, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("トップ");
		btnNewButton_1.setBounds(439, 14, 74, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("廃棄商品追加");
		btnNewButton_2.setBounds(50, 288, 111, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("廃棄完了");
		btnNewButton_3.setBounds(174, 288, 98, 26);
		contentPane.add(btnNewButton_3);
	}

}
