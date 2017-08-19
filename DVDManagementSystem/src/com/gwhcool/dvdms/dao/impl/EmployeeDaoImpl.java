package com.gwhcool.dvdms.dao.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.EmployeeDao;
import com.gwhcool.dvdms.entity.Employee;
import com.gwhcool.dvdms.util.DBUtil;

/**
 * 员工管理dao层实现类
 * 
 * @author gwh
 * @since 1.1
 */
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int login(int id, String pwd) {
		List<Object> list = DBUtil.operateDQL(Employee.class, "select * from employee where id=? and password=?", id,
				pwd);
		if (list == null)
			return -1;
		if (list.size() != 0) {
			if (((Employee) list.get(0)).getLeavetime() == null) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 0;
		}
	}

}
