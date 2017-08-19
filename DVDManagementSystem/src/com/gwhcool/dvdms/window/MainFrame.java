package com.gwhcool.dvdms.window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainFrame {

	private JFrame mainFrame;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		mainFrame.setTitle(
				"\u4E3B\u754C\u9762                                                                             DVD\u7BA1\u7406\u7CFB\u7EDF");
		mainFrame.setBounds(300, 500, 852, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBounds(10, 84, 826, 477);
		mainFrame.getContentPane().add(contentPanel);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPanel.setLayout(cardLayout);

		JPanel dvdPanel = new JPanel();
		dvdPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.add(dvdPanel, "name_dvdPanel");
		dvdPanel.setLayout(null);

		JPanel dvdMenuPanel = new JPanel();
		dvdMenuPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdMenuPanel.setBounds(10, 0, 806, 44);
		dvdPanel.add(dvdMenuPanel);
		dvdMenuPanel.setLayout(new GridLayout(0, 5, 0, 0));

		JButton lookDVDButton = new JButton("\u67E5\u770BDVD");
		JButton lendDVDButton = new JButton("\u501F\u51FADVD");
		JButton returnDVDButton = new JButton("\u5F52\u8FD8DVD");
		JButton addDVDButton = new JButton("\u65B0\u589EDVD");
		JButton deleteDVDButton = new JButton("\u5220\u9664DVD");

		JPanel dvdContentPanel = new JPanel();
		dvdContentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.setBounds(0, 54, 826, 423);
		dvdPanel.add(dvdContentPanel);
		CardLayout dvdCardLayout=new CardLayout(0, 0);
		dvdContentPanel.setLayout(dvdCardLayout);

		JPanel lookDVDPanel = new JPanel();
		lookDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(lookDVDPanel, "name_lookDVDPanel");
		
		JLabel label = new JLabel("11111");
		lookDVDPanel.add(label);

		JPanel lendDVDPanel = new JPanel();
		lendDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(lendDVDPanel, "name_lendDVDPanel");
		
		JLabel label_1 = new JLabel("22222");
		lendDVDPanel.add(label_1);

		JPanel returnDVDPanel = new JPanel();
		returnDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(returnDVDPanel, "name_returnDVDPanel");
		
		JLabel label_2 = new JLabel("33333");
		returnDVDPanel.add(label_2);

		JPanel addDVDPanel = new JPanel();
		addDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(addDVDPanel, "name_addDVDPanel");
		
		JLabel lblNewLabel = new JLabel("44444");
		addDVDPanel.add(lblNewLabel);

		JPanel deleteDVDPanel = new JPanel();
		deleteDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(deleteDVDPanel, "name_deleteDVDPanel");
		
		JLabel label_3 = new JLabel("5555555");
		deleteDVDPanel.add(label_3);

		returnDVDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdCardLayout.show(dvdContentPanel, "name_returnDVDPanel");
				changeBackground(returnDVDButton, lookDVDButton, lendDVDButton, addDVDButton, deleteDVDButton);
			}
		});
		addDVDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdCardLayout.show(dvdContentPanel, "name_addDVDPanel");
				changeBackground(addDVDButton, lookDVDButton, lendDVDButton, returnDVDButton, deleteDVDButton);
			}
		});
		deleteDVDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdCardLayout.show(dvdContentPanel, "name_deleteDVDPanel");
				changeBackground(deleteDVDButton, lookDVDButton, lendDVDButton, returnDVDButton, addDVDButton);
			}
		});
		lendDVDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdCardLayout.show(dvdContentPanel, "name_lendDVDPanel");
				changeBackground(lendDVDButton, lookDVDButton, returnDVDButton, addDVDButton, deleteDVDButton);
			}
		});
		lookDVDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdCardLayout.show(dvdContentPanel, "name_lookDVDPanel");
				changeBackground(lookDVDButton, lendDVDButton, returnDVDButton, addDVDButton, deleteDVDButton);
			}
		});
		lookDVDButton.setBackground(new Color(191, 205, 219));
		lookDVDButton.setFont(new Font("幼圆", Font.BOLD, 18));
		dvdMenuPanel.add(lookDVDButton);

		lendDVDButton.setBackground(SystemColor.inactiveCaptionBorder);
		lendDVDButton.setFont(new Font("幼圆", Font.BOLD, 18));
		dvdMenuPanel.add(lendDVDButton);

		returnDVDButton.setFont(new Font("幼圆", Font.BOLD, 18));
		returnDVDButton.setBackground(SystemColor.inactiveCaptionBorder);
		dvdMenuPanel.add(returnDVDButton);

		addDVDButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addDVDButton.setBackground(SystemColor.inactiveCaptionBorder);
		dvdMenuPanel.add(addDVDButton);

		deleteDVDButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteDVDButton.setBackground(SystemColor.inactiveCaptionBorder);
		dvdMenuPanel.add(deleteDVDButton);

		JPanel employeePanel = new JPanel();
		employeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.add(employeePanel, "name_employeePanel");
		employeePanel.setLayout(null);
		
		JPanel employeeMenuPanel = new JPanel();
		employeeMenuPanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.setBounds(10, 0, 806, 44);
		employeePanel.add(employeeMenuPanel);
		employeeMenuPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton lookEmployeeButton = new JButton("\u67E5\u8BE2\u5458\u5DE5");
		lookEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookEmployeeButton.setBackground(SystemColor.inactiveCaption);
		employeeMenuPanel.add(lookEmployeeButton);
		
		JButton addEmployeeButton = new JButton("\u65B0\u589E\u5458\u5DE5");
		addEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(addEmployeeButton);
		
		JButton updateEmployeeButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		updateEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		updateEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(updateEmployeeButton);
		
		JButton deleteEmployeeButton = new JButton("\u5220\u9664\u5458\u5DE5");
		deleteEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(deleteEmployeeButton);

		JPanel customPanel = new JPanel();
		customPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.add(customPanel, "name_customPanel");
		customPanel.setLayout(null);
		
		JPanel customMenuPanel = new JPanel();
		customMenuPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.setBounds(10, 0, 806, 44);
		customPanel.add(customMenuPanel);
		customMenuPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton lookCustomButton = new JButton("\u67E5\u8BE2\u5BA2\u6237");
		lookCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookCustomButton.setBackground(SystemColor.inactiveCaption);
		customMenuPanel.add(lookCustomButton);
		
		JButton addCustomButton = new JButton("\u65B0\u589E\u5BA2\u6237");
		addCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addCustomButton.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.add(addCustomButton);
		
		JButton deleteCustomButton = new JButton("\u5220\u9664\u5BA2\u6237");
		deleteCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteCustomButton.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.add(deleteCustomButton);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(10, 10, 826, 63);
		mainFrame.getContentPane().add(menuPanel);
		menuPanel.setLayout(new GridLayout(0, 4, 0, 0));

		JButton dvdManageButton = new JButton("DVD\u7BA1\u7406");
		JButton employeeManageButton = new JButton("\u5458\u5DE5\u7BA1\u7406");
		JButton customManageButton = new JButton("\u5BA2\u6237\u7BA1\u7406");
		dvdManageButton.setBackground(new Color(191, 205, 219));
		employeeManageButton.setBackground(SystemColor.inactiveCaptionBorder);
		customManageButton.setBackground(SystemColor.inactiveCaptionBorder);

		dvdManageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPanel, "name_dvdPanel");
				changeBackground(dvdManageButton, employeeManageButton, customManageButton);
			}
		});
		dvdManageButton.setFont(new Font("幼圆", Font.BOLD, 24));
		menuPanel.add(dvdManageButton);

		employeeManageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPanel, "name_employeePanel");
				changeBackground(employeeManageButton, dvdManageButton, customManageButton);
			}
		});
		employeeManageButton.setFont(new Font("幼圆", Font.BOLD, 24));
		menuPanel.add(employeeManageButton);

		customManageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPanel, "name_customPanel");
				changeBackground(customManageButton, employeeManageButton, dvdManageButton);
			}
		});
		customManageButton.setFont(new Font("幼圆", Font.BOLD, 24));
		menuPanel.add(customManageButton);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		menuPanel.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JButton logoffButton = new JButton("\u6CE8\u9500");
		logoffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, "注销后返回登录页面，是否注销？", "提示", JOptionPane.YES_NO_OPTION);
				if (choose == 0) {
					mainFrame.setVisible(false);
					new Login();
				}
			}
		});
		logoffButton.setFont(new Font("幼圆", Font.BOLD, 24));
		logoffButton.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(logoffButton);

		JButton exitButton = new JButton("\u9000\u51FA");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, "是否退出系统？", "提示", JOptionPane.YES_NO_OPTION);
				if (choose == 0) {
					JOptionPane.showMessageDialog(null, "系统即将安全退出！", "提示", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		});
		exitButton.setFont(new Font("幼圆", Font.BOLD, 24));
		exitButton.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(exitButton);
		menuPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logoffButton, dvdManageButton,
				employeeManageButton, customManageButton, panel, exitButton }));
		mainFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { dvdManageButton,
				menuPanel, employeeManageButton, customManageButton, contentPanel }));
		mainFrame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { dvdManageButton, menuPanel,
				employeeManageButton, customManageButton, contentPanel, mainFrame.getContentPane() }));
		mainFrame.setVisible(true);
	}

	/**
	 * 修改JButton的背景颜色
	 * 
	 * @param button
	 *            要改为选中色的button
	 * @param jButtons
	 *            改为默认色的button
	 */
	private static void changeBackground(JButton button, JButton... jButtons) {
		button.setBackground(new Color(191, 205, 219));
		for (JButton jButton : jButtons) {
			jButton.setBackground(SystemColor.inactiveCaptionBorder);
		}
	}
}
