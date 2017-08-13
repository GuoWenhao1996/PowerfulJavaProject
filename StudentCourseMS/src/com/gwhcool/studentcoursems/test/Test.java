package com.gwhcool.studentcoursems.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.service.CourseManageService;
import com.gwhcool.studentcoursems.service.CourseManageServiceImpl;
import com.gwhcool.studentcoursems.service.StudentManageService;
import com.gwhcool.studentcoursems.service.StudentManageServiceImpl;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;

/**
 * ������
 * 
 * @author gwh
 * @since 1.0
 */
public class Test {
	public static void main(String[] args) {

		/* ���ӿγ���Ϣ */
		CourseManageService cms = new CourseManageServiceImpl();
		cms.printAllCourse();

		Course course = new Course("kc000123323", "���ԭ��", "���ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ�����ԭ��");
		cms.addCourse(course);
		/* �޸Ŀγ���Ϣ */
//		cms.updateCourse(4, course);
		/* ɾ���γ���Ϣ */
//		cms.deleteCourse(1);
		/* ��ѯ�γ����� */
		int index = cms.findCourseByID("asdasdsa11");
		System.out.println(index);
		/* ��ӡ�γ���Ϣ */
		cms.printCourseByIndex(index);
		/* ��ӡȫ���γ���Ϣ */
		cms.printAllCourse();

		/* ��ӡ����ѧ����Ϣ���� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// sms.printAllStudent();

		/* ɾ��ѧ����Ϣ���� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// int index = sms.findStudentByID("zr2017080012");
		// System.out.println(index);
		// sms.deleteStudent(index);
		// sms.printStudentByIndex(index);

		/* �޸�ѧ����Ϣ���� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// Set<Integer> sets = sms.findStudentByName("����");
		// sms.printStudentByIndex(sets);
		// sms.updateStudent(0, new Student("zr2017080001", "����", "��", 22, "Javaһ��"));
		// sets = sms.findStudentByName("����");
		// sms.printStudentByIndex(sets);

		/* ���༶���Ҳ��� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// Set<Integer> sets = sms.findStudentByClassName("Javaһ��");
		// sms.printStudentByIndex(sets);

		/* ���������Ҳ��� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// Set<Integer> sets=sms.findStudentByName("����ѧ��");
		// sms.printStudentByIndex(sets);

		/* ��ѧ�Ų��Ҳ��� */
		// StudentManageService sms = new StudentManageServiceImpl();
		// int index = sms.findStudentByID("zr2017080001");
		// System.out.println(index);
		// sms.printStudentByIndex(index);

		/* ѧ�ű������ */
		// LocalDate ld = LocalDate.now();
		// String month = "";
		// if (ld.getMonthValue() < 10)
		// month = "0" + ld.getMonthValue();
		// else
		// month += ld.getMonthValue();
		// String newStudentID = "zr" + ld.getYear() + month + "0001";
		// System.out.println(newStudentID);

		/* ���ѧ������ */
		// DBUtil db = DBUtil.getInstance();
		// List<Student> list1 = db.getStudentList();
		// for (Student student : list1) {
		// System.out.println(student);
		// }
		// Student student = new Student("12312321", "����ѧ��3eqweqweasds", "��", 24,
		// "Javaһ��");
		// StudentManageService sms = new StudentManageServiceImpl();
		// sms.addStudent(student);
		// // for(int i=0;i<100;i++) {
		// // sms.addStudent(student);
		// // }
		// System.out.println("===========");
		// list1 = db.getStudentList();
		// for (Student s : list1) {
		// System.out.println(s);
		// }

		/* DBUtil��ѧ�����γ̡�ѡ��List���޸� */
		// DBUtil db = DBUtil.getInstance();
		// List<Student> list1 = db.getStudentList();
		// List<Course> list2 = db.getCourseList();
		// List<Elective> list3 = db.getElectiveList();
		// list1.add(new Student("0000", "����ѧ��", "��", 88, "�ƿ�����"));
		// list2.set(1, new Course("kc0002", "�����������������������",
		// "����������Ǽ����רҵѧ�����޵�һ��רҵ�����κͺ��Ŀγ̣����Ǻ����γ̡������ϵͳ��ȫ���������������������TCP/IP�����绥���������ۿγ̣��Լ�������γ���ơ���ʵ����ѧ���ڵ����пΡ�"));
		// list3.remove(0);
		// db.setStudentList(list1);
		// db.setCourseList(list2);
		// db.setElectiveList(list3);
		//
		// for (Student student : db.getStudentList()) {
		// System.out.println(student);
		// }
		// for (Course course : db.getCourseList()) {
		// System.out.println(course);
		// }
		// for (Elective elective : db.getElectiveList()) {
		// System.out.println(elective);
		// }

		/* DBUtil��ѧ�����γ̡�ѡ��List�Ļ�ȡ */
		// DBUtil db = DBUtil.getInstance();
		// List<Student> list1 = db.getStudentList();
		// List<Course> list2 = db.getCourseList();
		// List<Elective> list3 = db.getElectiveList();
		// for (Student student : list1) {
		// System.out.println(student);
		// }
		// for (Course course : list2) {
		// System.out.println(course);
		// }
		// for (Elective elective : list3) {
		// System.out.println(elective);
		// }

		/* ��ȡѧ��������� */
		// List<Student> list1 = new ArrayList<>();
		// list1 = FileUtil.fileToStudentObj();
		// for (Student student : list1) {
		// System.out.println(student);
		// }

		/* ��ȡ�γ̶������ */
		// List<Course> list2 = new ArrayList<>();
		// list2 = FileUtil.fileToCourseObj();
		// for (Course course : list2) {
		// System.out.println(course);
		// }

		/* ��ȡѡ�ζ������ */
		// List<Elective> list3 = new ArrayList<>();
		// list3 = FileUtil.fileToElectiveObj();
		// for (Elective elective : list3) {
		// System.out.println(elective);
		// }

		/* д��ѡ�ζ������ */
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

		/* д��γ̶������ */
		// Course course1 = new Course("kc0001", "Java �������",
		// "���γ̽�����Java���ԵĻ���֪ʶ��������ƵĻ���������ʹ��������������������ƵĻ�������Ӷ���������Java���Խ��г�����Ƶ�������Ϊ������������������ر���WebӦ��ϵͳ�����������û�����");
		// Course course2 = new Course("kc0002", "���������",
		// "����������Ǽ����רҵѧ�����޵�һ��רҵ�����κͺ��Ŀγ̣����Ǻ����γ̡������ϵͳ��ȫ���������������������TCP/IP�����绥���������ۿγ̣��Լ�������γ���ơ���ʵ����ѧ���ڵ����пΡ�");
		// Course course3 = new Course("kc0003", "�㷨�����ݽṹ",
		// "���ݽṹ�Ǽ����ѧ�Ƶ��㷨���ۻ����������Ƶļ�����������Ҫ�о���Ϣ���߼��ṹ������������ڼ�����еı�ʾ��ʵ�֡��������Ǽ����ѧ�Ƹ�רҵ�ĺ��Ŀγ̣������ѳ�Ϊ��������רҵ������ѡ�޿Ρ�");
		// FileUtil.ObjToFile(course1);
		// FileUtil.ObjToFile(course2);
		// FileUtil.ObjToFile(course3);

		/* д��ѧ��������� */
		// Student stu = new Student("zr2017080001", "����", "��", 22, "Javaһ��");
		// Student stu1 = new Student("zr2017080002", "����", "Ů", 17, "Javaһ��");
		// Student stu2 = new Student("zr2017080003", "����", "��", 21, "Java����");
		// FileUtil.ObjToFile(stu);
		// FileUtil.ObjToFile(stu1);
		// FileUtil.ObjToFile(stu2);

	}
}
