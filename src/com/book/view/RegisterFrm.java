package com.book.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.dao.BookTypeDao;
import com.book.dao.RegisterDao;
import com.book.dao.UserDao;
import com.book.model.User;
import com.book.util.DbUtil;
import com.book.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField nameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField classTxt;
	private JTextField collegeTxt;
	private JTextField studentIdTxt;
	private JTextField verificationCodeTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao(); 
	private RegisterDao registerDao = new RegisterDao();
	
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JPasswordField passwordTxt;
	private JPasswordField againPasswordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
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
	public RegisterFrm() {
		setResizable(false);
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("注册");
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD, 23));
		lblNewLabel.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/m_logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("*用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("*密  码：");
		
		JLabel lblNewLabel_3 = new JLabel("*再次输入密码：");
		
		JLabel lblNewLabel_4 = new JLabel("姓  名：");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("性  别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_6 = new JLabel("班  级：");
		
		classTxt = new JTextField();
		classTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("学  院：");
		
		collegeTxt = new JTextField();
		collegeTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("学  号：");
		
		studentIdTxt = new JTextField();
		studentIdTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("验证码：");
		
		verificationCodeTxt = new JTextField();
		verificationCodeTxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/VerificationCode.jpg")));
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/m_m_add.png")));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/m_m_reset.png")));
		
		passwordTxt = new JPasswordField();
		
		againPasswordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(userNameTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_9)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(collegeTxt)
								.addComponent(classTxt)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(manJrb)
									.addGap(18)
									.addComponent(femaleJrb))
								.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(studentIdTxt)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton_1)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(verificationCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel_10)))
								.addComponent(againPasswordTxt))))
					.addGap(154))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(againPasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(collegeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(studentIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(verificationCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9))))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		
		//居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.againPasswordTxt.setText("");
		this.nameTxt.setText("");	
		this.classTxt.setText("");
		this.collegeTxt.setText("");
		this.studentIdTxt.setText("");
		this.verificationCodeTxt.setText("");
	}

	/**
	 * 注册事件处理
	 * @param e
	 */
	private void userActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		String againPassword = new String(this.againPasswordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(this.sameName(userName)) {
			JOptionPane.showMessageDialog(null, "用户名已被使用，请重新输入用户名！");
			this.userNameTxt.setText("");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		boolean flag = againPassword.equals(password);
		if(!flag) {
			JOptionPane.showMessageDialog(null, "两次密码不相同！");
			this.passwordTxt.setText("");
			this.againPasswordTxt.setText("");
			return;
		}
		String name = this.nameTxt.getText();
		
		String sex = "";
		if(manJrb.isSelected()) {
			sex = "男";
		}else if(femaleJrb.isSelected()) {
			sex = "女";
		}
		
		String classTxt = this.classTxt.getText();
		String college = this.collegeTxt.getText();
		String studentId = this.studentIdTxt.getText();
		String verificationCode = this.verificationCodeTxt.getText();
		
		if("5739".equals(verificationCode)) {
			
			User user = new User(userName, password, name, sex, classTxt, college, studentId);
			
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int addNum = registerDao.add(con, user);
				if(addNum == 1) {
					JOptionPane.showMessageDialog(null, "注册成功，请等待管理员审核同意！");
					dispose();
					new LogOnFrm().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "注册失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "验证码输入错误！");
			this.verificationCodeTxt.setText("");
			return;
		}
	}
	
	/**
	 * 判断用户名是否有重复
	 * @param userName
	 * @return
	 */
	public boolean sameName(String userName) {
		boolean flag = false;
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rsRegister = registerDao.list(con, new User());
			while(rsRegister.next()) {
				String userNameTool = rsRegister.getString("userName");
				if(userName.equals(userNameTool)) {
					flag = true;
					}
				}
			ResultSet rsUser = userDao.listAll(con);
			while(rsUser.next()) {
				String userNameTool = rsUser.getString("userName");
				if(userName.equals(userNameTool)) {
					flag = true;
					}
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
		return flag;
	}
}
