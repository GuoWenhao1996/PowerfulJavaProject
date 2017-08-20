package com.gwhcool.dvdms.service.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.EmployeeDao;
import com.gwhcool.dvdms.dao.impl.EmployeeDaoImpl;
import com.gwhcool.dvdms.entity.Employee;
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

	@Override
	public List<Employee> getALLEmployee() {
		return ed.getALLEmployee();
	}

	@Override
	public List<Employee> getEmployeeByid(int id) {
		return ed.getEmployeeByid(id);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return ed.getEmployeeByName(name);
	}

}
