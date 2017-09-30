package com.chinasofti.blc.tiremusic.selectotheruser.entity;

import java.io.Serializable;

public class OtherUser implements Serializable{
public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getFanscount() {
		return fanscount;
	}
	public void setFanscount(int fanscount) {
		this.fanscount = fanscount;
	}
	
private String username;
private String avatar;
private int fanscount;
private int uid;
public OtherUser(String username, String avatar, int fanscount, int uid) {
	super();
	this.username = username;
	this.avatar = avatar;
	this.fanscount = fanscount;
	this.uid = uid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}

public OtherUser() {
	super();
}

}
