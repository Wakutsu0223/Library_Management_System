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

import com.book.dao.BookTypeDao;
import com.book.dao.RegisterDao;
import com.book.model.Book;
import com.book.model.BookType;
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

public class NewUserReviewFrm extends JInternalFrame {
	private JTextField userNameTxt;
	private JTextField nameTxt;
	private JTextField sexTxt;
	private JTextField classTxt;
	private JTextField collegeTxt;
	private JTextField studentIdTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private RegisterDao registerDao = new RegisterDao();
	private JTable bookTable;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserReviewFrm frame = new NewUserReviewFrm();
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
	public NewUserReviewFrm() {
		setTitle("用户审核");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 936, 566);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5BA1\u6838\u8868\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
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
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u7EA7", "\u5B66\u9662", "\u5B66\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(51);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(108);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(118);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(57);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(138);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(131);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(122);
		scrollPane.setViewportView(bookTable);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setEditable(false);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		
		sexTxt = new JTextField();
		sexTxt.setEditable(false);
		sexTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("年级：");
		
		classTxt = new JTextField();
		classTxt.setEditable(false);
		classTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("学  院：");
		
		collegeTxt = new JTextField();
		collegeTxt.setEditable(false);
		collegeTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("学号：");
		
		studentIdTxt = new JTextField();
		studentIdTxt.setEditable(false);
		studentIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("通过");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				examinationPassedActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(NewUserReviewFrm.class.getResource("/images/m_m_add.png")));
		
		JButton btnNewButton_1 = new JButton("驳回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrationRefusalActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(NewUserReviewFrm.class.getResource("/images/m_m_delete.png")));
		
		JLabel lblNewLabel_6 = new JLabel("编号：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(classTxt)
							.addGap(41)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(collegeTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
						.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(nameTxt)
						.addComponent(studentIdTxt, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(35))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(62)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_6)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		this.fillTable();
	}
	
	/**
	 * 审核通过事件处理
	 * @param evt
	 */
	private void examinationPassedActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = this.idTxt.getText();
		String userName = this.userNameTxt.getText();
		
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "请选择要通过的申请！");
			return;
		}
		
		String name = this.nameTxt.getText();
		String sex = this.sexTxt.getText();
		String classTxt = this.classTxt.getText();
		String college = this.collegeTxt.getText();
		String studentId = this.studentIdTxt.getText();
		String password = "";
		
		Connection conTool = null;
		try {
			conTool = dbUtil.getCon();
			User userTool = new User(Integer.parseInt(id));
			ResultSet rs = registerDao.list(conTool, userTool);
			while(rs.next()) {
				password = rs.getString("password");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(conTool);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		User user = new User(userName, password, name, sex, classTxt, college, studentId);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = registerDao.pass(con, user);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "审核通过成功！");
				registerDao.delete(con, id);
				fillTable();
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "审核通过失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "审核通过失败！");
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
	 * 审核驳回事件处理
	 * @param evt
	 */
	private void registrationRefusalActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要驳回的申请！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要驳回该申请吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = registerDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "驳回成功！");
					this.resetValue();
					this.fillTable();
				}else {
					JOptionPane.showMessageDialog(null, "驳回失败！");
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
	 * 表格行点击事件处理
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.userNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.nameTxt.setText((String)bookTable.getValueAt(row, 2));
		this.sexTxt.setText((String)bookTable.getValueAt(row, 3));
		this.classTxt.setText((String)bookTable.getValueAt(row, 4));
		this.collegeTxt.setText((String)bookTable.getValueAt(row, 5));
		this.studentIdTxt.setText((String)this.bookTable.getValueAt(row, 6));
	}

	/**
	 * 初始化表格数据
	 */
	private void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成零行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = registerDao.list(con, new User());
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("userName"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("class"));
				v.add(rs.getString("college"));
				v.add(rs.getString("StudentID"));
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
		this.userNameTxt.setText("");
		this.nameTxt.setText("");
		this.sexTxt.setText("");
		this.classTxt.setText("");
		this.collegeTxt.setText("");
		this.studentIdTxt.setText("");
	}
}
