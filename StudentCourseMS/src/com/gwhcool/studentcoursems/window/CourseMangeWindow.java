package com.gwhcool.studentcoursems.window;

import java.util.Scanner;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.service.CourseManageService;
import com.gwhcool.studentcoursems.service.CourseManageServiceImpl;

/**
 * �γ̹�����<br>
 * ���湦��:
 * <li>��ӿγ�</li>
 * <li>ɾ���γ�</li>
 * <li>�޸Ŀγ���Ϣ</li>
 * <li>���γ̺Ų�ѯ�γ���Ϣ</li>
 * <li>��ѯ���пγ���Ϣ</li>
 * <li>������һ��</li>
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
		System.out.println("|          �γ̹���                             |");
		System.out.println("|                         |");
		System.out.println("| 1����ӿγ�                                                 |");
		System.out.println("| 2��ɾ���γ�                                                 |");
		System.out.println("| 3���޸Ŀγ���Ϣ                                         |");
		System.out.println("| 4�����γ̺Ų�ѯ�γ���Ϣ                         |");
		System.out.println("| 5����ӡ���пγ���Ϣ                                 |");
		System.out.println("| 0��������һ��                                             |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println("��������Ų�����");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("������γ����ƣ�");
			String courseName = sc.next();
			System.out.println("������γ�������");
			String courseDesc = sc.next();
			Course course = new Course("", courseName, courseDesc);
			cms.addCourse(course);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("������Ҫɾ���γ̵Ŀγ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
			}
			cms.printCourseByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("ȷ��ɾ�����˲������ɻָ���(Y/N)��");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					cms.deleteCourse(index);
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("δɾ����");
				}
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("������Ҫ�޸Ŀγ̵Ŀγ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
			}
			cms.printCourseByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("������γ����ƣ�");
				String courseName = sc.next();
				System.out.println("������γ�������");
				String courseDesc = sc.next();
				Course newInfo = new Course(courseID, courseName, courseDesc);
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println(newInfo + "   <------����Ϣ");
				System.out.println("=====================================================");
				System.out.println("ȷ���޸ģ��˲������ɻָ���(Y/N)��");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					cms.updateCourse(index, newInfo);
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("δ�޸ģ�");
				}
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("������γ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
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
			System.out.println("�����������������룡");
			show(sc);
		}
	}
}
