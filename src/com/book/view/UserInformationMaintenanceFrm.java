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

import com.book.dao.UserDao;
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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInformationMaintenanceFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField idTxt;
	private JTextField userNameTxt;
	private JTextField nameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField classTxt;
	private JTextField collegeTxt;
	private JTextField studentIdTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformationMaintenanceFrm frame = new UserInformationMaintenanceFrm();
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
	public UserInformationMaintenanceFrm() {
		setTitle("用户信息维护");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 861, 643);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u8868\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("I D：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setEditable(false);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("姓  名：");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_4 = new JLabel("年  级：");
		
		classTxt = new JTextField();
		classTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("学  院：");
		
		collegeTxt = new JTextField();
		collegeTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("学号：");
		
		studentIdTxt = new JTextField();
		studentIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userInformationModificationActionPerformed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserInformationMaintenanceFrm.class.getResource("/images/m_m_modify.png")));
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userInformationDeletionActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UserInformationMaintenanceFrm.class.getResource("/images/m_m_delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentIdTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(femaleJrb)))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(classTxt)))
							.addGap(67)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(collegeTxt)))
							.addContainerGap(58, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(140)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(116))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(manJrb)
						.addComponent(lblNewLabel_4)
						.addComponent(femaleJrb)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
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
				"ID", "\u7528\u6237\u540D", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u7EA7", "\u5B66\u9662", "\u5B66\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(61);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(146);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(152);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(107);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(95);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(109);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable();
	}
	
	/**
	 * 删除事件处理
	 * @param evt
	 */
	private void userInformationDeletionActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的用户！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该用户吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				boolean flag = userDao.existUserById(con, id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "当前用户正在借阅，不能删除该用户！");
					return;
				}
				int deleteNum = userDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable();
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
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
	 * 修改事件处理
	 * @param evt
	 */
	private void userInformationModificationActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的用户！");
			return;
		}
		String userName = this.userNameTxt.getText();
		String name = this.nameTxt.getText();
		String classTxt = this.classTxt.getText();
		String college = this.collegeTxt.getText();
		String studentId = this.studentIdTxt.getText();
		
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		
		String sex = "";
		if(manJrb.isSelected()) {
			sex = "男";
		}else if(femaleJrb.isSelected()) {
			sex = "女";
		}
		
		User user = new User(Integer.parseInt(id), name, sex, classTxt, college, studentId);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = userDao.update(con, user);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "用户信息修改成功！");
				resetValue();
				this.fillTable();
			}else {
				JOptionPane.showMessageDialog(null, "用户信息修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户信息修改失败！");
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
	 * 表格行点击事件处理
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.userNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.nameTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex = (String)bookTable.getValueAt(row, 3);
		if("男".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if("女".equals(sex)) {
			this.femaleJrb.setSelected(true);
		}
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
			ResultSet rs = userDao.listAll(con);
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
		this.idTxt.setText("");
		this.userNameTxt.setText("");
		this.nameTxt.setText("");
		this.classTxt.setText("");
		this.collegeTxt.setText("");
		this.studentIdTxt.setText("");
	}
}
