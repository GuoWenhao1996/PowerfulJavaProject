package com.gwhcool.vipcardms.entity;

import java.util.Date;

/**
 * 用户实体
 * 
 * @author gwh
 *
 */
public class User {
	private int uid;// 用户id
	private String username;// 用户名
	private String password;// 密码
	private String name;// 真实姓名
	private int sex;// 性别
	private String address;// 地址
	private String telephone;// 电话
	private String email;// 邮箱
	private String creditcard;// 信用卡卡号
	private int count;// 积分
	private Date logintime;// 登录时间
	private String cardid;// 会员卡号
	private Date jointime;// 注册时间
	private Date leavetime;// 销卡时间
	private double money;// 余额
	private int cardtype;// 卡片类型

	public User() {
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public Date getJointime() {
		return jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

	public Date getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(Date leavetime) {
		this.leavetime = leavetime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getCardtype() {
		return cardtype;
	}

	public void setCardtype(int cardtype) {
		this.cardtype = cardtype;
	}

	public User(String username, String password, String name, int sex, String address, String telephone, String email,
			String creditcard, int count, Date logintime, String cardid, Date jointime, double money, int cardtype) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.creditcard = creditcard;
		this.count = count;
		this.logintime = logintime;
		this.cardid = cardid;
		this.jointime = jointime;
		this.money = money;
		this.cardtype = cardtype;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", creditcard="
				+ creditcard + ", count=" + count + ", logintime=" + logintime + ", cardid=" + cardid + ", jointime="
				+ jointime + ", leavetime=" + leavetime + ", money=" + money + ", cardtype=" + cardtype + "]";
	}

}
