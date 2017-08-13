package com.gwhcool.studentcoursems.window;

import java.util.Scanner;
import java.util.Set;

import com.gwhcool.studentcoursems.entity.Student;
import com.gwhcool.studentcoursems.service.StudentManageService;
import com.gwhcool.studentcoursems.service.StudentManageServiceImpl;

/**
 * ѧ��������<br>
 * ���湦��:
 * <li>���ѧ��</li>
 * <li>ɾ��ѧ��</li>
 * <li>�޸�ѧ����Ϣ</li>
 * <li>��ѧ�Ų�ѯѧ����Ϣ</li>
 * <li>��������ѯѧ����Ϣ</li>
 * <li>���༶��ѯѧ����Ϣ</li>
 * <li>��ӡ����ѧ����Ϣ</li>
 * <li>������һ��</li>
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
		System.out.println("|          ѧ������                             |");
		System.out.println("|                         |");
		System.out.println("| 1�����ѧ��                                                 |");
		System.out.println("| 2��ɾ��ѧ��                                                 |");
		System.out.println("| 3���޸�ѧ����Ϣ                                         |");
		System.out.println("| 4����ѧ�Ų�ѯѧ����Ϣ                             |");
		System.out.println("| 5����������ѯѧ����Ϣ                             |");
		System.out.println("| 6�����༶��ѯѧ����Ϣ                             |");
		System.out.println("| 7����ӡ����ѧ����Ϣ                                 |");
		System.out.println("| 0��������һ��                                             |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println("��������Ų�����");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("������ѧ��������");
			String stuName = sc.next();
			System.out.println("�������Ա�");
			String stuGender = sc.next();
			System.out.println("���������䣺");
			int age = sc.nextInt();
			System.out.println("������༶��");
			String className = sc.next();
			Student student = new Student("", stuName, stuGender, age, className);
			sms.addStudent(student);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("������Ҫɾ��ѧ����ѧ�ţ�");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("ȷ��ɾ�����˲������ɻָ���(Y/N)��");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					sms.deleteStudent(index);
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("δɾ����");
				}
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("������Ҫ�޸�ѧ����ѧ�ţ�");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("������ѧ����������");
				String stuName = sc.next();
				System.out.println("���������Ա�");
				String stuGender = sc.next();
				System.out.println("�����������䣺");
				int age = sc.nextInt();
				System.out.println("�������°༶��");
				String className = sc.next();
				Student newInfo = new Student(stuID, stuName, stuGender, age, className);
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
				sms.printStudentByIndex(index);
				System.out.println(newInfo+"   <------����Ϣ");
				System.out.println("=====================================================");
				System.out.println("ȷ���޸ģ��˲������ɻָ���(Y/N)��");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					sms.updateStudent(index, newInfo);
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("δ�޸ģ�");
				}
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("������ѧ��ѧ�ţ�");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index != -1) {
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
			}
			sms.printStudentByIndex(index);
			System.out.println("=====================================================");
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println("������ѧ��������");
			String stuName = sc.next();
			Set<Integer> sets = sms.findStudentByName(stuName);
			sms.printStudentByIndex(sets);
			show(sc);
		} else if ("6".equals(choose)) {
			System.out.println("������༶���ƣ�");
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
			System.out.println("�����������������룡");
			show(sc);
		}
	}
}
