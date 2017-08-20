package com.gwhcool.dvdms;

import java.awt.EventQueue;

import com.gwhcool.dvdms.window.Login;

/**
 * DV管理系统主入口
 * 
 * @author gwh
 * @since 1.2
 */
public class Start {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
