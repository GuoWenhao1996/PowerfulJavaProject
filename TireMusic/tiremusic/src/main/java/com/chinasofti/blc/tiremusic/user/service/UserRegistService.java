package com.chinasofti.blc.tiremusic.user.service;

import java.util.Date;

import com.chinasofti.blc.tiremusic.user.dao.UserRegisterDao;

public class UserRegistService {
	private UserRegisterDao userRegisterDao = new UserRegisterDao();
	/**
	 * 注册
	 * @param uname
	 * @param realname
	 * @param upassword
	 * @param uaddress
	 * @param uemail
	 * @param utelephone
	 * @param uidnumber
	 * @param avatar
	 * @param logindate
	 * @param usersex
	 * @param userbirthday
	 * @return
	 */
	public boolean addUserDao(String uname,  String realname, String upassword, String uaddress, String uemail,String utelephone, String uidnumber, String avatar, Date logindate, int usersex,Date userbirthday){
		return userRegisterDao.addUserDao(uname, upassword, realname, uaddress, uemail, utelephone, uidnumber, avatar, logindate, usersex, userbirthday);
	}
	/**
	 * 验证用户民唯一
	 * @param uname
	 * @return
	 */
	public boolean regname(String uname) {
		return userRegisterDao.regname(uname);
	}
	/**
	 * 验证手机号唯一
	 * @param uname
	 * @return
	 */
	public boolean regutelephone(String utelephone) {
		return userRegisterDao.regutelephone(utelephone);
	}
	/**
	 * 验证身份证唯一
	 * @param uname
	 * @return
	 */
	public boolean reguidnumber(String uidnumber) {
		return userRegisterDao.reguidnumber(uidnumber);
	}
}
