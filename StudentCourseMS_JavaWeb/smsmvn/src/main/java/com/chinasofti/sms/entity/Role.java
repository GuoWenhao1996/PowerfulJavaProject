package com.chinasofti.sms.entity;

import java.io.Serializable;

/**
 * 角色实体类
 * 
 * @author guowh
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private int rid;
	private String name;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role() {
	}

	public Role(int rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", name=" + name + "]";
	}

}
