package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.service.CourseManageService;
import com.gwhcool.studentcoursems.service.CourseManageServiceImpl;

/**
 * 课程管理窗口<br>
 * 界面功能:
 * <li>添加课程</li>
 * <li>删除课程</li>
 * <li>修改课程信息</li>
 * <li>按课程号查询课程信息</li>
 * <li>查询所有课程信息</li>
 * <li>返回上一级</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class CourseMangeWindow extends Window {

	CourseManageService cms = new CourseManageServiceImpl();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|          课程管理                             |");
		System.out.println("|                         |");
		System.out.println("| 1、添加课程                                                 |");
		System.out.println("| 2、删除课程                                                 |");
		System.out.println("| 3、修改课程信息                                         |");
		System.out.println("| 4、按课程号查询课程信息                         |");
		System.out.println("| 5、打印所有课程信息                                 |");
		System.out.println("| 0、返回上一级                                             |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println("请输入序号操作：");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("请输入课程名称：");
			String courseName = sc.next();
			System.out.println("请输入课程描述：");
			String courseDesc = sc.next();
			Course course = new Course("", courseName, courseDesc);
			cms.addCourse(course);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("请输入要删除课程的课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
			}
			cms.printCourseByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("确认删除？此操作不可恢复！(Y/N)：");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					cms.deleteCourse(index);
					System.out.println("删除成功！");
				} else {
					System.out.println("未删除！");
				}
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("请输入要修改课程的课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
			}
			cms.printCourseByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("请输入课程名称：");
				String courseName = sc.next();
				System.out.println("请输入课程描述：");
				String courseDesc = sc.next();
				Course newInfo = new Course(courseID, courseName, courseDesc);
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println(newInfo + "   <------新信息");
				System.out.println("=====================================================");
				System.out.println("确认修改？此操作不可恢复！(Y/N)：");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					cms.updateCourse(index, newInfo);
					System.out.println("修改成功！");
				} else {
					System.out.println("未修改！");
				}
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("请输入课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
			}
			cms.printCourseByIndex(index);
			System.out.println("=====================================================");
			show(sc);
		} else if ("5".equals(choose)) {
			cms.printAllCourse();
			show(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("输入有误，请重新输入！");
			show(sc);
		}
	}
}
