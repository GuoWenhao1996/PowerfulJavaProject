package com.gwhcool.dvdms.service.impl;

import com.gwhcool.dvdms.dao.EmployeeDao;
import com.gwhcool.dvdms.dao.impl.EmployeeDaoImpl;
import com.gwhcool.dvdms.service.EmployeeService;
import com.gwhcool.dvdms.util.MySystemUtil;

/**
 * 员工管理业务层实现类
 * 
 * @author gwh
 * @since 1.1
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao ed = new EmployeeDaoImpl();

	@Override
	public int login(int id, String pwd) {
		String md5Pwd = MySystemUtil.md5Password(pwd);
		return ed.login(id, md5Pwd);
	}

}
