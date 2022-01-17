package view;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ProductTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductTable frame = new ProductTable();
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
	public ProductTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hikawaシステム");
		lblNewLabel.setBounds(12, 12, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商品表画面");
		lblNewLabel_1.setBounds(404, 39, 67, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("商品名：");
		lblNewLabel_2.setBounds(33, 72, 55, 16);
		contentPane.add(lblNewLabel_2);
		
		TextField textField = new TextField();
		textField.setBounds(87, 70, 120, 23);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("検索");
		btnNewButton.setBounds(213, 67, 63, 26);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 109, 811, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				
			},
			new String[] {
				"\u5546\u54C1\u30B3\u30FC\u30C9", "\u5546\u54C1\u540D", "\u30AB\u30C6\u30B4\u30EA\u30FC", "\u5024\u6BB5", "\u30E1\u30FC\u30AB\u30FC\u540D", "\u5728\u5EAB\u91CF", "\u98DF\u54C1\u671F\u9650", "\u767A\u6CE8\u72B6\u6CC1", "\u767A\u6CE8"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("発注表");
		btnNewButton_1.setBounds(69, 343, 91, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("廃棄");
		btnNewButton_2.setBounds(669, 54, 63, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("トップ");
		btnNewButton_3.setBounds(755, 54, 77, 26);
		contentPane.add(btnNewButton_3);
	}
}
