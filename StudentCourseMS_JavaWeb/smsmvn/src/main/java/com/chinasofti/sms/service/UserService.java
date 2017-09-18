package com.chinasofti.sms.service;

import com.chinasofti.sms.dao.UserDao;
import com.chinasofti.sms.entity.Login;

/**
 * 用户服务层
 * 
 * @author gwh
 *
 */
public class UserService {
	UserDao userDao = new UserDao();

	/**
	 * 根据用户名和密码返回是否登录成功
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return true为登录成功
	 */
	public boolean login(String username, String password) {
		Login user = userDao.getUserByUsername(username);
		if (user == null) {
			return false;
		} else if (!user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户信息
	 */
	public Login getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	/**
	 * 修改密码
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean updatepassword(String username, String password) {
		return  userDao.updatepassword(username,password);
	}

}
