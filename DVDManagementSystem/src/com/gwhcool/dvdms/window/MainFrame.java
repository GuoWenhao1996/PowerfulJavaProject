package com.gwhcool.dvdms.window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.gwhcool.dvdms.entity.DVD;
import com.gwhcool.dvdms.service.DVDService;
import com.gwhcool.dvdms.service.impl.DVDServiceImpl;
import com.gwhcool.dvdms.util.MySystemUtil;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

public class MainFrame {

	private DVDService ds = new DVDServiceImpl();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private JFrame mainFrame;
	private JTextField dvdIdTextField;
	private JTextField dvdNameTextField;

	private JTable dvdTable;
	private JScrollPane dvdScrollpane = new JScrollPane();
	private Vector dvdRowData = new Vector();
	private Vector dvdColumName = new Vector();

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
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, "是否退出系统？", "提示", JOptionPane.YES_NO_OPTION);
				if (choose == 0) {
					JOptionPane.showMessageDialog(null, "系统即将安全退出！", "提示", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else {
					mainFrame.setVisible(true);
				}
			}
		});
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
		CardLayout dvdCardLayout = new CardLayout(0, 0);
		dvdContentPanel.setLayout(dvdCardLayout);

		JPanel lookDVDPanel = new JPanel();
		lookDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(lookDVDPanel, "name_lookDVDPanel");
		lookDVDPanel.setLayout(null);

		JLabel lblDvd = new JLabel("DVD编号：");
		lblDvd.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblDvd.setBounds(125, 2, 81, 30);
		lookDVDPanel.add(lblDvd);

		dvdIdTextField = new JTextField();
		dvdIdTextField.setBounds(204, 7, 109, 21);
		lookDVDPanel.add(dvdIdTextField);
		dvdIdTextField.setColumns(10);
		dvdIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});

		dvdNameTextField = new JTextField();
		dvdNameTextField.setColumns(10);
		dvdNameTextField.setBounds(419, 7, 109, 21);
		lookDVDPanel.add(dvdNameTextField);

		JLabel lblDvd_1 = new JLabel("DVD名称：");
		lblDvd_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblDvd_1.setBounds(339, 1, 81, 30);
		lookDVDPanel.add(lblDvd_1);

		JButton lookDvdContentbutton = new JButton("查询");
		lookDvdContentbutton.setBounds(597, 0, 93, 28);
		lookDVDPanel.add(lookDvdContentbutton);
		lookDvdContentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdRowData.clear();
				dvdColumName.clear();
				dvdColumName.add("编号");
				dvdColumName.add("名称");
				dvdColumName.add("状态");
				dvdColumName.add("剩余数量");
				dvdColumName.add("下架时间");
				dvdColumName.add("添加人工号");
				List<DVD> dvds = new LinkedList<>();
				if (dvdIdTextField.getText().isEmpty()) {
					if (dvdNameTextField.getText().isEmpty()) {
						// 查全部
						dvds = ds.getALLDVD();
					} else {
						String name = dvdNameTextField.getText();
						dvds = ds.getDVDByName(name);
					}
				} else {
					int id = Integer.parseInt(dvdIdTextField.getText());
					dvds = ds.getDVDByid(id);
				}

				for (DVD dvd : dvds) {
					Vector vNext = new Vector();
					vNext.add(dvd.getId());
					vNext.add(dvd.getName());
					vNext.add(dvd.getState());
					vNext.add(dvd.getCount());
					String timestr;
					if (dvd.getDatetime() != null) {
						timestr = sdf.format(dvd.getDatetime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					vNext.add(dvd.getEid());
					dvdRowData.add(vNext);
				}
				dvdTable = new JTable(dvdRowData, dvdColumName);
				dvdTable.setBackground(SystemColor.info);
				dvdTable.setBounds(10, 36, 806, 377);
				dvdTable.setFont(new Font("幼圆", Font.PLAIN, 14));
				dvdTable.setEnabled(false);
				dvdTable.getColumnModel().getColumn(0).setPreferredWidth(160);
				dvdTable.getColumnModel().getColumn(1).setPreferredWidth(166);
				dvdTable.getColumnModel().getColumn(2).setPreferredWidth(80);
				dvdTable.getColumnModel().getColumn(3).setPreferredWidth(80);
				dvdTable.getColumnModel().getColumn(4).setPreferredWidth(160);
				dvdTable.getColumnModel().getColumn(5).setPreferredWidth(160);
				DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
				renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				dvdTable.setDefaultRenderer(Object.class, renderer);
				dvdTable.setPreferredScrollableViewportSize(dvdTable.getSize());
				dvdTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				dvdScrollpane.setEnabled(false);
				dvdScrollpane.setBounds(10, 36, 806, 377);
				dvdScrollpane.setBackground(SystemColor.window);
				dvdScrollpane.add(dvdTable);
				dvdScrollpane.setViewportView(dvdTable);
				lookDVDPanel.add(dvdScrollpane);
			}
		});
		lookDvdContentbutton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookDvdContentbutton.setBackground(SystemColor.inactiveCaptionBorder);

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

		JPanel employeeContentPanel = new JPanel();
		employeeContentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.setBounds(0, 54, 826, 423);
		employeePanel.add(employeeContentPanel);
		CardLayout employeeCardLayout = new CardLayout(0, 0);
		employeeContentPanel.setLayout(employeeCardLayout);

		JButton lookEmployeeButton = new JButton("\u67E5\u8BE2\u5458\u5DE5");
		JButton addEmployeeButton = new JButton("\u65B0\u589E\u5458\u5DE5");
		JButton updateEmployeeButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		JButton deleteEmployeeButton = new JButton("\u5220\u9664\u5458\u5DE5");
		lookEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeCardLayout.show(employeeContentPanel, "name_lookEmployeePanel");
				changeBackground(lookEmployeeButton, addEmployeeButton, updateEmployeeButton, deleteEmployeeButton);
			}
		});
		lookEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookEmployeeButton.setBackground(SystemColor.inactiveCaption);
		employeeMenuPanel.add(lookEmployeeButton);

		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeCardLayout.show(employeeContentPanel, "name_addEmployeePanel");
				changeBackground(addEmployeeButton, lookEmployeeButton, updateEmployeeButton, deleteEmployeeButton);
			}
		});
		addEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(addEmployeeButton);

		updateEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeCardLayout.show(employeeContentPanel, "name_updateEmployeePanel");
				changeBackground(updateEmployeeButton, addEmployeeButton, lookEmployeeButton, deleteEmployeeButton);
			}
		});
		updateEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		updateEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(updateEmployeeButton);

		deleteEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeCardLayout.show(employeeContentPanel, "name_deleteEmployeePanel");
				changeBackground(deleteEmployeeButton, addEmployeeButton, lookEmployeeButton, updateEmployeeButton);
			}
		});
		deleteEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		employeeMenuPanel.add(deleteEmployeeButton);

		JPanel lookEmployeePanel = new JPanel();
		lookEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(lookEmployeePanel, "name_lookEmployeePanel");

		JLabel label_4 = new JLabel("11111");
		lookEmployeePanel.add(label_4);

		JPanel addEmployeePanel = new JPanel();
		addEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(addEmployeePanel, "name_addEmployeePanel");

		JLabel label_5 = new JLabel("22222");
		addEmployeePanel.add(label_5);

		JPanel updateEmployeePanel = new JPanel();
		updateEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(updateEmployeePanel, "name_updateEmployeePanel");

		JLabel label_6 = new JLabel("33333");
		updateEmployeePanel.add(label_6);

		JPanel deleteEmployeePanel = new JPanel();
		deleteEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(deleteEmployeePanel, "name_deleteEmployeePanel");

		JLabel label_7 = new JLabel("44444");
		deleteEmployeePanel.add(label_7);

		JPanel customPanel = new JPanel();
		customPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.add(customPanel, "name_customPanel");
		customPanel.setLayout(null);

		JPanel customMenuPanel = new JPanel();
		customMenuPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.setBounds(10, 0, 806, 44);
		customPanel.add(customMenuPanel);
		customMenuPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel customContentPanel = new JPanel();
		customContentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.setBounds(0, 54, 826, 423);
		customPanel.add(customContentPanel);
		CardLayout customCardLayout = new CardLayout(0, 0);
		customContentPanel.setLayout(customCardLayout);

		JButton lookCustomButton = new JButton("\u67E5\u8BE2\u5BA2\u6237");
		JButton addCustomButton = new JButton("\u65B0\u589E\u5BA2\u6237");
		JButton deleteCustomButton = new JButton("\u5220\u9664\u5BA2\u6237");
		lookCustomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customCardLayout.show(customContentPanel, "name_lookCustomPanel");
				changeBackground(lookCustomButton, addCustomButton, deleteCustomButton);
			}
		});
		lookCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookCustomButton.setBackground(SystemColor.inactiveCaption);
		customMenuPanel.add(lookCustomButton);

		addCustomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customCardLayout.show(customContentPanel, "name_addCustomPanel");
				changeBackground(addCustomButton, lookCustomButton, deleteCustomButton);
			}
		});
		addCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addCustomButton.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.add(addCustomButton);

		deleteCustomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customCardLayout.show(customContentPanel, "name_deleteCustomPanel");
				changeBackground(deleteCustomButton, lookCustomButton, addCustomButton);
			}
		});
		deleteCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteCustomButton.setBackground(SystemColor.inactiveCaptionBorder);
		customMenuPanel.add(deleteCustomButton);

		JPanel lookCustomPanel = new JPanel();
		lookCustomPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.add(lookCustomPanel, "name_lookCustomPanel");

		JLabel label_8 = new JLabel("111");
		lookCustomPanel.add(label_8);

		JPanel addCustomPanel = new JPanel();
		addCustomPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.add(addCustomPanel, "name_addCustomPanel");

		JLabel label_9 = new JLabel("222");
		addCustomPanel.add(label_9);

		JPanel deleteCustomPanel = new JPanel();
		deleteCustomPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.add(deleteCustomPanel, "name_deleteCustomPanel");

		JLabel label_10 = new JLabel("333");
		deleteCustomPanel.add(label_10);

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
	 * 改变JButton的背景颜色
	 * 
	 * @param button
	 *            要改变的button
	 * @param jButtons
	 *            默认色的button
	 */
	private static void changeBackground(JButton button, JButton... jButtons) {
		button.setBackground(new Color(191, 205, 219));
		for (JButton jButton : jButtons) {
			jButton.setBackground(SystemColor.inactiveCaptionBorder);
		}
	}
}
