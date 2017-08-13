package com.gwhcool.studentcoursems.window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.service.CourseManageService;
import com.gwhcool.studentcoursems.service.CourseManageServiceImpl;
import com.gwhcool.studentcoursems.service.ElectiveManageService;
import com.gwhcool.studentcoursems.service.ElectiveManageServiceImpl;
import com.gwhcool.studentcoursems.service.StudentManageService;
import com.gwhcool.studentcoursems.service.StudentManageServiceImpl;
import com.gwhcool.studentcoursems.util.DBUtil;

/**
 * 选课管理窗口<br>
 * 界面功能:
 * <li>通过学号查询选课情况</li>
 * <li>通过课程号打印学生信息</li>
 * <li>添加选这门课程的学生</li>
 * <li>删除选择指定课程的指定学生</li>
 * <li>删除选择指定课程的所有学生</li>
 * <li>返回上一级</li>
 * 
 * @author gwh
 * @since 1.2
 *
 */
public class ElectiveMangeWindow extends Window {
	StudentManageService sms = new StudentManageServiceImpl();
	CourseManageService cms = new CourseManageServiceImpl();
	ElectiveManageService ems = new ElectiveManageServiceImpl();
	private DBUtil db = DBUtil.getInstance();
	private List<Student> listStu = db.getStudentList();
	private List<Course> listCourse = db.getCourseList();
	private List<Elective> listElective = db.getElectiveList();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|          选课管理                             |");
		System.out.println("|                         |");
		System.out.println("| 1、通过学号查询选课情况                         |");
		System.out.println("| 2、通过课程号打印学生信息                     |");
		System.out.println("| 3、添加选指定课程的学生                         |");
		System.out.println("| 4、删除选择指定课程的指定学生             |");
		System.out.println("| 5、删除选择指定课程的所有学生             |");
		System.out.println("| 0、返回上一级                                             |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println("请输入序号操作：");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("请输入学生学号：");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index == -1) {
				System.out.println("此学生不存在！");
			} else if ("已删除！！！".equals(listStu.get(sms.findStudentByID(stuID)).getStuName())) {
				System.out.println("此学生不存在！");
			} else {
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
				sms.printStudentByIndex(index);
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				List<String> listCourseID = ems.findElectiveByStuID(stuID);
				for (String courseID : listCourseID) {
					cms.printCourseByIndex(cms.findCourseByID(courseID));
				}
				System.out.println("=====================================================");
			}
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("请输入课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("此课程不存在！");
			} else if ("已取消！".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("此课程不存在！");
			} else {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("请输入课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("此课程不存在！");
			} else if ("已取消！".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("此课程不存在！");
			} else {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				List<String> list = new ArrayList<>();
				while (true) {
					System.out.println("请添加选课的学生学号(输入end结束添加)：");
					String input = sc.next();
					if ("end".equals(input)) {
						break;
					} else if (sms.findStudentByID(input) == -1) {
						System.out.println("此学生不存在！");
					} else if ("已删除！！！".equals(listStu.get(sms.findStudentByID(input)).getStuName())) {
						System.out.println("此学生不存在！");
					} else {
						if (list.contains(input)) {
							System.out.println("此学号已在集合中！");
						} else {
							System.out.println("已添加！");
							list.add(input);
						}
					}
				}
				ems.addElective(courseID, list);
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("请输入课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("此课程不存在！");
			} else if ("已取消！".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("此课程不存在！");
			} else {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
				System.out.println("请输入要删除的学生学号：");
				String stuID = sc.next();
				index = sms.findStudentByID(stuID);
				if (index == -1) {
					System.out.println("此学生不存在！");
				} else if ("已删除！！！".equals(listStu.get(sms.findStudentByID(stuID)).getStuName())) {
					System.out.println("此学生不存在！");
				} else if (!isElective(courseID, stuID)) {
					System.out.println("此学生没有选这门课程");
				} else {
					System.out.println("=====================================================");
					System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
					System.out.println("-----------------------------------------------------");
					sms.printStudentByIndex(index);
					System.out.println("=====================================================");
					System.out.println("确认删除？此操作不可恢复！(Y/N)：");
					String input = sc.next();
					if (input.equals("Y") || input.equals("y")) {
						ems.deleteElectiveByStuID(courseID, stuID);
						System.out.println("删除成功！");
					} else {
						System.out.println("未删除！");
					}
				}
			}
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println("请输入课程号：");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("此课程不存在！");
			} else if ("已取消！".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("此课程不存在！");
			} else {
				System.out.println("=====================================================");
				System.out.println("课程号\t\t课程名\t\t课程描述");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("学号\t\t姓名\t性别\t年龄\t班级");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
				System.out.println("确认删除？此操作不可恢复！(Y/N)：");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					ems.deleteAllElective(courseID);
					System.out.println("删除成功！");
				} else {
					System.out.println("未删除！");
				}
			}
			show(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("输入有误，请重新输入！");
			show(sc);
		}
	}

	private boolean isElective(String courseID, String stuID) {
		for (Elective elective : listElective) {
			if (elective.getCourseID().equals(courseID) && elective.getStuID().equals(stuID))
				return elective.isFlag();
		}
		return false;
	}

}
