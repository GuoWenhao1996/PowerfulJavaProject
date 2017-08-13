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
 * ѡ�ι�����<br>
 * ���湦��:
 * <li>ͨ��ѧ�Ų�ѯѡ�����</li>
 * <li>ͨ���γ̺Ŵ�ӡѧ����Ϣ</li>
 * <li>���ѡ���ſγ̵�ѧ��</li>
 * <li>ɾ��ѡ��ָ���γ̵�ָ��ѧ��</li>
 * <li>ɾ��ѡ��ָ���γ̵�����ѧ��</li>
 * <li>������һ��</li>
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
		System.out.println("|          ѡ�ι���                             |");
		System.out.println("|                         |");
		System.out.println("| 1��ͨ��ѧ�Ų�ѯѡ�����                         |");
		System.out.println("| 2��ͨ���γ̺Ŵ�ӡѧ����Ϣ                     |");
		System.out.println("| 3�����ѡָ���γ̵�ѧ��                         |");
		System.out.println("| 4��ɾ��ѡ��ָ���γ̵�ָ��ѧ��             |");
		System.out.println("| 5��ɾ��ѡ��ָ���γ̵�����ѧ��             |");
		System.out.println("| 0��������һ��                                             |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println("��������Ų�����");
		String choose = sc.next();
		if ("1".equals(choose)) {
			System.out.println("������ѧ��ѧ�ţ�");
			String stuID = sc.next();
			int index = sms.findStudentByID(stuID);
			if (index == -1) {
				System.out.println("��ѧ�������ڣ�");
			} else if ("��ɾ��������".equals(listStu.get(sms.findStudentByID(stuID)).getStuName())) {
				System.out.println("��ѧ�������ڣ�");
			} else {
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
				sms.printStudentByIndex(index);
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				List<String> listCourseID = ems.findElectiveByStuID(stuID);
				for (String courseID : listCourseID) {
					cms.printCourseByIndex(cms.findCourseByID(courseID));
				}
				System.out.println("=====================================================");
			}
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println("������γ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("�˿γ̲����ڣ�");
			} else if ("��ȡ����".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("�˿γ̲����ڣ�");
			} else {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
			}
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println("������γ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("�˿γ̲����ڣ�");
			} else if ("��ȡ����".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("�˿γ̲����ڣ�");
			} else {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				List<String> list = new ArrayList<>();
				while (true) {
					System.out.println("�����ѡ�ε�ѧ��ѧ��(����end�������)��");
					String input = sc.next();
					if ("end".equals(input)) {
						break;
					} else if (sms.findStudentByID(input) == -1) {
						System.out.println("��ѧ�������ڣ�");
					} else if ("��ɾ��������".equals(listStu.get(sms.findStudentByID(input)).getStuName())) {
						System.out.println("��ѧ�������ڣ�");
					} else {
						if (list.contains(input)) {
							System.out.println("��ѧ�����ڼ����У�");
						} else {
							System.out.println("����ӣ�");
							list.add(input);
						}
					}
				}
				ems.addElective(courseID, list);
			}
			show(sc);
		} else if ("4".equals(choose)) {
			System.out.println("������γ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("�˿γ̲����ڣ�");
			} else if ("��ȡ����".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("�˿γ̲����ڣ�");
			} else {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
				System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
				String stuID = sc.next();
				index = sms.findStudentByID(stuID);
				if (index == -1) {
					System.out.println("��ѧ�������ڣ�");
				} else if ("��ɾ��������".equals(listStu.get(sms.findStudentByID(stuID)).getStuName())) {
					System.out.println("��ѧ�������ڣ�");
				} else if (!isElective(courseID, stuID)) {
					System.out.println("��ѧ��û��ѡ���ſγ�");
				} else {
					System.out.println("=====================================================");
					System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
					System.out.println("-----------------------------------------------------");
					sms.printStudentByIndex(index);
					System.out.println("=====================================================");
					System.out.println("ȷ��ɾ�����˲������ɻָ���(Y/N)��");
					String input = sc.next();
					if (input.equals("Y") || input.equals("y")) {
						ems.deleteElectiveByStuID(courseID, stuID);
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("δɾ����");
					}
				}
			}
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println("������γ̺ţ�");
			String courseID = sc.next();
			int index = cms.findCourseByID(courseID);
			if (index == -1) {
				System.out.println("�˿γ̲����ڣ�");
			} else if ("��ȡ����".equals(listCourse.get(cms.findCourseByID(courseID)).getCourseName())) {
				System.out.println("�˿γ̲����ڣ�");
			} else {
				System.out.println("=====================================================");
				System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
				System.out.println("-----------------------------------------------------");
				cms.printCourseByIndex(index);
				System.out.println("=====================================================");
				System.out.println("ѧ��\t\t����\t�Ա�\t����\t�༶");
				System.out.println("-----------------------------------------------------");
				List<String> listStuID = ems.findElectiveByCoursID(courseID);
				for (String stuID : listStuID) {
					sms.printStudentByIndex(sms.findStudentByID(stuID));
				}
				System.out.println("=====================================================");
				System.out.println("ȷ��ɾ�����˲������ɻָ���(Y/N)��");
				String input = sc.next();
				if (input.equals("Y") || input.equals("y")) {
					ems.deleteAllElective(courseID);
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("δɾ����");
				}
			}
			show(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.start(sc);
		} else {
			System.out.println("�����������������룡");
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
