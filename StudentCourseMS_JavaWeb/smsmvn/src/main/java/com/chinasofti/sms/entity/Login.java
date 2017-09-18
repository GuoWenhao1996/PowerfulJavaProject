package com.chinasofti.sms.entity;

import java.io.Serializable;

/**
 * 登录实体类
 * 
 * @author guowh
 *
 */
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;// 编号
	private String username;// 用户名
	private String password;// 密码
	private int state;// 状态
	private int usertype;// 用户类型

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public Login() {
	}

	public Login(int id, String username, String password, int state, int usertype) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.state = state;
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state
				+ ", usertype=" + usertype + "]";
	}

}
