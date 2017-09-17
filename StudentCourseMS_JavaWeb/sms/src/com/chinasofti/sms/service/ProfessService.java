package com.chinasofti.sms.service;

import java.util.List;

import com.chinasofti.sms.dao.ProfessDao;
import com.chinasofti.sms.entity.Profess;

/**
 * 系别服务层
 * 
 * @author guowh
 *
 */
public class ProfessService {
	ProfessDao professDao = new ProfessDao();

	/**
	 * 调用dao层查询所有系信息
	 * 
	 * @return
	 */
	public List<Profess> queryAllProfessByDeptId(String deptId) {
		return professDao.queryAllProfessByDeptId(Integer.parseInt(deptId));
	}
}
