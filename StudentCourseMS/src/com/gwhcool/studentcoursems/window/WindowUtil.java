package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * 窗口工具类<br>
 * 定义窗口的一些公共操作
 * 
 * @author gwh
 * @since 1.2
 */
public final class WindowUtil {
	/**
	 * 调用结束窗口，然后退出程序
	 * 
	 * @param sc
	 *            接收器
	 */
	protected static void byebye(Scanner sc) {
		Window window = new ByeByeWindow();
		window.show(sc);
		System.exit(0);
	}

	/**
	 * 调用欢迎窗口，进入导航页面
	 * 
	 * @param sc
	 *            接收器
	 */
	public static void start(Scanner sc) {
		Window window = new WelcomeWindow();
		window.show(sc);
	}

	/**
	 * 调用学生管理窗口，进入学生管理页面
	 * 
	 * @param sc
	 *            接收器
	 */
	public static void studentMange(Scanner sc) {
		Window window = new StudentMangeWindow();
		window.show(sc);
	}

	/**
	 * 调用课程管理窗口，进入课程管理页面
	 * 
	 * @param sc
	 *            接收器
	 */
	public static void courseMange(Scanner sc) {
		Window window = new CourseMangeWindow();
		window.show(sc);
	}

	/**
	 * 调用选课管理窗口，进入选课管理页面
	 * 
	 * @param sc
	 *            接收器
	 */
	public static void electiveMange(Scanner sc) {
		Window window = new ElectiveMangeWindow();
		window.show(sc);
	}
}
