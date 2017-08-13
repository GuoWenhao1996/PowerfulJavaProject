package com.gwhcool.studentcoursems.util;

import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;

public class DBUtil {
	private static DBUtil db = null;

	private List<Student> studentList = new ArrayList<>();
	private List<Course> courseList = new ArrayList<>();
	private List<Elective> electiveList = new ArrayList<>();

	private DBUtil() {
		studentList = FileUtil.fileToStudentObj();
		courseList = FileUtil.fileToCourseObj();
		electiveList = FileUtil.fileToElectiveObj();
	}

	public static DBUtil getInstance() {
		if (db == null) {
			synchronized (DBUtil.class) {
				if (db == null) {
					db = new DBUtil();
				}
			}
		}
		return db;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Elective> getElectiveList() {
		return electiveList;
	}

	public void setElectiveList(List<Elective> electiveList) {
		this.electiveList = electiveList;
	}

}
