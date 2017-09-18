package com.chinasofti.sms.service;

import java.util.List;

import com.chinasofti.sms.dao.DeptDao;
import com.chinasofti.sms.entity.Depart;

/**
 * 系别服务层
 * 
 * @author guowh
 *
 */
public class DeptService {
	DeptDao deptDao = new DeptDao();

	/**
	 * 调用dao层查询所有系信息
	 * 
	 * @return
	 */
	public List<Depart> queryAllDepts() {
		return deptDao.queryAllDepts();
	}
}
