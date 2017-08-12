package com.gwhcool.studentcoursems.entity;

import java.io.Serializable;

/**
 * �γ�ʵ����
 * 
 * @author gwh
 * @since 1.0
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseID;// �γ̺�
	private String courseName;// �γ���
	private String courseDesc;// �γ�����

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public Course() {
		super();
	}

	public Course(String courseID, String courseName, String courseDesc) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", courseDesc=" + courseDesc + "]";
	}

}
