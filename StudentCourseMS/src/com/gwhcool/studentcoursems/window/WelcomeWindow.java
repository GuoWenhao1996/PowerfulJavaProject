package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * 欢迎页窗口<br>
 * 界面功能:
 * <li>学生管理</li>
 * <li>课程管理</li>
 * <li>选课管理</li>
 * <li>退出系统</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class WelcomeWindow extends Window {

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|     欢迎使用gds学生管理系统           |");
		System.out.println("|                         |");
		System.out.println("| 1、学生管理                                                 |");
		System.out.println("| 2、课程管理                                                 |");
		System.out.println("| 3、选课管理                                                 |");
		System.out.println("| 0、退出                                                         |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println("请输入序号操作：");
		String choose = sc.next();
		if ("1".equals(choose)) {
			WindowUtil.studentMange(sc);
		} else if ("2".equals(choose)) {
			WindowUtil.courseMange(sc);
		} else if ("3".equals(choose)) {
			WindowUtil.electiveMange(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println("输入有误，请重新输入！");
			show(sc);
		}
	}
}
