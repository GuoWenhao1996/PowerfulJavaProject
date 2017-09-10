package com.gwhcool.vipcardms.service;

import java.util.List;

import com.gwhcool.vipcardms.dao.UserDao;
import com.gwhcool.vipcardms.entity.User;

/**
 * 用户服务层
 * 
 * @author gwh
 *
 */
public class AdminService {
	UserDao userDao = new UserDao();
	public List<User> queryAllUser() {
		return userDao.getUserList();
	}
	public List<User> queryUserByType(String cardtype) {
		return userDao.getUserList(Integer.parseInt(cardtype));
	}

}
