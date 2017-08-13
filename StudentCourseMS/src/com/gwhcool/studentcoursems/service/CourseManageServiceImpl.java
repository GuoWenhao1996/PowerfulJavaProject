package com.gwhcool.studentcoursems.service;

import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.util.DBUtil;
import com.gwhcool.studentcoursems.util.FileUtil;
/**
 * 课程管理接口实现类
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
		System.out.println("添加成功！系统分配给【" + course.getCourseName() + "】的课程号为：【" + newCourseID + "】");
	}

	@Override
	public void deleteCourse(int index) {
		list = db.getCourseList();
		// list_ele = db.getElectiveList();
		Course course = list.get(index);
		course.setCourseName("已取消！");
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
			System.out.println("查找的课程不存在！");
		} else {
			list = db.getCourseList();
			Course course = list.get(index);
			if (course.getCourseName().equals("已取消！")) {
			} else {
				System.out.println(course);
			}
		}
	}

	@Override
	public void printAllCourse() {
		list = db.getCourseList();
		System.out.println("=====================================================");
		System.out.println("课程号\t\t课程名\t\t课程描述");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			printCourseByIndex(i);
		}
		System.out.println("=====================================================");
	}
}
