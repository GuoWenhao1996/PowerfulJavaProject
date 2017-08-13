package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

/**
 * 课程管理窗口<br>
 * 界面功能:
 * <li>添加课程</li>
 * <li>删除课程</li>
 * <li>修改课程信息</li>
 * <li>返回上一级</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class CourseMangeWindow extends Window {

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|          课程管理                             |");
		System.out.println("|                         |");
		System.out.println("| 1、添加课程                                                 |");
		System.out.println("| 2、删除课程                                                 |");
		System.out.println("| 3、修改课程信息                                         |");
		System.out.println("| 0、返回上一级                                             |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println("请输入序号操作：");
		String choose = sc.next();
		if ("1".equals(choose)) {

		} else if ("2".equals(choose)) {
			WindowUtil.byebye(sc);
		} else if ("3".equals(choose)) {
			WindowUtil.byebye(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("输入有误，请重新输入！");
			show(sc);
		}
	}
}
