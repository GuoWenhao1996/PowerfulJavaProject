package com.gwhcool.studentcoursems.entity;

import java.io.Serializable;

/**
 * ѡ��ʵ����
 * 
 * @author gwh
 * @version 1.0
 */
public class Elective implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseID;// �γ̺�
	private String stuID;// ѧ��

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public Elective() {
		super();
	}

	public Elective(String courseID, String stuID) {
		super();
		this.courseID = courseID;
		this.stuID = stuID;
	}

	@Override
	public String toString() {
		return "Elective [courseID=" + courseID + ", stuID=" + stuID + "]";
	}
}
