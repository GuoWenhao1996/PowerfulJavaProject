package com.gwhcool.studentcoursems.test;

import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.util.FileUtil;

/**
 * 测试类
 * 
 * @author gwh
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {

		/* 读取学生对象测试 */
		List<Student> list1 = new ArrayList<>();
		list1 = FileUtil.fileToStudentObj();
		for (Student student : list1) {
			System.out.println(student);
		}

		/* 读取课程对象测试 */
		List<Course> list2 = new ArrayList<>();
		list2 = FileUtil.fileToCourseObj();
		for (Course course : list2) {
			System.out.println(course);
		}

		/* 读取选课对象测试 */
		List<Elective> list3 = new ArrayList<>();
		list3 = FileUtil.fileToElectiveObj();
		for (Elective elective : list3) {
			System.out.println(elective);
		}

		/* 写入选课对象测试 */
		// Elective elective1 = new Elective("kc0001", "1001");
		// Elective elective2 = new Elective("kc0002", "1001");
		// Elective elective3 = new Elective("kc0003", "1001");
		// Elective elective4 = new Elective("kc0001", "1002");
		// Elective elective5 = new Elective("kc0002", "1002");
		// Elective elective6 = new Elective("kc0002", "1003");
		// Elective elective7 = new Elective("kc0003", "1003");
		// FileUtil.ObjToFile(elective1);
		// FileUtil.ObjToFile(elective2);
		// FileUtil.ObjToFile(elective3);
		// FileUtil.ObjToFile(elective4);
		// FileUtil.ObjToFile(elective5);
		// FileUtil.ObjToFile(elective6);
		// FileUtil.ObjToFile(elective7);

		/* 写入课程对象测试 */
		// Course course1 = new Course("kc0001", "Java 程序设计",
		// "本课程讲解了Java语言的基本知识及程序设计的基本方法，使读者掌握面向对象程序设计的基本概念，从而具有利用Java语言进行程序设计的能力，为将来从事软件开发，特别是Web应用系统开发打下良好基础。");
		// Course course2 = new Course("kc0002", "计算机网络",
		// "计算机网络是计算机专业学生必修的一门专业基础课和核心课程，它是后续课程《计算机系统安全》、《网络管理技术》、《TCP/IP与网络互联》等理论课程，以及《网络课程设计》等实践教学环节的先行课。");
		// Course course3 = new Course("kc0003", "算法与数据结构",
		// "数据结构是计算机学科的算法理论基础和软件设计的技术基础，主要研究信息的逻辑结构及其基本操作在计算机中的表示和实现。它不仅是计算机学科各专业的核心课程，而且已成为其它理工科专业的热门选修课。");
		// FileUtil.ObjToFile(course1);
		// FileUtil.ObjToFile(course2);
		// FileUtil.ObjToFile(course3);

		/* 写入学生对象测试 */
		// Student stu = new Student("1001", "张三", "男", 22, "计科一班");
		// Student stu1 = new Student("1002", "李四", "女", 17, "计科一班");
		// Student stu2 = new Student("1003", "王五", "男", 21, "计科二班");
		// FileUtil.ObjToFile(stu);
		// FileUtil.ObjToFile(stu1);
		// FileUtil.ObjToFile(stu2);

	}
}
