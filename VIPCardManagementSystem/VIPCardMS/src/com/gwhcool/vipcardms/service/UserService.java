package com.gwhcool.vipcardms.service;

import java.util.Date;
import java.util.List;

import com.gwhcool.vipcardms.dao.UserDao;
import com.gwhcool.vipcardms.entity.User;
import com.gwhcool.vipcardms.util.CardUtil;

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

	/**
	 * 根据uid查找到用户
	 * 
	 * @param uid
	 * @return
	 */
	public User getUserByUid(int uid) {
		return userDao.getUserByUid(uid);
	}

	/**
	 * 修改登录时间
	 * 
	 * @param date
	 *            此次登录的时间
	 * @param uid
	 *            用户id
	 */
	public void updateLoginTime(Date date, int uid) {
		userDao.updateLoginTime(date, uid);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param username
	 * @param name
	 * @param sex
	 * @param address
	 * @param telephone
	 * @param email
	 * @param creditcard
	 * @param uid
	 * @return 成功返回true
	 */
	public boolean updateInfo(String username, String name, String sex, String address, String telephone, String email,
			String creditcard, int uid) {
		return userDao.updateInfo(username, name, Integer.parseInt(sex), address, telephone, email, creditcard, uid);
	}

	/**
	 * 检查用户名是否可以使用
	 * 
	 * @param username
	 * @return true可以使用 或非法信息
	 */
	public String checkUsername(String username, int uid) {
		if (username.trim().length() == 0) {
			return "用户名不能为空！";
		} else {
			int count = userDao.checkUsername(username, uid);
			if (count == 0) {
				return "true";
			} else if (count == -1) {
				return "服务器异常";
			} else {
				return "用户名已被占用！";
			}
		}
	}

	/**
	 * 检查旧密码是否正确
	 * 
	 * @param username
	 * @return true可以使用 或非法信息
	 */
	public String checkPassword(String oldpassword, int uid) {
		if (oldpassword.length() == 0) {
			return "旧密码不能为空！";
		} else {
			int count = userDao.checkPassword(oldpassword, uid);
			if (count == 1) {
				return "true";
			} else if (count == -1) {
				return "服务器异常";
			} else {
				return "旧密码不正确！";
			}
		}
	}

	public boolean updatePassword(String passwordA, int uid) {
		return userDao.updatePassword(passwordA, uid);
	}

	public boolean reg(String username, String password, String name, String sex, String address, String telephone,
			String email, String creditcard) {
		Date time=new Date();
		List<User> users= userDao.getUserList();
		String cardid=CardUtil.getCardId(users.get(users.size()-1).getCardid());
		User user=new User(username, password, name, Integer.parseInt(sex), address, telephone, email, creditcard, 0, time, cardid, time, 0, 1);
		return userDao.reg(user);
	}

}
