package com.chinasofti.sms.entity;

import java.util.Date;

/**
 * 学生实体类
 * 
 * @author guowh
 *
 */
public class Student {
	private int s_id;// 学生表id
	private String s_no;// 学号
	private String s_name;// 学生姓名
	private String s_zip;// 身份证号码
	private Date s_indate;// 入学年份
	private int s_dep_no;// 学生系别
	private int s_pro_id;// 学生专业

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_zip() {
		return s_zip;
	}

	public void setS_zip(String s_zip) {
		this.s_zip = s_zip;
	}

	public Date getS_indate() {
		return s_indate;
	}

	public void setS_indate(Date s_indate) {
		this.s_indate = s_indate;
	}

	public int getS_dep_no() {
		return s_dep_no;
	}

	public void setS_dep_no(int s_dep_no) {
		this.s_dep_no = s_dep_no;
	}

	public int getS_pro_id() {
		return s_pro_id;
	}

	public void setS_pro_id(int s_pro_id) {
		this.s_pro_id = s_pro_id;
	}

	public Student() {
	}

	public Student(int s_id, String s_no, String s_name, String s_zip, Date s_indate, int s_dep_no, int s_pro_id) {
		super();
		this.s_id = s_id;
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_zip = s_zip;
		this.s_indate = s_indate;
		this.s_dep_no = s_dep_no;
		this.s_pro_id = s_pro_id;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_no=" + s_no + ", s_name=" + s_name + ", s_zip=" + s_zip + ", s_indate="
				+ s_indate + ", s_dep_no=" + s_dep_no + ", s_pro_id=" + s_pro_id + "]";
	}

}
