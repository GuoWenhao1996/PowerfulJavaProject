package com.chinasofti.sms.entity;

/**
 * 选课结果实体类
 * 
 * @author guowh
 *
 */
public class Result {
	private int re_id;// 表id
	private int re_s_no;// 学号
	private int re_c_no;// 课程号
	private double re_score;// 分数

	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public int getRe_s_no() {
		return re_s_no;
	}

	public void setRe_s_no(int re_s_no) {
		this.re_s_no = re_s_no;
	}

	public int getRe_c_no() {
		return re_c_no;
	}

	public void setRe_c_no(int re_c_no) {
		this.re_c_no = re_c_no;
	}

	public double getRe_score() {
		return re_score;
	}

	public void setRe_score(double re_score) {
		this.re_score = re_score;
	}

	public Result() {
	}

	public Result(int re_id, int re_s_no, int re_c_no, double re_score) {
		super();
		this.re_id = re_id;
		this.re_s_no = re_s_no;
		this.re_c_no = re_c_no;
		this.re_score = re_score;
	}

	@Override
	public String toString() {
		return "Result [re_id=" + re_id + ", re_s_no=" + re_s_no + ", re_c_no=" + re_c_no + ", re_score=" + re_score
				+ "]";
	}

}
