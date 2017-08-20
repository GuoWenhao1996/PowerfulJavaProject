package com.gwhcool.dvdms.dao.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.CustomDao;
import com.gwhcool.dvdms.entity.Custom;
import com.gwhcool.dvdms.util.DBUtil;

/**
 * 客户 dao层实现类
 * 
 * @author gwh
 * @since 1.3
 */
public class CustomDaoImpl implements CustomDao {
	DBUtil<Custom> db = new DBUtil<>();

	@Override
	public List<Custom> getALLCustom() {
		List<Object> list = DBUtil.operateDQL(Custom.class,
				"select * from custom order by lendcount desc,sumcount desc");
		return db.changeObjListToTList(list);
	}

	@Override
	public List<Custom> getCustomByid(int id) {
		List<Object> list = DBUtil.operateDQL(Custom.class, "select * from custom where id=? ", id);
		return db.changeObjListToTList(list);
	}

	@Override
	public List<Custom> getCustomByName(String name) {
		List<Object> list = DBUtil.operateDQL(Custom.class,
				"select * from custom where name like ? order by lendcount desc", "%" + name + "%");
		return db.changeObjListToTList(list);
	}

	@Override
	public boolean addCustom(Custom custom) {
		return DBUtil.operateDML("insert into custom (name,sex,eid) values(?,?,?)", custom.getName(), custom.getSex(),
				custom.getEid());

	}

	@Override
	public boolean deleteCustom(Custom custom) {
		return DBUtil.operateDML("update custom set logofftime=? where id=?", custom.getLogofftime(), custom.getId());
	}

}
