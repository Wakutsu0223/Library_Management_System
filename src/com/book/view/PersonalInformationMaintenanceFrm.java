package com.book.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.book.dao.UserDao;
import com.book.model.Book;
import com.book.model.User;
import com.book.util.DbUtil;
import com.book.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PersonalInformationMaintenanceFrm extends JInternalFrame {
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
					PersonalInformationMaintenanceFrm frame = new PersonalInformationMaintenanceFrm();
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
	public PersonalInformationMaintenanceFrm() {
		setTitle("个人信息维护");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 571, 341);
		
		JLabel lblNewLabel = new JLabel("I D:");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setEditable(false);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("姓名：");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("性  别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_4 = new JLabel("年级：");
		
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
			public void actionPerformed(ActionEvent e) {
				personalInformationMaintenanceActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PersonalInformationMaintenanceFrm.class.getResource("/images/m_m_modify.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentIdTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nameTxt)
								.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(classTxt)))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userNameTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(manJrb)
								.addGap(18)
								.addComponent(femaleJrb))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_5)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		this.upDate();
	}

	/**
	 * 修改事件处理
	 * @param e
	 */
	private void personalInformationMaintenanceActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		//String id = this.idTxt.getText();
		String name = this.nameTxt.getText();
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		String sex = "";
		if(manJrb.isSelected()) {
			sex = "男";
		}else if(femaleJrb.isSelected()) {
			sex = "女";
		}
		String classTxt = this.classTxt.getText();
		String college = this.collegeTxt.getText();
		String studentId = this.studentIdTxt.getText();
		
		int id = new UserDao().id_cc;
		
		User user = new User(id, name, sex, classTxt, college, studentId);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = userDao.update(con, user);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "个人信息修改成功！");
				this.upDate();
			}else {
				JOptionPane.showMessageDialog(null, "个人信息修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "个人信息修改失败！");
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
	 * 更新个人信息
	 */
	public void upDate() {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userDao.list(con);
			while(rs.next()) {
				this.idTxt.setText(Integer.toString(rs.getInt("id")));
				this.userNameTxt.setText(rs.getString("userName"));
				this.nameTxt.setText(rs.getString("name"));
				String sex = rs.getString("sex");
				if("男".equals(sex)) {
					this.manJrb.setSelected(true);
				}else if("女".equals(sex)) {
					this.femaleJrb.setSelected(true);
				}
				this.classTxt.setText(rs.getString("class"));
				this.collegeTxt.setText(rs.getString("college"));
				this.studentIdTxt.setText(rs.getString("studentID"));
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
