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

import com.book.dao.BookDao;
import com.book.dao.BookReturnDao;
import com.book.dao.BookTypeDao;
import com.book.dao.BorrowDao;
import com.book.dao.UserDao;
import com.book.model.Book;
import com.book.model.Borrow;
import com.book.model.User;
import com.book.util.DbUtil;
import com.book.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookReturnFrm extends JInternalFrame {
	private JTextField bookIdTxt;
	private JTextField bookNameTxt;
	private JTextField userNameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BorrowDao borrowDao = new BorrowDao();
	private BookDao bookDao = new BookDao();
	private UserDao  userDao = new UserDao();
	private BookReturnDao bookReturnDao = new BookReturnDao();
	private JTextField idTxt;
	private JTable bookTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReturnFrm frame = new BookReturnFrm();
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
	public BookReturnFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("归还图书");
		setBounds(100, 100, 730, 541);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5F52\u8FD8\u680F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				bookTableMousePressed(me);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u501F\u9605\u4EBA", "\u501F\u9605\u8BB0\u5F55\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(202);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(108);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(112);
		scrollPane.setViewportView(bookTable);
		
		JLabel lblNewLabel = new JLabel("图书编号：");
		
		bookIdTxt = new JTextField();
		bookIdTxt.setEditable(false);
		bookIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书名称：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setEditable(false);
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("借 阅 人：");
		
		userNameTxt = new JTextField();
		userNameTxt.setEditable(false);
		userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("归还");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookReturnActionPerdormed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookReturnFrm.class.getResource("/images/m_m_login.png")));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookIdTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(96)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Borrow(userDao.id_cc));

	}
	
	/**
	 * 表格点击事件处理
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.bookTable.getSelectedRow();
		this.bookIdTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.userNameTxt.setText((String)bookTable.getValueAt(row, 2));
		this.idTxt.setText((String)bookTable.getValueAt(row, 3));
	}

	/**
	 * 图书归还事件处理
	 * @param evt
	 */
	private void bookReturnActionPerdormed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		int bookId = Integer.parseInt(bookIdTxt.getText());
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要归还的图书！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要归还该图书吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = borrowDao.delete(con, id);
				int inStock = 0;
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "归还成功！");
					Book bookTool = new Book(bookId);
					ResultSet rs = bookDao.inStocklist(con, bookTool);
					while(rs.next()) {
						inStock = rs.getInt("inStock");
					}
					Borrow borrow = new Borrow(Integer.parseInt(id), "已还");
					borrowDao.update(con, borrow);
					bookDao.inStockUpdate(con, bookTool, inStock, true);
					this.resetValue();
					this.fillTable(new Borrow(userDao.id_cc));
				}else {
					JOptionPane.showMessageDialog(null, "归还失败！");
				}
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

	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Borrow borrow) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成零行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookReturnDao.list(con, borrow);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("bookId"));
				v.add(rs.getString("bookName"));
				v.add(userDao.userName_cc);
				v.add(rs.getString("id"));
				dtm.addRow(v);
			}
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
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookIdTxt.setText("");
		this.bookNameTxt.setText("");
		this.userNameTxt.setText("");
		this.idTxt.setText("");
	}
}
