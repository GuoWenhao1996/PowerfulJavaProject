package com.chinasofti.sms.entity;

import java.util.Date;

/**
 * 开课信息实体类
 * 
 * @author guowh
 *
 */
public class CourseInfo {
	private int co_id;
	private int co_c_id;
	private int co_redit;
	private int co_time;
	private Date co_date;
	private char co_state;
	private int co_cstu;

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public int getCo_c_id() {
		return co_c_id;
	}

	public void setCo_c_id(int co_c_id) {
		this.co_c_id = co_c_id;
	}

	public int getCo_redit() {
		return co_redit;
	}

	public void setCo_redit(int co_redit) {
		this.co_redit = co_redit;
	}

	public int getCo_time() {
		return co_time;
	}

	public void setCo_time(int co_time) {
		this.co_time = co_time;
	}

	public Date getCo_date() {
		return co_date;
	}

	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}

	public char getCo_state() {
		return co_state;
	}

	public void setCo_state(char co_state) {
		this.co_state = co_state;
	}

	public int getCo_cstu() {
		return co_cstu;
	}

	public void setCo_cstu(int co_cstu) {
		this.co_cstu = co_cstu;
	}

	public CourseInfo() {
	}

	public CourseInfo(int co_id, int co_c_id, int co_redit, int co_time, Date co_date, char co_state, int co_cstu) {
		super();
		this.co_id = co_id;
		this.co_c_id = co_c_id;
		this.co_redit = co_redit;
		this.co_time = co_time;
		this.co_date = co_date;
		this.co_state = co_state;
		this.co_cstu = co_cstu;
	}

	@Override
	public String toString() {
		return "CourseInfo [co_id=" + co_id + ", co_c_id=" + co_c_id + ", co_redit=" + co_redit + ", co_time=" + co_time
				+ ", co_date=" + co_date + ", co_state=" + co_state + ", co_cstu=" + co_cstu + "]";
	}

}
