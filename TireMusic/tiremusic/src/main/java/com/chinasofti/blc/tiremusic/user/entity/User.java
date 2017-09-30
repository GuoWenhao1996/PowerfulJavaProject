package com.chinasofti.blc.tiremusic.user.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int uid;
	private String uname;
	private String upassword;
	private String realname;
	private String uaddress;
	private String uemail;
	private String utelephone;
	private String uidnumber;
	private String avatar;
	private int ustate;
	private Date logindate;
	private int usersex;
	private Date userbirthday;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getUidnumber() {
		return uidnumber;
	}
	public void setUidnumber(String uidnumber) {
		this.uidnumber = uidnumber;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public int getUsersex() {
		return usersex;
	}
	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}
	public Date getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", realname=" + realname + ", upassword=" + upassword
				+ ", uaddress=" + uaddress + ", uemail=" + uemail + ", utelephone=" + utelephone + ", uidnumber="
				+ uidnumber + ", avatar=" + avatar + ", ustate=" + ustate + ", logindate=" + logindate + ", usersex="
				+ usersex + ", userbirthday=" + userbirthday + "]";
	}
	public User(String uname, String upassword, String realname,  String uaddress, String uemail,
			String utelephone, String uidnumber, String avatar, int ustate, Date logindate, int usersex,
			Date userbirthday) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.realname = realname;
		this.uaddress = uaddress;
		this.uemail = uemail;
		this.utelephone = utelephone;
		this.uidnumber = uidnumber;
		this.avatar = avatar;
		this.ustate = ustate;
		this.logindate = logindate;
		this.usersex = usersex;
		this.userbirthday = userbirthday;
	}
	public User(int uid, String uname, String upassword, String realname, String uaddress, String uemail,
			String utelephone, String uidnumber, String avatar, int ustate, Date logindate, int usersex,
			Date userbirthday) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.realname = realname;
		this.uaddress = uaddress;
		this.uemail = uemail;
		this.utelephone = utelephone;
		this.uidnumber = uidnumber;
		this.avatar = avatar;
		this.ustate = ustate;
		this.logindate = logindate;
		this.usersex = usersex;
		this.userbirthday = userbirthday;
	}
	
}
