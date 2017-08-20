package com.gwhcool.dvdms.entity;

import java.util.Date;

/**
 * DVD实体
 * 
 * @author gwh
 * @since 1.2
 */
public class DVD {
	private int id;// dvd ID
	private String name;// 名称
	private String state;// 状态
	private int count;// 剩余数量
	private Date undertime;// 下架时间
	private int eid;// 上架员工的id

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getUndertime() {
		return undertime;
	}

	public void setUndertime(Date undertime) {
		this.undertime = undertime;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public DVD() {
		super();
	}

	public DVD(int id, String name, String state, int count, Date undertime, int eid) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.count = count;
		this.undertime = undertime;
		this.eid = eid;
	}

	public DVD(String name, String state, int count, int eid) {
		super();
		this.name = name;
		this.state = state;
		this.count = count;
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "DVD [id=" + id + ", name=" + name + ", state=" + state + ", count=" + count + ", undertime=" + undertime
				+ ", eid=" + eid + "]";
	}
}
