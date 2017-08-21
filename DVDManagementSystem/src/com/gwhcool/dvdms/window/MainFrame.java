package com.gwhcool.dvdms.window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.gwhcool.dvdms.entity.Custom;
import com.gwhcool.dvdms.entity.DVD;
import com.gwhcool.dvdms.entity.Employee;
import com.gwhcool.dvdms.entity.Lend;
import com.gwhcool.dvdms.service.CustomService;
import com.gwhcool.dvdms.service.DVDService;
import com.gwhcool.dvdms.service.EmployeeService;
import com.gwhcool.dvdms.service.LendService;
import com.gwhcool.dvdms.service.impl.CustomServiceImpl;
import com.gwhcool.dvdms.service.impl.DVDServiceImpl;
import com.gwhcool.dvdms.service.impl.EmployeeServiceImpl;
import com.gwhcool.dvdms.service.impl.LendServiceImpl;
import com.gwhcool.dvdms.util.MySystemUtil;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class MainFrame {

	private DVDService ds = new DVDServiceImpl();
	private EmployeeService es = new EmployeeServiceImpl();
	private CustomService cs = new CustomServiceImpl();
	private LendService ls = new LendServiceImpl();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private JFrame mainFrame;
	private JTextField dvdIdTextField;
	private JTextField dvdNameTextField;

	private JTable dvdTable;
	private JScrollPane dvdScrollpane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private Vector dvdRowData = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector dvdColumName = new Vector();

	private JTable employeeTable;
	private JScrollPane employeeScrollpane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private Vector employeeRowData = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector employeeColumName = new Vector();

	private JTable customTable;
	private JScrollPane customScrollpane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private Vector customRowData = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector customColumName = new Vector();

	private JTable lendTable;
	private JScrollPane lendScrollpane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private Vector lendRowData = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector lendColumName = new Vector();

	private JTable returnTable;
	private JScrollPane returnScrollpane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	private Vector returnRowData = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector returnColumName = new Vector();

	private JTextField employeeIdTextField;
	private JTextField employeeNameTextField;
	private JTextField customIdTextField;
	private JTextField customNameTextField;
	private JTextField addDvdNameTextField;
	private JTextField addDvdCountTextField;
	private JTextField addEmployeeNameTextField;
	private JTextField addEmployeeSexTextField;
	private JTextField addCustomNameTextField;
	private JTextField addCustomSexTextField;
	private JTextField deleteDvdIdTextField;
	private JTextField deleteEmployeeIdTextField;
	private JTextField deleteCustomIdTextField;
	private JTextField oldPwdTextField;
	private JTextField newPwdTextField;
	private JTextField newPwdTextField2;
	private JTextField lendDVDIdTextField;
	private JTextField lendCustomIdTextField;
	private JTextField returnCustomIdTextField;
	private JTextField returnDVDIdTextField;

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
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		mainFrame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		mainFrame.setTitle(
				"\u4E3B\u754C\u9762                                                                             DVD\u7BA1\u7406\u7CFB\u7EDF");
		mainFrame.setBounds(300, 500, 852, 600);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int choose = JOptionPane.showConfirmDialog(mainFrame, "是否退出系统？", "提示", JOptionPane.YES_NO_OPTION);
				if (choose == 0) {
					JOptionPane.showMessageDialog(mainFrame, "系统即将安全退出！", "提示", JOptionPane.INFORMATION_MESSAGE);
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
		lblDvd_1.setBounds(339, 2, 81, 30);
		lookDVDPanel.add(lblDvd_1);

		JButton lookDvdContentbutton = new JButton("查询");
		lookDvdContentbutton.setBounds(597, 0, 93, 28);
		lookDVDPanel.add(lookDvdContentbutton);
		lookDvdContentbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
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
						String name = dvdNameTextField.getText().trim();
						dvds = ds.getDVDByName(name);
					}
				} else {
					int id = Integer.parseInt(dvdIdTextField.getText());
					dvds = ds.getDVDByid(id);
				}

				for (DVD dvd : dvds) {
					@SuppressWarnings("rawtypes")
					Vector vNext = new Vector();
					vNext.add(dvd.getId());
					vNext.add(dvd.getName());
					vNext.add(dvd.getState());
					vNext.add(dvd.getCount());
					String timestr;
					if (dvd.getUndertime() != null) {
						timestr = sdf.format(dvd.getUndertime());
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
				JOptionPane.showMessageDialog(mainFrame, "查询成功，共查出【" + dvds.size() + "】条记录！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lookDvdContentbutton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookDvdContentbutton.setBackground(SystemColor.inactiveCaptionBorder);

		JPanel lendDVDPanel = new JPanel();
		lendDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(lendDVDPanel, "name_lendDVDPanel");
		lendDVDPanel.setLayout(null);

		lendDVDIdTextField = new JTextField();
		lendDVDIdTextField.setColumns(10);
		lendDVDIdTextField.setBounds(348, 7, 109, 21);
		lendDVDIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		lendDVDPanel.add(lendDVDIdTextField);

		JLabel lblDvd_2 = new JLabel("DVD 编号：");
		lblDvd_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblDvd_2.setBounds(245, 2, 93, 30);
		lendDVDPanel.add(lblDvd_2);

		JLabel label_5 = new JLabel("客户编号：");
		label_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_5.setBounds(245, 38, 93, 30);
		label_5.setVisible(false);
		lendDVDPanel.add(label_5);

		lendCustomIdTextField = new JTextField();
		lendCustomIdTextField.setColumns(10);
		lendCustomIdTextField.setBounds(348, 43, 109, 21);
		lendCustomIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		lendCustomIdTextField.setVisible(false);
		lendDVDPanel.add(lendCustomIdTextField);

		JButton lendButton = new JButton("借阅");
		lendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lendDVDIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "DVD编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (lendCustomIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "客户编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int did = Integer.parseInt(lendDVDIdTextField.getText());
					if ("已下架".equals(ds.getDVDByid(did).get(0).getState())) {
						JOptionPane.showMessageDialog(mainFrame, "【" + did + "】当前已下架，无法借阅！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else if ("已租完".equals(ds.getDVDByid(did).get(0).getState())) {
						JOptionPane.showMessageDialog(mainFrame, "【" + did + "】当前数量为0，无法借阅！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else {
						int cid = Integer.parseInt(lendCustomIdTextField.getText());
						Lend lend = new Lend(did, cid);
						if (ls.addLend(lend)) {
							JOptionPane.showMessageDialog(mainFrame, "借阅成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "借阅失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		lendButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lendButton.setBackground(SystemColor.inactiveCaptionBorder);
		lendButton.setBounds(467, 38, 93, 28);
		lendButton.setVisible(false);
		lendDVDPanel.add(lendButton);
		JButton lookLendbutton = new JButton("查询");
		lookLendbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				label_5.setVisible(true);
				lendCustomIdTextField.setVisible(true);
				lendButton.setVisible(true);
				lendRowData.clear();
				lendColumName.clear();
				lendColumName.add("DVD编号");
				lendColumName.add("DVD名称");
				lendColumName.add("借阅人编号");
				lendColumName.add("借阅人姓名");
				lendColumName.add("借阅时间");
				lendColumName.add("归还时间");
				List<Lend> lends = new LinkedList<>();
				if (lendDVDIdTextField.getText().isEmpty()) {
					// 查全部
					lends = ls.getALLLend();
				} else {
					int id = Integer.parseInt(lendDVDIdTextField.getText());
					lends = ls.getLendByDVDId(id);
				}
				for (Lend lend : lends) {
					@SuppressWarnings("rawtypes")
					Vector vNext = new Vector();
					vNext.add(lend.getDid());
					vNext.add(ds.getDVDByid(lend.getDid()).get(0).getName());
					vNext.add(lend.getCid());
					vNext.add(cs.getCustomByid(lend.getCid()).get(0).getName());
					String timestr;
					if (lend.getLendtime() != null) {
						timestr = sdf.format(lend.getLendtime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					if (lend.getBacktime() != null) {
						timestr = sdf.format(lend.getBacktime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					lendRowData.add(vNext);
				}
				lendTable = new JTable(lendRowData, lendColumName);
				lendTable.setBackground(SystemColor.info);
				lendTable.setBounds(10, 78, 806, 335);
				lendTable.setFont(new Font("幼圆", Font.PLAIN, 14));
				lendTable.setEnabled(false);
				lendTable.getColumnModel().getColumn(0).setPreferredWidth(80);
				lendTable.getColumnModel().getColumn(1).setPreferredWidth(126);
				lendTable.getColumnModel().getColumn(2).setPreferredWidth(80);
				lendTable.getColumnModel().getColumn(3).setPreferredWidth(120);
				lendTable.getColumnModel().getColumn(4).setPreferredWidth(200);
				lendTable.getColumnModel().getColumn(5).setPreferredWidth(200);
				DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
				renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				lendTable.setDefaultRenderer(Object.class, renderer);
				lendTable.setPreferredScrollableViewportSize(lendTable.getSize());
				lendTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				lendScrollpane.setEnabled(false);
				lendScrollpane.setBounds(10, 78, 806, 335);
				lendScrollpane.setBackground(SystemColor.window);
				lendScrollpane.add(lendTable);
				lendScrollpane.setViewportView(lendTable);
				lendDVDPanel.add(lendScrollpane);
				JOptionPane.showMessageDialog(mainFrame, "查询成功，共查出【" + lends.size() + "】条记录！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lookLendbutton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookLendbutton.setBackground(SystemColor.inactiveCaptionBorder);
		lookLendbutton.setBounds(467, 2, 93, 28);
		lendDVDPanel.add(lookLendbutton);
		JPanel returnDVDPanel = new JPanel();
		returnDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(returnDVDPanel, "name_returnDVDPanel");
		returnDVDPanel.setLayout(null);

		JLabel label_1 = new JLabel("客户编号：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_1.setBounds(245, 2, 93, 30);
		returnDVDPanel.add(label_1);

		returnCustomIdTextField = new JTextField();
		returnCustomIdTextField.setColumns(10);
		returnCustomIdTextField.setBounds(348, 7, 109, 21);
		returnCustomIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		returnDVDPanel.add(returnCustomIdTextField);

		JLabel label_2 = new JLabel("DVD 编号：");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_2.setBounds(245, 38, 93, 30);
		label_2.setVisible(false);
		returnDVDPanel.add(label_2);

		returnDVDIdTextField = new JTextField();
		returnDVDIdTextField.setColumns(10);
		returnDVDIdTextField.setBounds(348, 43, 109, 21);
		returnDVDIdTextField.setVisible(false);
		returnDVDIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		returnDVDPanel.add(returnDVDIdTextField);

		JButton returnButton = new JButton("归还");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (returnCustomIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "客户编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (returnDVDIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "DVD编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int did = Integer.parseInt(returnDVDIdTextField.getText());
					int cid = Integer.parseInt(returnCustomIdTextField.getText());
					Lend lend = new Lend(did, cid);
					if (ls.deleteLend(lend)) {
						JOptionPane.showMessageDialog(mainFrame, "归还成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(mainFrame, "您尚未借阅此DVD！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		returnButton.setFont(new Font("幼圆", Font.BOLD, 18));
		returnButton.setBackground(SystemColor.inactiveCaptionBorder);
		returnButton.setBounds(467, 38, 93, 28);
		returnButton.setVisible(false);
		returnDVDPanel.add(returnButton);

		JButton lookReturnbutton = new JButton("查询");
		lookReturnbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				label_2.setVisible(true);
				returnDVDIdTextField.setVisible(true);
				returnButton.setVisible(true);

				returnRowData.clear();
				returnColumName.clear();
				returnColumName.add("DVD编号");
				 returnColumName.add("DVD名称");
				returnColumName.add("借阅人编号");
				 returnColumName.add("借阅人姓名");
				returnColumName.add("借阅时间");
				returnColumName.add("归还时间");
				List<Lend> lends = new LinkedList<>();
				if (returnCustomIdTextField.getText().isEmpty()) {
					// 查全部
					lends = ls.getALLLend();
				} else {
					int id = Integer.parseInt(returnCustomIdTextField.getText());
					lends = ls.getLendByCustomId(id);
				}
				for (Lend lend : lends) {
					@SuppressWarnings("rawtypes")
					Vector vNext = new Vector();
					vNext.add(lend.getDid());
					 vNext.add(ds.getDVDByid(lend.getDid()).get(0).getName());
					vNext.add(lend.getCid());
					 vNext.add(cs.getCustomByid(lend.getCid()).get(0).getName());
					String timestr;
					if (lend.getLendtime() != null) {
						timestr = sdf.format(lend.getLendtime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					if (lend.getBacktime() != null) {
						timestr = sdf.format(lend.getBacktime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					returnRowData.add(vNext);
				}
				returnTable = new JTable(returnRowData, returnColumName);
				returnTable.setBackground(SystemColor.info);
				returnTable.setBounds(10, 78, 806, 335);
				returnTable.setFont(new Font("幼圆", Font.PLAIN, 14));
				returnTable.setEnabled(false);
				returnTable.getColumnModel().getColumn(0).setPreferredWidth(80);
				returnTable.getColumnModel().getColumn(1).setPreferredWidth(126);
				returnTable.getColumnModel().getColumn(2).setPreferredWidth(80);
				returnTable.getColumnModel().getColumn(3).setPreferredWidth(120);
				returnTable.getColumnModel().getColumn(4).setPreferredWidth(200);
				returnTable.getColumnModel().getColumn(5).setPreferredWidth(200);
				DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
				renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				returnTable.setDefaultRenderer(Object.class, renderer);
				returnTable.setPreferredScrollableViewportSize(returnTable.getSize());
				returnTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				returnScrollpane.setEnabled(false);
				returnScrollpane.setBounds(10, 78, 806, 335);
				returnScrollpane.setBackground(SystemColor.window);
				returnScrollpane.add(returnTable);
				returnScrollpane.setViewportView(returnTable);
				returnDVDPanel.add(returnScrollpane);
				JOptionPane.showMessageDialog(mainFrame, "查询成功，共查出【" + lends.size() + "】条记录！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lookReturnbutton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookReturnbutton.setBackground(SystemColor.inactiveCaptionBorder);
		lookReturnbutton.setBounds(467, 2, 93, 28);
		returnDVDPanel.add(lookReturnbutton);

		JPanel addDVDPanel = new JPanel();
		addDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(addDVDPanel, "name_addDVDPanel");
		addDVDPanel.setLayout(null);

		JLabel lblAddDvdName = new JLabel("DVD名称：");
		lblAddDvdName.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddDvdName.setBounds(285, 56, 81, 30);
		addDVDPanel.add(lblAddDvdName);

		addDvdNameTextField = new JTextField();
		addDvdNameTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addDvdNameTextField.setColumns(10);
		addDvdNameTextField.setBounds(364, 57, 200, 30);
		addDVDPanel.add(addDvdNameTextField);

		JButton addDvdButton = new JButton("添加");
		addDvdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (addDvdNameTextField.getText().isEmpty() || addDvdNameTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "DVD名称不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (addDvdCountTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "DVD数量不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					String name = addDvdNameTextField.getText().trim();
					int count = Integer.parseInt(addDvdCountTextField.getText());
					String state;
					if (count != 0) {
						state = "可租";
					} else {
						state = "已租完";
					}
					int eid = Login.employeeid;
					DVD newdvd = new DVD(name, state, count, eid);
					if (ds.addDvd(newdvd)) {
						JOptionPane.showMessageDialog(mainFrame, "【" + name + "】添加成功！", "提示",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + name + "】添加失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		addDvdButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addDvdButton.setBackground(SystemColor.inactiveCaptionBorder);
		addDvdButton.setBounds(325, 175, 93, 28);
		addDVDPanel.add(addDvdButton);

		addDvdCountTextField = new JTextField();
		addDvdCountTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addDvdCountTextField.setColumns(10);
		addDvdCountTextField.setBounds(364, 108, 200, 30);
		addDvdCountTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		addDVDPanel.add(addDvdCountTextField);

		JLabel lblAddDvdCount = new JLabel("DVD数量：");
		lblAddDvdCount.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddDvdCount.setBounds(285, 108, 81, 30);
		addDVDPanel.add(lblAddDvdCount);

		JButton clearAddDvdButton = new JButton("清空");
		clearAddDvdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDvdNameTextField.setText("");
				addDvdCountTextField.setText("");
			}
		});
		clearAddDvdButton.setFont(new Font("幼圆", Font.BOLD, 18));
		clearAddDvdButton.setBackground(SystemColor.inactiveCaptionBorder);
		clearAddDvdButton.setBounds(449, 175, 93, 28);
		addDVDPanel.add(clearAddDvdButton);

		JPanel deleteDVDPanel = new JPanel();
		deleteDVDPanel.setBackground(SystemColor.inactiveCaptionBorder);
		dvdContentPanel.add(deleteDVDPanel, "name_deleteDVDPanel");
		deleteDVDPanel.setLayout(null);

		JLabel lbldeleteDvdName = new JLabel("要下架的DVD编号");
		lbldeleteDvdName.setBounds(344, 48, 135, 21);
		lbldeleteDvdName.setFont(new Font("幼圆", Font.PLAIN, 18));
		deleteDVDPanel.add(lbldeleteDvdName);

		deleteDvdIdTextField = new JTextField();
		deleteDvdIdTextField.setBounds(344, 83, 135, 27);
		deleteDvdIdTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		deleteDvdIdTextField.setColumns(10);
		deleteDvdIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		deleteDVDPanel.add(deleteDvdIdTextField);

		JButton deleteDvdNameButton = new JButton("下架");
		deleteDvdNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deleteDvdIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "DVD编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = Integer.parseInt(deleteDvdIdTextField.getText());
					List<DVD> list = ds.getDVDByid(id);
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(mainFrame, "【" + id + "】不存在！", "提示", JOptionPane.WARNING_MESSAGE);
					} else if (list.get(0).getUndertime() != null) {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + id + "】已于【" + sdf.format(list.get(0).getUndertime()) + "】下架！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else {
						DVD dvd = list.get(0);
						int choose = JOptionPane.showConfirmDialog(mainFrame, "DVD编号:【" + id + "】\nDVD名称:【"
								+ dvd.getName() + "】\n剩余数量:【" + dvd.getCount() + "】\n删除后不可恢复，是否删除？", "提示",
								JOptionPane.YES_NO_OPTION);
						if (choose == 0) {
							if (ds.deleteDvd(dvd)) {
								JOptionPane.showMessageDialog(mainFrame, "删除成功，【" + id + "】已下架", "提示",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(mainFrame,
										"【" + id + "】下架失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		deleteDvdNameButton.setBounds(489, 47, 83, 63);
		deleteDvdNameButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteDvdNameButton.setBackground(SystemColor.inactiveCaptionBorder);
		deleteDVDPanel.add(deleteDvdNameButton);

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
		lookEmployeePanel.setLayout(null);

		JLabel lblEmployee = new JLabel("员工工号：");
		lblEmployee.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblEmployee.setBounds(125, 2, 90, 30);
		lookEmployeePanel.add(lblEmployee);

		employeeIdTextField = new JTextField();
		employeeIdTextField.setColumns(10);
		employeeIdTextField.setBounds(211, 7, 109, 21);
		employeeIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		lookEmployeePanel.add(employeeIdTextField);

		employeeNameTextField = new JTextField();
		employeeNameTextField.setColumns(10);
		employeeNameTextField.setBounds(423, 7, 109, 21);
		lookEmployeePanel.add(employeeNameTextField);

		JLabel lblEmployee_1 = new JLabel("员工姓名：");
		lblEmployee_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblEmployee_1.setBounds(339, 2, 90, 30);
		lookEmployeePanel.add(lblEmployee_1);

		JButton lookEmployeeContentbuttonButton = new JButton("查询");
		lookEmployeeContentbuttonButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				employeeRowData.clear();
				employeeColumName.clear();
				employeeColumName.add("工号");
				employeeColumName.add("姓名");
				employeeColumName.add("性别");
				employeeColumName.add("入职时间");
				employeeColumName.add("离职时间");
				List<Employee> employees = new LinkedList<>();
				if (employeeIdTextField.getText().isEmpty()) {
					if (employeeNameTextField.getText().isEmpty()) {
						// 查全部
						employees = es.getALLEmployee();
					} else {
						String name = employeeNameTextField.getText().trim();
						employees = es.getEmployeeByName(name);
					}
				} else {
					int id = Integer.parseInt(employeeIdTextField.getText());
					employees = es.getEmployeeByid(id);
				}

				for (Employee employee : employees) {
					@SuppressWarnings("rawtypes")
					Vector vNext = new Vector();
					vNext.add(employee.getId());
					vNext.add(employee.getName());
					vNext.add(employee.getSex());
					String timestr;
					if (employee.getJointime() != null) {
						timestr = sdf.format(employee.getJointime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					if (employee.getLeavetime() != null) {
						timestr = sdf.format(employee.getLeavetime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					employeeRowData.add(vNext);
				}
				employeeTable = new JTable(employeeRowData, employeeColumName);
				employeeTable.setBackground(SystemColor.info);
				employeeTable.setBounds(10, 36, 806, 377);
				employeeTable.setFont(new Font("幼圆", Font.PLAIN, 14));
				employeeTable.setEnabled(false);
				employeeTable.getColumnModel().getColumn(0).setPreferredWidth(120);
				employeeTable.getColumnModel().getColumn(1).setPreferredWidth(286);
				employeeTable.getColumnModel().getColumn(2).setPreferredWidth(80);
				employeeTable.getColumnModel().getColumn(3).setPreferredWidth(200);
				employeeTable.getColumnModel().getColumn(4).setPreferredWidth(200);
				DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
				renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				employeeTable.setDefaultRenderer(Object.class, renderer);
				employeeTable.setPreferredScrollableViewportSize(employeeTable.getSize());
				employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				employeeScrollpane.setEnabled(false);
				employeeScrollpane.setBounds(10, 36, 806, 377);
				employeeScrollpane.setBackground(SystemColor.window);
				employeeScrollpane.add(employeeTable);
				employeeScrollpane.setViewportView(employeeTable);
				lookEmployeePanel.add(employeeScrollpane);
				JOptionPane.showMessageDialog(mainFrame, "查询成功，共查出【" + employees.size() + "】条记录！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lookEmployeeContentbuttonButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookEmployeeContentbuttonButton.setBackground(SystemColor.inactiveCaptionBorder);
		lookEmployeeContentbuttonButton.setBounds(597, 0, 93, 28);
		lookEmployeePanel.add(lookEmployeeContentbuttonButton);

		JPanel addEmployeePanel = new JPanel();
		addEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(addEmployeePanel, "name_addEmployeePanel");
		addEmployeePanel.setLayout(null);

		JLabel lblAddEmployeeName = new JLabel("员工姓名：");
		lblAddEmployeeName.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddEmployeeName.setBounds(273, 56, 93, 30);
		addEmployeePanel.add(lblAddEmployeeName);

		addEmployeeNameTextField = new JTextField();
		addEmployeeNameTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addEmployeeNameTextField.setColumns(10);
		addEmployeeNameTextField.setBounds(364, 57, 200, 30);
		addEmployeePanel.add(addEmployeeNameTextField);

		JButton addEmployeeToDBButton = new JButton("添加");
		addEmployeeToDBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addEmployeeNameTextField.getText().isEmpty()
						|| addEmployeeNameTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "员工姓名不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (!("男".equals(addEmployeeSexTextField.getText().trim())
						|| "女".equals(addEmployeeSexTextField.getText().trim()))) {
					JOptionPane.showMessageDialog(mainFrame, "员工性别只能为【男】或【女】！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					String name = addEmployeeNameTextField.getText().trim();
					String sex = addEmployeeSexTextField.getText().trim();
					String password = "111111";
					String time = MySystemUtil.getSystemTime();
					Date jointime = null;
					try {
						jointime = sdf.parse(time);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					Employee employee = new Employee(name, sex, password, jointime);
					if (es.addEmployee(employee)) {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + name + "】添加成功！\n初始密码为：【" + password + "】请及时修改密码！", "提示",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + name + "】添加失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		addEmployeeToDBButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addEmployeeToDBButton.setBackground(SystemColor.inactiveCaptionBorder);
		addEmployeeToDBButton.setBounds(325, 175, 93, 28);
		addEmployeePanel.add(addEmployeeToDBButton);

		addEmployeeSexTextField = new JTextField();
		addEmployeeSexTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addEmployeeSexTextField.setColumns(10);
		addEmployeeSexTextField.setBounds(364, 108, 200, 30);
		addEmployeePanel.add(addEmployeeSexTextField);

		JLabel lblAddEmployeeSex = new JLabel("员工性别：");
		lblAddEmployeeSex.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddEmployeeSex.setBounds(273, 108, 93, 30);
		addEmployeePanel.add(lblAddEmployeeSex);

		JButton clearAddEmployeeButton = new JButton("清空");
		clearAddEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployeeNameTextField.setText("");
				addEmployeeSexTextField.setText("");
			}
		});
		clearAddEmployeeButton.setFont(new Font("幼圆", Font.BOLD, 18));
		clearAddEmployeeButton.setBackground(SystemColor.inactiveCaptionBorder);
		clearAddEmployeeButton.setBounds(449, 175, 93, 28);
		addEmployeePanel.add(clearAddEmployeeButton);

		JPanel updateEmployeePanel = new JPanel();
		updateEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(updateEmployeePanel, "name_updateEmployeePanel");
		updateEmployeePanel.setLayout(null);

		JLabel label = new JLabel("旧 密 码：");
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		label.setBounds(273, 56, 93, 30);
		updateEmployeePanel.add(label);

		oldPwdTextField = new JPasswordField();
		oldPwdTextField.setFont(UIManager.getFont("PasswordField.font"));
		oldPwdTextField.setColumns(10);
		oldPwdTextField.setBounds(364, 57, 200, 30);
		updateEmployeePanel.add(oldPwdTextField);

		JButton updatePasswordButton = new JButton("修改");
		updatePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oldPwdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "请填写旧密码！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (newPwdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "请填写新密码！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (newPwdTextField2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "请填写确认密码！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (!newPwdTextField.getText().equals(newPwdTextField2.getText())) {
					JOptionPane.showMessageDialog(mainFrame, "新密码与确认密码不一致！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int employeeId = Login.employeeid;
					String oldPwd = oldPwdTextField.getText();
					if (es.login(employeeId, oldPwd) == 1) {
						Employee employee = new Employee();
						employee.setId(employeeId);
						employee.setPassword(newPwdTextField.getText());
						if (es.updatePassword(employee)) {
							JOptionPane.showMessageDialog(mainFrame, "密码修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mainFrame, "密码修改失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(mainFrame, "旧密码验证失败！", "提示", JOptionPane.ERROR_MESSAGE);
						oldPwdTextField.setText("");
						oldPwdTextField.requestFocus();
					}
				}
			}
		});
		updatePasswordButton.setFont(new Font("幼圆", Font.BOLD, 18));
		updatePasswordButton.setBackground(SystemColor.inactiveCaptionBorder);
		updatePasswordButton.setBounds(397, 234, 93, 28);
		updateEmployeePanel.add(updatePasswordButton);

		newPwdTextField = new JPasswordField();
		newPwdTextField.setFont(UIManager.getFont("PasswordField.font"));
		newPwdTextField.setColumns(10);
		newPwdTextField.setBounds(364, 109, 200, 30);
		updateEmployeePanel.add(newPwdTextField);

		JLabel label_3 = new JLabel("新 密 码：");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_3.setBounds(273, 108, 93, 30);
		updateEmployeePanel.add(label_3);

		JLabel label_4 = new JLabel("确认密码：");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_4.setBounds(273, 165, 93, 30);
		updateEmployeePanel.add(label_4);

		newPwdTextField2 = new JPasswordField();
		newPwdTextField2.setFont(UIManager.getFont("PasswordField.font"));
		newPwdTextField2.setColumns(10);
		newPwdTextField2.setBounds(364, 165, 200, 30);
		updateEmployeePanel.add(newPwdTextField2);
		updateEmployeePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { oldPwdTextField,
				newPwdTextField, newPwdTextField2, updatePasswordButton, label, label_3, label_4 }));

		JPanel deleteEmployeePanel = new JPanel();
		deleteEmployeePanel.setBackground(SystemColor.inactiveCaptionBorder);
		employeeContentPanel.add(deleteEmployeePanel, "name_deleteEmployeePanel");
		deleteEmployeePanel.setLayout(null);

		JLabel lbldeleteEmployeeID = new JLabel("要删除的员工编号");
		lbldeleteEmployeeID.setFont(new Font("幼圆", Font.PLAIN, 18));
		lbldeleteEmployeeID.setBounds(335, 48, 144, 21);
		deleteEmployeePanel.add(lbldeleteEmployeeID);

		deleteEmployeeIdTextField = new JTextField();
		deleteEmployeeIdTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		deleteEmployeeIdTextField.setColumns(10);
		deleteEmployeeIdTextField.setBounds(335, 83, 144, 27);
		deleteEmployeeIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		deleteEmployeePanel.add(deleteEmployeeIdTextField);

		JButton deleteEmployeeNameButton = new JButton("删除");
		deleteEmployeeNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deleteEmployeeIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "员工编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = Integer.parseInt(deleteEmployeeIdTextField.getText());
					List<Employee> list = es.getEmployeeByid(id);
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(mainFrame, "【" + id + "】不存在！", "提示", JOptionPane.WARNING_MESSAGE);
					} else if (list.get(0).getLeavetime() != null) {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + id + "】已于【" + sdf.format(list.get(0).getLeavetime()) + "】离职！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Employee employee = list.get(0);
						int choose = JOptionPane.showConfirmDialog(mainFrame,
								"员工编号:【" + id + "】\n员工姓名:【" + employee.getName() + "】\n员工性别:【" + employee.getSex()
										+ "】\n入职时间:【" + sdf.format(employee.getJointime()) + "】\n删除后不可恢复，是否删除？",
								"提示", JOptionPane.YES_NO_OPTION);
						if (choose == 0) {
							if (es.deleteEmployee(employee)) {
								JOptionPane.showMessageDialog(mainFrame, "删除成功，【" + id + "】已离职", "提示",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(mainFrame,
										"【" + id + "】删除失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		deleteEmployeeNameButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteEmployeeNameButton.setBackground(SystemColor.inactiveCaptionBorder);
		deleteEmployeeNameButton.setBounds(489, 47, 83, 63);
		deleteEmployeePanel.add(deleteEmployeeNameButton);

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
		lookCustomPanel.setLayout(null);

		JLabel lblCustom = new JLabel("客户编号：");
		lblCustom.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblCustom.setBounds(125, 2, 90, 30);
		lookCustomPanel.add(lblCustom);

		customIdTextField = new JTextField();
		customIdTextField.setColumns(10);
		customIdTextField.setBounds(211, 7, 109, 21);
		customIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		lookCustomPanel.add(customIdTextField);

		customNameTextField = new JTextField();
		customNameTextField.setColumns(10);
		customNameTextField.setBounds(423, 7, 109, 21);
		lookCustomPanel.add(customNameTextField);

		JLabel lblCustom_1 = new JLabel("客户姓名：");
		lblCustom_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblCustom_1.setBounds(339, 2, 90, 30);
		lookCustomPanel.add(lblCustom_1);

		JButton lookCustomContentbuttonButton = new JButton("查询");
		lookCustomContentbuttonButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				customRowData.clear();
				customColumName.clear();
				customColumName.add("客户编号");
				customColumName.add("姓名");
				customColumName.add("性别");
				customColumName.add("当前借阅数量");
				customColumName.add("总借阅数量");
				customColumName.add("销户时间");
				customColumName.add("添加人工号");
				List<Custom> customs = new LinkedList<>();
				if (customIdTextField.getText().isEmpty()) {
					if (customNameTextField.getText().isEmpty()) {
						// 查全部
						customs = cs.getALLCustom();
					} else {
						String name = customNameTextField.getText().trim();
						customs = cs.getCustomByName(name);
					}
				} else {
					int id = Integer.parseInt(customIdTextField.getText());
					customs = cs.getCustomByid(id);
				}

				for (Custom custom : customs) {
					@SuppressWarnings("rawtypes")
					Vector vNext = new Vector();
					vNext.add(custom.getId());
					vNext.add(custom.getName());
					vNext.add(custom.getSex());
					vNext.add(custom.getLendcount());
					vNext.add(custom.getSumcount());
					String timestr;
					if (custom.getLogofftime() != null) {
						timestr = sdf.format(custom.getLogofftime());
					} else {
						timestr = "";
					}
					vNext.add(timestr);
					vNext.add(custom.getEid());
					customRowData.add(vNext);
				}
				customTable = new JTable(customRowData, customColumName);
				customTable.setBackground(SystemColor.info);
				customTable.setBounds(10, 36, 806, 377);
				customTable.setFont(new Font("幼圆", Font.PLAIN, 14));
				customTable.setEnabled(false);
				customTable.getColumnModel().getColumn(0).setPreferredWidth(160);
				customTable.getColumnModel().getColumn(1).setPreferredWidth(166);
				customTable.getColumnModel().getColumn(2).setPreferredWidth(80);
				customTable.getColumnModel().getColumn(3).setPreferredWidth(80);
				customTable.getColumnModel().getColumn(4).setPreferredWidth(160);
				customTable.getColumnModel().getColumn(5).setPreferredWidth(160);
				DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
				renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
				customTable.setDefaultRenderer(Object.class, renderer);
				customTable.setPreferredScrollableViewportSize(customTable.getSize());
				customTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				customScrollpane.setEnabled(false);
				customScrollpane.setBounds(10, 36, 806, 377);
				customScrollpane.setBackground(SystemColor.window);
				customScrollpane.add(customTable);
				customScrollpane.setViewportView(customTable);
				lookCustomPanel.add(customScrollpane);
				JOptionPane.showMessageDialog(mainFrame, "查询成功，共查出【" + customs.size() + "】条记录！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lookCustomContentbuttonButton.setFont(new Font("幼圆", Font.BOLD, 18));
		lookCustomContentbuttonButton.setBackground(SystemColor.inactiveCaptionBorder);
		lookCustomContentbuttonButton.setBounds(597, 0, 93, 28);
		lookCustomPanel.add(lookCustomContentbuttonButton);

		JPanel addCustomPanel = new JPanel();
		addCustomPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.add(addCustomPanel, "name_addCustomPanel");
		addCustomPanel.setLayout(null);

		JLabel lblAddCustomeName = new JLabel("客户姓名：");
		lblAddCustomeName.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddCustomeName.setBounds(273, 56, 93, 30);
		addCustomPanel.add(lblAddCustomeName);

		addCustomNameTextField = new JTextField();
		addCustomNameTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addCustomNameTextField.setColumns(10);
		addCustomNameTextField.setBounds(364, 57, 200, 30);
		addCustomPanel.add(addCustomNameTextField);

		JButton addCustomToDBButton = new JButton("添加");
		addCustomToDBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addCustomNameTextField.getText().isEmpty() || addCustomNameTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "客户姓名不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (!("男".equals(addCustomSexTextField.getText().trim())
						|| "女".equals(addCustomSexTextField.getText().trim()))) {
					JOptionPane.showMessageDialog(mainFrame, "客户性别只能为【男】或【女】！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					String name = addCustomNameTextField.getText().trim();
					String sex = addCustomSexTextField.getText().trim();
					int eid = Login.employeeid;
					Custom custom = new Custom(name, sex, eid);
					if (cs.addCustom(custom)) {
						JOptionPane.showMessageDialog(mainFrame, "【" + name + "】添加成功！", "提示",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + name + "】添加失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		addCustomToDBButton.setFont(new Font("幼圆", Font.BOLD, 18));
		addCustomToDBButton.setBackground(SystemColor.inactiveCaptionBorder);
		addCustomToDBButton.setBounds(325, 175, 93, 28);
		addCustomPanel.add(addCustomToDBButton);

		addCustomSexTextField = new JTextField();
		addCustomSexTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		addCustomSexTextField.setColumns(10);
		addCustomSexTextField.setBounds(364, 108, 200, 30);
		addCustomPanel.add(addCustomSexTextField);

		JLabel lblAddCustomSex = new JLabel("客户性别：");
		lblAddCustomSex.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblAddCustomSex.setBounds(273, 108, 93, 30);
		addCustomPanel.add(lblAddCustomSex);

		JButton clearAddCustomButton = new JButton("清空");
		clearAddCustomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomNameTextField.setText("");
				addCustomSexTextField.setText("");
			}
		});
		clearAddCustomButton.setFont(new Font("幼圆", Font.BOLD, 18));
		clearAddCustomButton.setBackground(SystemColor.inactiveCaptionBorder);
		clearAddCustomButton.setBounds(449, 175, 93, 28);
		addCustomPanel.add(clearAddCustomButton);

		JPanel deleteCustomPanel = new JPanel();
		deleteCustomPanel.setBackground(SystemColor.inactiveCaptionBorder);
		customContentPanel.add(deleteCustomPanel, "name_deleteCustomPanel");
		deleteCustomPanel.setLayout(null);

		JLabel lbldeleteCustomID = new JLabel("要删除的客户编号");
		lbldeleteCustomID.setBounds(335, 48, 144, 21);
		lbldeleteCustomID.setFont(new Font("幼圆", Font.PLAIN, 18));
		deleteCustomPanel.add(lbldeleteCustomID);

		deleteCustomIdTextField = new JTextField();
		deleteCustomIdTextField.setBounds(335, 83, 144, 27);
		deleteCustomIdTextField.setFont(new Font("幼圆", Font.PLAIN, 18));
		deleteCustomIdTextField.setColumns(10);
		deleteCustomIdTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				MySystemUtil.InputNumber(k);
			}
		});
		deleteCustomPanel.add(deleteCustomIdTextField);

		JButton deleteCustomNameButton = new JButton("删除");
		deleteCustomNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deleteCustomIdTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(mainFrame, "客户编号不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					int id = Integer.parseInt(deleteCustomIdTextField.getText());
					List<Custom> list = cs.getCustomByid(id);
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(mainFrame, "【" + id + "】不存在！", "提示", JOptionPane.WARNING_MESSAGE);
					} else if (list.get(0).getLogofftime() != null) {
						JOptionPane.showMessageDialog(mainFrame,
								"【" + id + "】已于【" + sdf.format(list.get(0).getLogofftime()) + "】销户！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else if (list.get(0).getLendcount() != 0) {
						JOptionPane.showMessageDialog(mainFrame, "【" + id + "】当前有DVD未归还，不能销户！", "提示",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Custom custom = list.get(0);
						int choose = JOptionPane.showConfirmDialog(mainFrame,
								"客户编号:【" + id + "】\n客户姓名:【" + custom.getName() + "】\n客户性别:【" + custom.getSex()
										+ "】\n当前借阅数量:【" + custom.getLendcount() + "】\n总借阅数量:【" + custom.getSumcount()
										+ "】\n删除后不可恢复，是否删除？",
								"提示", JOptionPane.YES_NO_OPTION);
						if (choose == 0) {
							if (cs.deleteCustom(custom)) {
								JOptionPane.showMessageDialog(mainFrame, "删除成功，【" + id + "】已销户！", "提示",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(mainFrame,
										"【" + id + "】销户失败！\n服务器异常！请联系管理员！\n tel：185 8148 5921", "提示",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		deleteCustomNameButton.setBounds(489, 47, 83, 63);
		deleteCustomNameButton.setFont(new Font("幼圆", Font.BOLD, 18));
		deleteCustomNameButton.setBackground(SystemColor.inactiveCaptionBorder);
		deleteCustomPanel.add(deleteCustomNameButton);

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
				int choose = JOptionPane.showConfirmDialog(mainFrame, "注销后返回登录页面，是否注销？", "提示",
						JOptionPane.YES_NO_OPTION);
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
				int choose = JOptionPane.showConfirmDialog(mainFrame, "是否退出系统？", "提示", JOptionPane.YES_NO_OPTION);
				if (choose == 0) {
					JOptionPane.showMessageDialog(mainFrame, "系统即将安全退出！", "提示", JOptionPane.INFORMATION_MESSAGE);
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
