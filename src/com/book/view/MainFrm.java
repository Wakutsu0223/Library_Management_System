package com.book.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 658);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本信息维护");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("图书类别管理");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_bookTypeManager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书类别添加");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookTypeAddInterFrm  bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_add.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("图书类别维护");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookTypeManageInterFrm  bookTypeManageInterFrm = new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_modify.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("图书管理");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_bookManager.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("图书添加");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_add.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("图书维护");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				BookManageInterFrm  bookManageInterFrm = new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_modify.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("安全退出");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_exit.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("记录查看");
		mnNewMenu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_search.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("图书借阅记录");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				AllBookBorrowingRecordFrm allBookBorrowingRecordFrm = new AllBookBorrowingRecordFrm();
				allBookBorrowingRecordFrm.setVisible(true);
				table.add(allBookBorrowingRecordFrm);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_password.png")));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_5 = new JMenu("用户管理");
		mnNewMenu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_userName.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("新用户审核");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				NewUserReviewFrm newUserReviewFrm = new NewUserReviewFrm();
				newUserReviewFrm.setVisible(true);
				table.add(newUserReviewFrm);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_bookManager.png")));
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("用户信息维护");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				UserInformationMaintenanceFrm userInformationMaintenanceFrm = new UserInformationMaintenanceFrm();
				userInformationMaintenanceFrm.setVisible(true);
				table.add(userInformationMaintenanceFrm);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_modify.png")));
		mnNewMenu_5.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_1 = new JMenu("关于我");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_about.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("关于图书管理系统");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				bookInterFrm  BookInterFrm = new bookInterFrm();
				BookInterFrm.setVisible(true);
				table.add(BookInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/m_m_me.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		table = new JDesktopPane();
		contentPane.add(table);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(MainFrm.class.getResource("/images/library.png")));
		background.setBounds(0, -87, 1920, 1080);
		table.add(background);
		
		//设置JFrame最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
