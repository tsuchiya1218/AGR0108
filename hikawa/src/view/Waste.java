package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import action.CreateTableData;
import control.HikawaController;
import dao.WasteDBAccess;

public class Waste extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField cancelField;

	/**
	 * Create the frame.
	 */
	public Waste() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 391);
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

		String[] columnNames = { "	商品番号", "商品名", "個数", "商品期限" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		try {
			WasteDBAccess ptd = new WasteDBAccess();

			//列の入れ替えを禁止
			table.getTableHeader().setReorderingAllowed(false);

			String[][] tabledata = CreateTableData.WasteTableToArray(ptd.getWasteTable());
			if (tabledata != null) {
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

		JButton btnProduct = new JButton("商品表");
		btnProduct.setBounds(351, 14, 75, 26);
		btnProduct.setActionCommand("btnProduct");
		btnProduct.addActionListener(this);
		contentPane.add(btnProduct);

		JButton btnTop = new JButton("トップ");
		btnTop.setBounds(439, 14, 74, 26);
		btnTop.setActionCommand("btnTop");
		btnTop.addActionListener(this);
		contentPane.add(btnTop);

		JButton btnWasteConfirm = new JButton("廃棄完了");
		btnWasteConfirm.setBounds(51, 318, 98, 26);
		btnWasteConfirm.setActionCommand("btnWasteConfirm");
		btnWasteConfirm.addActionListener(this);
		contentPane.add(btnWasteConfirm);

		JLabel lblNewLabel_2 = new JLabel("廃棄解除：");
		lblNewLabel_2.setBounds(51, 279, 68, 13);
		contentPane.add(lblNewLabel_2);

		cancelField = new JTextField();
		cancelField.setBounds(120, 276, 96, 19);
		contentPane.add(cancelField);
		cancelField.setColumns(10);

		JButton btncancel = new JButton("解除");
		btncancel.setActionCommand("btncancel");
		btncancel.addActionListener(this);
		btncancel.setBounds(220, 275, 62, 21);
		contentPane.add(btncancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		//トップボタンが押された時の処理
		if (cmd.equals("btnTop")) {
			setVisible(false);
			HikawaController.TopDisplay();
		}

		//商品表ボタンを押した際の処理
		if (cmd.equals("btnProduct")) {
			setVisible(false);
			HikawaController.ProductTableDisplay();
		}

		//廃棄完了ボタンを押した際の処理
		if (cmd.equals("btnWasteConfirm")) {

			try {
				WasteDBAccess.Deletewaste();
				JOptionPane.showMessageDialog(contentPane, "廃棄完了しました");
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}

			try {//再表示
				tableModel.setRowCount(0);
				WasteDBAccess wda = new WasteDBAccess();
				String[][] tabledata = CreateTableData.WasteTableToArray(wda.getWasteTable());
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		//解除ボタンが押された時の処理
		if (cmd.equals("btncancel")) {

			try {
				String pCode = cancelField.getText();

				if(!(pCode.equals(""))) {
					WasteDBAccess wad = new WasteDBAccess(pCode);
					wad.cancelwaste();
					JOptionPane.showMessageDialog(contentPane, "解除しました");
				}else {

					JOptionPane.showMessageDialog(contentPane, "商品コードを入力してください");

				}



			} catch (Exception e2) {
				// TODO 自動生成された catch ブロック
				e2.printStackTrace();
			}

			try {//再表示
				tableModel.setRowCount(0);
				WasteDBAccess wda = new WasteDBAccess();
				String[][] tabledata = CreateTableData.WasteTableToArray(wda.getWasteTable());
				for (String[] data : tabledata) {
					tableModel.addRow(data);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
