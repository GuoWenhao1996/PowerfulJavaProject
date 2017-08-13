package com.gwhcool.studentcoursems.window;

import java.util.Scanner;
import java.util.Set;

import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.service.StudentManageService;
import com.gwhcool.studentcoursems.service.StudentManageServiceImpl;

/**
 * 学生管理窗口<br>
 * 界面功能:
 * <li>添加学生</li>
 * <li>删除学生</li>
 * <li>修改学生信息</li>
 * <li>按学号查询学生信息</li>
 * <li>按姓名查询学生信息</li>
 * <li>按班级查询学生信息</li>
 * <li>打印所有学生信息</li>
 * <li>返回上一级</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class StudentMangeWindow extends Window {
	StudentManageService sms = new StudentManageServiceImpl();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|          学生管理                             |");
		System.out.println("|                         |");
		System.out.println("| 1、添加学生                                                 |");
		System.out.println("| 2、删除学生                                                 |");
		System.out.println("| 3、修改学生信息                                         |");
		System.out.println("| 4、按学号查询学生信息                             |");
		System.out.println("| 5、按姓名查询学生信息                             |");
		System.out.println("| 6、按班级查询学生信息                             |");
		System.out.println("| 7、打印所有学生信息                                 |");
		System.out.println("| 0、返回上一级                                             |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println("请输入序号操作：");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("请输入学生姓名：");
			String stuName = sc.next();
			System.out.println("请输入性别：");
			String stuGender = sc.next();
			System.out.println("请输入年龄：");
			int age = sc.nextInt();
			System.out.println("请输入班级：");
			String className = sc.next();
			Student student = new Student("", stuName, stuGender, age, className);
			sms.addStudent(student);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("请输入要删除学生的学号：");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("确认删除？此操作不可恢复！(Y/N)：");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					sms.deleteStudent(index);
					System.out.println("删除成功！");
				} else {
					System.out.println("未删除！");
				}
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("请输入要修改学生的学号：");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("请输入学生新姓名：");
				String stuName = sc.next();
				System.out.println("请输入新性别：");
				String stuGender = sc.next();
				System.out.println("请输入新年龄：");
				int age = sc.nextInt();
				System.out.println("请输入新班级：");
				String className = sc.next();
				Student newInfo = new Student(stuID, stuName, stuGender, age, className);
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
				sms.printStudentByIndex(index);
				System.out.println(newInfo+"   <------新信息");
				System.out.println("=====================================================");
				System.out.println("确认修改？此操作不可恢复！(Y/N)：");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					sms.updateStudent(index, newInfo);
					System.out.println("修改成功！");
				} else {
					System.out.println("未修改！");
				}
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("请输入学生学号：");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			System.out.println("=====================================================");
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println("请输入学生姓名：");
			String stuName = sc.next();
			Set<Integer> sets = sms.findStudentByName(stuName);
			sms.printStudentByIndex(sets);
			show(sc);
		} else if ("6".equals(choose)) {
			System.out.println("请输入班级名称：");
			String className = sc.next();
			Set<Integer> sets = sms.findStudentByClassName(className);
			sms.printStudentByIndex(sets);
			show(sc);
		} else if ("7".equals(choose)) {
			sms.printAllStudent();
			show(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("输入有误，请重新输入！");
			show(sc);
		}
	}
}
