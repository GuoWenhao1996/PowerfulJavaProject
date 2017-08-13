package com.gwhcool.studentcoursems.entity;

import java.io.Serializable;

/**
 * 学生实体类
 * 
 * @author gwh
 * @since 1.0
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stuID;// 学号
	private String stuName;// 姓名
	private String stuGender;// 性别
	private int stuAge;// 年龄
	private String className;// 班级名称

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuGender() {
		return stuGender;
	}

	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student() {
		super();
	}

	public Student(String stuID, String stuName, String stuGender, int stuAge, String className) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.stuGender = stuGender;
		this.stuAge = stuAge;
		this.className = className;
	}

	@Override
	public String toString() {
		return stuID + "\t" + stuName + "\t" + stuGender + "\t" + stuAge + "\t" + className;
	}
}
