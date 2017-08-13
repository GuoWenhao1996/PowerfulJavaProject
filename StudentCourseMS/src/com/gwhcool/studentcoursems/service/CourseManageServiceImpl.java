package com.gwhcool.studentcoursems.service;

import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;
/**
 * �γ̹���ӿ�ʵ����
 * 
 * @author gwh
 * @since 1.3
 */
public class CourseManageServiceImpl implements CourseManageService {

	private DBUtil db = DBUtil.getInstance();
	private List<Course> list = null;
	// private List<Elective> list_ele = null;

	@Override
	public void addCourse(Course course) {
		list = db.getCourseList();
		String lastCourseID = null;
		if (list.isEmpty()) {
			lastCourseID = "kc0000";
		} else {
			lastCourseID = list.get(list.size() - 1).getCourseID();
		}
		String lastID = lastCourseID.substring(2);
		int ID = Integer.parseInt(lastID) + 1;
		if (ID > 999) {
			lastID = "" + ID;
		} else if (ID > 99) {
			lastID = "0" + ID;
		} else if (ID > 9) {
			lastID = "00" + ID;
		} else {
			lastID = "000" + ID;
		}
		String newCourseID = "kc" + lastID;
		course.setCourseID(newCourseID);
		FileUtil.ObjToFile(course);
		list.add(course);
		System.out.println("��ӳɹ���ϵͳ�������" + course.getCourseName() + "���Ŀγ̺�Ϊ����" + newCourseID + "��");
	}

	@Override
	public void deleteCourse(int index) {
		list = db.getCourseList();
		// list_ele = db.getElectiveList();
		Course course = list.get(index);
		course.setCourseName("��ȡ����");
		FileUtil.ObjToFile(course);
		list.set(index, course);

		// FileUtil.deleteObjFile(course);
		// list.remove(index);
		// list_ele = FileUtil.fileToElectiveObj();

	}

	@Override
	public void updateCourse(int index, Course course) {
		list = db.getCourseList();
		FileUtil.ObjToFile(course);
		list.set(index, course);
	}

	@Override
	public int findCourseByID(String courseID) {
		list = db.getCourseList();
		for (Course course : list) {
			if (course.getCourseID().equals(courseID)) {
				return list.indexOf(course);
			}
		}
		return -1;
	}

	@Override
	public void printCourseByIndex(int index) {
		if (index == -1) {
			System.out.println("���ҵĿγ̲����ڣ�");
		} else {
			list = db.getCourseList();
			Course course = list.get(index);
			if (course.getCourseName().equals("��ȡ����")) {
			} else {
				System.out.println(course);
			}
		}
	}

	@Override
	public void printAllCourse() {
		list = db.getCourseList();
		System.out.println("=====================================================");
		System.out.println("�γ̺�\t\t�γ���\t\t�γ�����");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			printCourseByIndex(i);
		}
		System.out.println("=====================================================");
	}
}
