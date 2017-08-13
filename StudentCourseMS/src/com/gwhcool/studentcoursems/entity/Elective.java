package com.gwhcool.studentcoursems.entity;

import java.io.Serializable;

/**
 * 选课实体类
 * 
 * @author gwh
 * @version 1.0
 */
public class Elective implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseID;// 课程号
	private String stuID;// 学号
	private boolean flag;// 是否选课

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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Elective() {
		super();
	}

	public Elective(String courseID, String stuID, boolean b) {
		super();
		this.courseID = courseID;
		this.stuID = stuID;
		this.flag = b;
	}

	@Override
	public String toString() {
		return "Elective [courseID=" + courseID + ", stuID=" + stuID + "]";
	}

}
