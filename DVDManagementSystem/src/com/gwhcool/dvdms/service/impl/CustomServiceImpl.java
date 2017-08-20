package com.gwhcool.dvdms.service.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.CustomDao;
import com.gwhcool.dvdms.dao.impl.CustomDaoImpl;
import com.gwhcool.dvdms.entity.Custom;
import com.gwhcool.dvdms.service.CustomService;

/**
 * 客户 业务层实现类
 * 
 * @author gwh
 * @since 1.3
 */
public class CustomServiceImpl implements CustomService {
	private CustomDao cd = new CustomDaoImpl();

	@Override
	public List<Custom> getALLCustom() {
		return cd.getALLCustom();
	}

	@Override
	public List<Custom> getCustomByid(int id) {
		return cd.getCustomByid(id);
	}

	@Override
	public List<Custom> getCustomByName(String name) {
		return cd.getCustomByName(name);
	}

}
