package com.chinasofti.sms.entity;

/**
 * 系别实体类
 * 
 * @author guowh
 *
 */
public class Depart {

	private int dep_id;// 系别id
	private String dep_no;// 系编号
	private String dep_name;// 系别名

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_no() {
		return dep_no;
	}

	public void setDep_no(String dep_no) {
		this.dep_no = dep_no;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public Depart() {
	}

	public Depart(int dep_id, String dep_no, String dep_name) {
		super();
		this.dep_id = dep_id;
		this.dep_no = dep_no;
		this.dep_name = dep_name;
	}

	@Override
	public String toString() {
		return "Depart [dep_id=" + dep_id + ", dep_no=" + dep_no + ", dep_name=" + dep_name + "]";
	}

}
