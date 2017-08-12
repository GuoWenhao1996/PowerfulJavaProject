package com.gwhcool.studentcoursems.test;

import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.util.FileUtil;

/**
 * ������
 * 
 * @author gwh
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {

		/* ��ȡѧ��������� */
		List<Student> list1 = new ArrayList<>();
		list1 = FileUtil.fileToStudentObj();
		for (Student student : list1) {
			System.out.println(student);
		}

		/* ��ȡ�γ̶������ */
		List<Course> list2 = new ArrayList<>();
		list2 = FileUtil.fileToCourseObj();
		for (Course course : list2) {
			System.out.println(course);
		}

		/* ��ȡѡ�ζ������ */
		List<Elective> list3 = new ArrayList<>();
		list3 = FileUtil.fileToElectiveObj();
		for (Elective elective : list3) {
			System.out.println(elective);
		}

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
		// Student stu = new Student("1001", "����", "��", 22, "�ƿ�һ��");
		// Student stu1 = new Student("1002", "����", "Ů", 17, "�ƿ�һ��");
		// Student stu2 = new Student("1003", "����", "��", 21, "�ƿƶ���");
		// FileUtil.ObjToFile(stu);
		// FileUtil.ObjToFile(stu1);
		// FileUtil.ObjToFile(stu2);

	}
}
