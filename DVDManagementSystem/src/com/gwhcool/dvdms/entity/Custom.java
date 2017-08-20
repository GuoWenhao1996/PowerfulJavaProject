package com.gwhcool.dvdms.entity;

import java.util.Date;

/**
 * 客户实体类
 * 
 * @author gwh
 * @since 1.3
 */
public class Custom {
	private int id;// 客户id
	private String name;// 姓名
	private String sex;// 性别
	private int lendcount;// 当前借阅数量
	private int sumcount;// 总借阅数量
	private Date logofftime;// 销户时间
	private int eid;// 添加这个客户的员工的id

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

	public int getLendcount() {
		return lendcount;
	}

	public void setLendcount(int lendcount) {
		this.lendcount = lendcount;
	}

	public int getSumcount() {
		return sumcount;
	}

	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}

	public Date getLogofftime() {
		return logofftime;
	}

	public void setLogofftime(Date logofftime) {
		this.logofftime = logofftime;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Custom() {
		super();
	}

	public Custom(int id, String name, String sex, int lendcount, int sumcount, Date logofftime, int eid) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.lendcount = lendcount;
		this.sumcount = sumcount;
		this.logofftime = logofftime;
		this.eid = eid;
	}

	public Custom(String name, String sex, int eid) {
		super();
		this.name = name;
		this.sex = sex;
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Custom [id=" + id + ", name=" + name + ", sex=" + sex + ", lendcount=" + lendcount + ", sumcount="
				+ sumcount + ", logofftime=" + logofftime + ", eid=" + eid + "]";
	}

}
