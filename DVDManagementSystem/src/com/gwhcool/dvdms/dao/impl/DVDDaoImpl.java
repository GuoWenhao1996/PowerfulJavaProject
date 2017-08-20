package com.gwhcool.dvdms.dao.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.DVDDao;
import com.gwhcool.dvdms.entity.DVD;
import com.gwhcool.dvdms.util.DBUtil;

/**
 * dvd dao层实现类
 * 
 * @author gwh
 * @since 1.2
 */
public class DVDDaoImpl implements DVDDao {

	DBUtil<DVD> db = new DBUtil<>();

	@Override
	public List<DVD> getALLDVD() {
		List<Object> list = DBUtil.operateDQL(DVD.class, "select * from dvd order by id asc");
		return db.changeObjListToTList(list);
	}

	@Override
	public List<DVD> getDVDByid(int id) {
		List<Object> list = DBUtil.operateDQL(DVD.class, "select * from dvd where id=? ", id);
		return db.changeObjListToTList(list);
	}

	@Override
	public List<DVD> getDVDByName(String name) {
		List<Object> list = DBUtil.operateDQL(DVD.class, "select * from dvd where name like ? order by name desc",
				"%" + name + "%");
		return db.changeObjListToTList(list);
	}

	@Override
	public boolean addDvd(DVD dvd) {
		return DBUtil.operateDML("insert into dvd (name,state,count,eid) values(?,?,?,?)", dvd.getName(),
				dvd.getState(), dvd.getCount(), dvd.getEid());
	}

	@Override
	public boolean deleteDvd(DVD dvd) {
		return DBUtil.operateDML("update dvd set state=?, undertime=? where id=?", dvd.getState(), dvd.getUndertime(),
				dvd.getId());
	}

}
