package com.chinasofti.sms.entity;

/**
 * 授课实体类
 * 
 * @author guowh
 *
 */
public class Clazz {

	private int cl_id;// 授课表id
	private int cl_c_no;// 课程号
	private int cl_t_no;// 教师号

	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}

	public int getCl_c_no() {
		return cl_c_no;
	}

	public void setCl_c_no(int cl_c_no) {
		this.cl_c_no = cl_c_no;
	}

	public int getCl_t_no() {
		return cl_t_no;
	}

	public void setCl_t_no(int cl_t_no) {
		this.cl_t_no = cl_t_no;
	}

	public Clazz() {
	}

	public Clazz(int cl_id, int cl_c_no, int cl_t_no) {
		super();
		this.cl_id = cl_id;
		this.cl_c_no = cl_c_no;
		this.cl_t_no = cl_t_no;
	}

	@Override
	public String toString() {
		return "Clazz [cl_id=" + cl_id + ", cl_c_no=" + cl_c_no + ", cl_t_no=" + cl_t_no + "]";
	}

}
