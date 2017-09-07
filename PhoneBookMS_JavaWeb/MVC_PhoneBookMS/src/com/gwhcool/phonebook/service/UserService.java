package com.gwhcool.phonebook.service;

import com.gwhcool.phonebook.dao.UserDao;
import com.gwhcool.phonebook.entity.User;

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
		User user = userDao.getUserByUsername(username);
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
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

}
