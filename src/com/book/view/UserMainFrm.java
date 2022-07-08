package com.book.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserMainFrm extends JFrame {

	private JPanel contentPane;
	private JLabel background;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrm frame = new UserMainFrm();
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
	public UserMainFrm() {
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 677);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("书库");
		mnNewMenu.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_bookManager.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("借阅");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookBorrowFrm  bookBorrowFrm = new BookBorrowFrm();
				bookBorrowFrm.setVisible(true);
				table.add(bookBorrowFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_bookTypeManager.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("归还");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookReturnFrm  bookReturnFrm = new BookReturnFrm();
				bookReturnFrm.setVisible(true);
				table.add(bookReturnFrm);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_login.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("我的");
		mnNewMenu_1.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_me.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_4 = new JMenu("个人信息");
		mnNewMenu_4.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_userName.png")));
		mnNewMenu_1.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("查看");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				PersonalInformationCheckFrm  personalInformationCheckFrm = new PersonalInformationCheckFrm();
				personalInformationCheckFrm.setVisible(true);
				table.add(personalInformationCheckFrm);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_search.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("维护");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				PersonalInformationMaintenanceFrm  personalInformationMaintenanceFrm = new PersonalInformationMaintenanceFrm();
				personalInformationMaintenanceFrm.setVisible(true);
				table.add(personalInformationMaintenanceFrm);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_modify.png")));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("借阅记录");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BorrowingRecordsFrm  borrowingRecordsFrm = new BorrowingRecordsFrm();
				borrowingRecordsFrm.setVisible(true);
				table.add(borrowingRecordsFrm);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_reset.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("其他");
		mnNewMenu_3.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_modify.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("安全退出");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_exit.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("关于我");
		mnNewMenu_2.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_about.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("关于图书管理系统");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				bookInterFrm  BookInterFrm = new bookInterFrm();
				BookInterFrm.setVisible(true);
				table.add(BookInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/m_m_password.png")));
		mnNewMenu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
		);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/library.png")));
		background.setBounds(0, -92, 1920, 1080);
		table.add(background);
		contentPane.setLayout(gl_contentPane);
	}
}
