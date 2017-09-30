package com.chinasofti.blc.tiremusic.user.service;

import java.util.Date;

import com.chinasofti.blc.tiremusic.user.dao.UserUpdateDao;
import com.chinasofti.blc.tiremusic.user.entity.User;

public class UserUpdateService {
	private UserUpdateDao userUpdateDao = new UserUpdateDao();
	public User newSession(int uid) {
		return userUpdateDao.newSession(uid);
	}
	public boolean updateUser(int uid,String uname, String realname, int usersex, String uaddress, String uemail,String utelephone, String uidnumber, Date userbirthday, String avatar) {
		return userUpdateDao.updateUser(uid,uname, realname, usersex, uaddress, uemail, utelephone, uidnumber, userbirthday, avatar);
	}
}
