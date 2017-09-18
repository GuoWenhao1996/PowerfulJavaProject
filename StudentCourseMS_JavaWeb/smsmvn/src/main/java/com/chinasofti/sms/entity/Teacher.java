package com.chinasofti.sms.entity;

import java.util.Date;

/**
 * 教师实体类
 * 
 * @author guowh
 *
 */
public class Teacher {
	private int t_id;// 教师表id
	private String t_no;// 教师号
	private String t_name;// 教师姓名
	private String t_zip;// 身份证号码
	private Date t_date;// 入职日期
	private int t_depno;// 教师所在系

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_zip() {
		return t_zip;
	}

	public void setT_zip(String t_zip) {
		this.t_zip = t_zip;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public int getT_depno() {
		return t_depno;
	}

	public void setT_depno(int t_depno) {
		this.t_depno = t_depno;
	}

	public Teacher() {
	}

	public Teacher(int t_id, String t_no, String t_name, String t_zip, Date t_date, int t_depno) {
		super();
		this.t_id = t_id;
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_zip = t_zip;
		this.t_date = t_date;
		this.t_depno = t_depno;
	}

	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", t_no=" + t_no + ", t_name=" + t_name + ", t_zip=" + t_zip + ", t_date="
				+ t_date + ", t_depno=" + t_depno + "]";
	}

}
