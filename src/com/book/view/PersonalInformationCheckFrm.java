package com.book.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.book.dao.UserDao;
import com.book.util.DbUtil;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import java.awt.Color;

public class PersonalInformationCheckFrm extends JInternalFrame {
	private JTextField idTxt;
	private JTextField userNameTxt;
	private JTextField nameTxt;
	private JTextField sexTxt;
	private JTextField classTxt;
	private JTextField collegeTxt;
	private JTextField studentIdTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInformationCheckFrm frame = new PersonalInformationCheckFrm();
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
	public PersonalInformationCheckFrm() {
		getContentPane().setForeground(Color.WHITE);
		setTitle("个人信息查看");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 570, 347);
		
		JLabel lblNewLabel = new JLabel("I D：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setEditable(false);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("姓名：");
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("性  别：");
		
		sexTxt = new JTextField();
		sexTxt.setEditable(false);
		sexTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("年级：");
		
		classTxt = new JTextField();
		classTxt.setEditable(false);
		classTxt.setColumns(10);
		
		JLabel label = new JLabel("学  院：");
		
		collegeTxt = new JTextField();
		collegeTxt.setEditable(false);
		collegeTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("学号：");
		
		studentIdTxt = new JTextField();
		studentIdTxt.setEditable(false);
		studentIdTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("我的信息");
		lblNewLabel_6.setFont(new Font("华文彩云", Font.BOLD, 30));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(PersonalInformationCheckFrm.class.getResource("/images/avatar.jpg")));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(PersonalInformationCheckFrm.class.getResource("/images/IvyLeague.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(idTxt)
								.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(studentIdTxt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
								.addComponent(classTxt, 121, 121, 121))))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_3)
							.addComponent(label)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(collegeTxt, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addComponent(userNameTxt)
							.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(sexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_7))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel_6)))
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addGap(26))
		);
		getContentPane().setLayout(groupLayout);

		this.upDate();
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
				this.sexTxt.setText(rs.getString("sex"));
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
