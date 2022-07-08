package com.book.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.book.dao.BorrowDao;
import com.book.dao.UserDao;
import com.book.model.Book;
import com.book.model.Borrow;
import com.book.util.DbUtil;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class BorrowingRecordsFrm extends JInternalFrame {
	private JTable bookTable;
	
	private DbUtil dbUtil = new DbUtil();
	private BorrowDao borrowDao = new BorrowDao();
	
	private JLabel notReturnedTxt;
	private JLabel borrowNumberTxt;
	private JLabel returnTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowingRecordsFrm frame = new BorrowingRecordsFrm();
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
	public BorrowingRecordsFrm() {
		setTitle("个人借阅记录");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 551, 478);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("您一共借阅了");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 28));
		
		borrowNumberTxt = new JLabel("0");
		borrowNumberTxt.setFont(new Font("宋体", Font.BOLD, 34));
		borrowNumberTxt.setForeground(Color.MAGENTA);
		
		JLabel lblNewLabel_1 = new JLabel("本书。");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 28));
		
		JLabel lblNewLabel_2 = new JLabel("其中");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 28));
		
		notReturnedTxt = new JLabel("0");
		notReturnedTxt.setFont(new Font("宋体", Font.BOLD, 34));
		notReturnedTxt.setForeground(Color.RED);
		
		JLabel lblNewLabel_4 = new JLabel("本未还，");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 28));
		
		returnTxt = new JLabel("0");
		returnTxt.setFont(new Font("宋体", Font.BOLD, 34));
		returnTxt.setForeground(Color.PINK);
		
		JLabel lblNewLabel_6 = new JLabel("本已还。");
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 28));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(borrowNumberTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(notReturnedTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(returnTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(borrowNumberTxt)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(notReturnedTxt)
						.addComponent(lblNewLabel_4)
						.addComponent(returnTxt)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		bookTable = new JTable();
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u56FE\u4E66\u540D\u79F0", "\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(127);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(184);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(98);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable();
	}
	
	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成零行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int countNotReturn = 0;
			int countReturn = 0;
			String borrow = "";
			ResultSet rs = borrowDao.list(con);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("userName"));
				v.add(rs.getString("bookName"));
				borrow = rs.getString("borrow");
				if("未还".equals(borrow)) {
					countNotReturn++;
				}else if("已还".equals(borrow)) {
					countReturn++;
				}
				v.add(borrow);
				dtm.addRow(v);
			}
			borrowNumberTxt.setText(Integer.toString(this.bookTable.getRowCount()));
			notReturnedTxt.setText(Integer.toString(countNotReturn));
			returnTxt.setText(Integer.toString(countReturn));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
