package com.gwhcool.phonebook.entity;

import java.util.Date;

/**
 * 朋友实体
 * 
 * @author gwh
 *
 */
public class Friend {
	private int fid;
	private String name;
	private Date birthday;
	private String telephone;
	private int sex;
	private String qq;
	private String email;
	private String address;
	private int uid;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Friend() {
		super();
	}

	public Friend(String name, Date birthday, String telephone, int sex, String qq, String email, String address,
			int uid) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.telephone = telephone;
		this.sex = sex;
		this.qq = qq;
		this.email = email;
		this.address = address;
		this.uid = uid;
	}

}
