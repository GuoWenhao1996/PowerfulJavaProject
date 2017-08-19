package com.gwhcool.dvdms.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class Login {

	private JFrame loginFrame;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		loginFrame.setTitle("\u767B\u5F55                                 DVD\u7BA1\u7406\u7CFB\u7EDF");
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setResizable(false);
		
		JLabel label = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		label.setBounds(113, 93, 91, 29);
		loginFrame.getContentPane().add(label);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("幼圆", Font.BOLD, 16));
		usernameTextField.setBounds(197, 97, 133, 21);
		usernameTextField.setColumns(10);
		usernameTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				int keyChar = k.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

				} else {
					k.consume();
				}
			}
		});
		loginFrame.getContentPane().add(usernameTextField);

		JLabel label_1 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("幼圆", Font.BOLD, 16));
		label_1.setBounds(113, 131, 91, 29);
		loginFrame.getContentPane().add(label_1);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(197, 135, 133, 21);
		loginFrame.getContentPane().add(passwordTextField);

		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setBackground(new Color(191, 205, 219));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (passwordTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					String username = usernameTextField.getText();
					String password = passwordTextField.getText();
					if (username.equals("111")) {
						JOptionPane.showMessageDialog(null, "已离职员工不能登录！", "提示", JOptionPane.WARNING_MESSAGE);
					} else if (password.equals("222")) {
						JOptionPane.showMessageDialog(null, "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						loginFrame.setVisible(false);
						new MainFrame();
					} else {
						JOptionPane.showMessageDialog(null, "登录失败，请重试！", "提示", JOptionPane.ERROR_MESSAGE);
						passwordTextField.setText("");
					}
				}
			}
		});
		loginButton.setFont(new Font("幼圆", Font.BOLD, 24));
		loginButton.setBounds(180, 186, 110, 29);
		loginFrame.getContentPane().add(loginButton);

		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528DVD\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 30, 434, 42);
		loginFrame.getContentPane().add(lblNewLabel);
		loginFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { label, usernameTextField, passwordTextField, loginButton, label_1, lblNewLabel }));
		loginFrame.setVisible(true);

	}
}
