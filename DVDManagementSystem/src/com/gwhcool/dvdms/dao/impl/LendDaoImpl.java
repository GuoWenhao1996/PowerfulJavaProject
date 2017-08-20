package com.gwhcool.dvdms.dao.impl;

import java.util.List;

import com.gwhcool.dvdms.dao.LendDao;
import com.gwhcool.dvdms.entity.Lend;
import com.gwhcool.dvdms.util.DBUtil;

public class LendDaoImpl implements LendDao {

	DBUtil<Lend> db = new DBUtil<>();

	@Override
	public List<Lend> getALLLend() {
		List<Object> list = DBUtil.operateDQL(Lend.class, "select * from lend order by lendtime desc");
		return db.changeObjListToTList(list);
	}

	@Override
	public List<Lend> getLendByDVDId(int id) {
		List<Object> list = DBUtil.operateDQL(Lend.class, "select * from lend where did=? order by lendtime desc", id);
		return db.changeObjListToTList(list);
	}

	@Override
	public List<Lend> getLendByCustomId(int id) {
		List<Object> list = DBUtil.operateDQL(Lend.class, "select * from lend where cid=? order by lendtime desc", id);
		return db.changeObjListToTList(list);
	}

	@Override
	public boolean addLend(Lend lend) {
		return DBUtil.operateDML("insert into lend (did,cid,lendtime) value(?,?,?)", lend.getDid(), lend.getCid(),
				lend.getLendtime());
	}

	@Override
	public boolean deleteLend(Lend lend) {
		return DBUtil.operateDML("update  lend  set backtime=? where did=? and cid=? and backtime is null", lend.getBacktime(),
				lend.getDid(), lend.getCid());
	}

}
