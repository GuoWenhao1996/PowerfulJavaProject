package com.chinasofti.sms.service;

import java.util.List;

import com.chinasofti.sms.dao.RoleDao;
import com.chinasofti.sms.entity.Role;

/**
 * 角色服务层
 * 
 * @author guowh
 *
 */
public class RoleService {
	RoleDao roleDao = new RoleDao();

	/**
	 * 调用dao层查询所有角色信息
	 * 
	 * @return
	 */
	public List<Role> queryAllRoles() {
		return roleDao.queryAllRoles();
	}
}
