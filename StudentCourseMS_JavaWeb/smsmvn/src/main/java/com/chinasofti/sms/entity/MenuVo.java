package com.chinasofti.sms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树型菜单实体
 * 
 * @author guowh
 *
 */
public class MenuVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;// 节点ID
	private String text;// 显示节点文本。
	private int checked;// 表示该节点是否被选中。
	private int parentid;// 父节点id
	private List<MenuVo> children = new ArrayList<>();// 该节点的子节点

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public List<MenuVo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuVo> children) {
		this.children = children;
	}

	public MenuVo() {
	}

	public MenuVo(int id, String text, int checked, List<MenuVo> children) {
		super();
		this.id = id;
		this.text = text;
		this.checked = checked;
		this.children = children;
	}

	@Override
	public String toString() {
		return "MenuVo [id=" + id + ", text=" + text + ", checked=" + checked + ", children=" + children + "]";
	}

}
