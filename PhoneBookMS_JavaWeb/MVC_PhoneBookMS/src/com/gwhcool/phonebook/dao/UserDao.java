package com.gwhcool.phonebook.dao;

import java.util.List;

import com.gwhcool.phonebook.entity.User;
import com.gwhcool.phonebook.util.DBUtil;

/**
 * user表操作类
 * 
 * @author gwh
 *
 */
public class UserDao {
	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户对象或null
	 */
	public User getUserByUsername(String username) {
		List<Object> objs = DBUtil.operateDQL(User.class, "select * from user where username= ? ", username);
		if (objs.size() == 0) {
			return null;
		} else {
			return (User) objs.get(0);
		}
	}
}
