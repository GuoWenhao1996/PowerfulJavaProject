package com.chinasofti.blc.tiremusic.userManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.blc.tiremusic.auditingManage.entity.Auditing;
import com.chinasofti.blc.tiremusic.userManage.dao.UserManageDao;
import com.chinasofti.blc.tiremusic.userManage.entity.User;

public class UserManageService {
	UserManageDao userManageDao = new UserManageDao();
	
	/**
	 * 分页查询上传不良信息的用户
	 * @return
	 */
	public Map<String, Object> showUserPage(int pageNum, int pageSize){
		Map<String, Object> map = new HashMap<>();
		int total = userManageDao.showUser().size();
		List<User> list = userManageDao.showUserPage(pageSize, pageNum);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 查询上传不良信息的用户
	 * @return
	 */
	public List<User> showUser(){
		return userManageDao.showUser();
	}
	
	/**
	 * 用户状态更新
	 * @param uid
	 * @return
	 */
	public boolean updateUserState(int uid) {
		return userManageDao.updateUserState(uid);
	}
}
