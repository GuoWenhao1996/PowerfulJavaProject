package com.gwhcool.dvdms.entity;

import java.util.Date;

/**
 * 员工实体类
 * 
 * @author gwh
 * @version 1.1
 */
public class Employee {
	private int id;// 员工id
	private String name;// 姓名
	private String sex;// 性别
	private String password;// 密码
	private Date leavetime;// 离职时间
	private Date jointime;// 加入时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(Date leavetime) {
		this.leavetime = leavetime;
	}

	public Date getJointime() {
		return jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

	public Employee() {
		super();
	}

	public Employee(int id, String name, String sex, String password, Date leavetime, Date jointime) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.leavetime = leavetime;
		this.jointime = jointime;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", password=" + password + ", leavetime="
				+ leavetime + ", jointime=" + jointime + "]";
	}

}
