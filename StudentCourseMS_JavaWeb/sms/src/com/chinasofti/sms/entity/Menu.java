package com.chinasofti.sms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单实体类
 * 
 * @author guowh
 *
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mid;// 菜单id
	private String name;// 菜单名称
	private String url;// 菜单对应url
	private int parentid;// 属于哪个父级菜单
	private List<Menu> children = new ArrayList<>();// 该菜单的所有子集菜单

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Menu() {
	}

	public Menu(int mid, String name, String url, int parentid, List<Menu> children) {
		super();
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.parentid = parentid;
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", name=" + name + ", url=" + url + ", parentid=" + parentid + ", children="
				+ children + "]";
	}

}
