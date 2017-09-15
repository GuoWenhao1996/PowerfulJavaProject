package com.chinasofti.sms.entity;

/**
 * 专业实体类
 * 
 * @author guowh
 *
 */
public class Profess {
	private int pro_id;// 专业id
	private String pro_no;// 专业号
	private String pro_name;// 专业名称
	private int pro_deptid;// 专业所属系别号
	private char pro_state;// 专业开设状态

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_no() {
		return pro_no;
	}

	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_deptid() {
		return pro_deptid;
	}

	public void setPro_deptid(int pro_deptid) {
		this.pro_deptid = pro_deptid;
	}

	public char getPro_state() {
		return pro_state;
	}

	public void setPro_state(char pro_state) {
		this.pro_state = pro_state;
	}

	public Profess() {
	}

	public Profess(int pro_id, String pro_no, String pro_name, int pro_deptid, char pro_state) {
		super();
		this.pro_id = pro_id;
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_deptid = pro_deptid;
		this.pro_state = pro_state;
	}

	@Override
	public String toString() {
		return "Profess [pro_id=" + pro_id + ", pro_no=" + pro_no + ", pro_name=" + pro_name + ", pro_deptid="
				+ pro_deptid + ", pro_state=" + pro_state + "]";
	}

}
