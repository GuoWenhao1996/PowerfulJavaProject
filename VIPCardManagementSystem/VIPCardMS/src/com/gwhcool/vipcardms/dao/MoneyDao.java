package com.gwhcool.vipcardms.dao;

import java.util.List;

import com.gwhcool.vipcardms.entity.Addlog;
import com.gwhcool.vipcardms.entity.Costlog;
import com.gwhcool.vipcardms.util.DBUtil;

/**
 * 余额操作类<br/>
 * 操作余额、充值表、消费表
 * 
 * @author gwh
 *
 */
public class MoneyDao {

	public boolean addmoney(int uid, double money, int count) {
		return DBUtil.operateDML("update user set money=money+?,count=count+? where uid=?", money, count, uid);
	}

	public boolean updateCardtype(int uid, int type) {
		return DBUtil.operateDML("update user set  cardtype=? where uid=?", type, uid);
	}

	public boolean insertLog(Addlog log) {
		return DBUtil.operateDML("insert into addlog (time,money,uid) values (?,?,?)", log.getTime(), log.getMoney(),
				log.getUid());
	}

	public List<Addlog> queryAddLogByUid(int uid) {
		List<Object> objs = DBUtil.operateDQL(Addlog.class, "select * from addlog where uid=? order by time desc", uid);
		DBUtil<Addlog> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

	public List<Addlog> queryAllAddLog() {
		List<Object> objs = DBUtil.operateDQL(Addlog.class, "select * from addlog order by time desc");
		DBUtil<Addlog> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

	public boolean insertLog(Costlog log) {
		return DBUtil.operateDML("insert into costlog (time,money,`desc`,uid) values (?,?,?,?)", log.getTime(),
				log.getMoney(), log.getDesc(), log.getUid());
	}

	public List<Costlog> queryCostLogByUid(int uid) {
		List<Object> objs = DBUtil.operateDQL(Costlog.class, "select * from costlog where uid=? order by time desc",
				uid);
		DBUtil<Costlog> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}

	public List<Costlog> queryAllCostLog() {
		List<Object> objs = DBUtil.operateDQL(Costlog.class, "select * from costlog order by time desc");
		DBUtil<Costlog> db = new DBUtil<>();
		return db.changeObjListToTList(objs);
	}
}
